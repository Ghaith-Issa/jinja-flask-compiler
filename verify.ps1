# miniFlask Compiler - acceptance check
#
# Runs the compiler end to end and asserts what it should produce.
# Usage:   powershell -ExecutionPolicy Bypass -File verify.ps1

$ErrorActionPreference = 'Continue'
$script:pass = 0
$script:fail = 0
$script:step = 0
$script:total = 9

function Check($name, $condition, $detail) {
    $script:step++
    $label = "[{0}/{1}] {2}" -f $script:step, $script:total, $name
    if ($condition) {
        $script:pass++
        Write-Host ("{0,-46} PASS  {1}" -f $label, $detail) -ForegroundColor Green
    } else {
        $script:fail++
        Write-Host ("{0,-46} FAIL  {1}" -f $label, $detail) -ForegroundColor Red
    }
}

# ---------- locate a JDK ----------
$jdk = $null
foreach ($candidate in @("$env:JAVA_HOME", "C:/Users/$env:USERNAME/.jdks/openjdk-25.0.1")) {
    if ($candidate -and (Test-Path "$candidate/bin/java.exe")) { $jdk = $candidate; break }
}
if (-not $jdk) {
    $found = Get-ChildItem "C:/Users/$env:USERNAME/.jdks", "C:/Program Files/Java" -Directory -ErrorAction SilentlyContinue |
             Where-Object { Test-Path "$($_.FullName)/bin/java.exe" } | Select-Object -First 1
    if ($found) { $jdk = $found.FullName }
}
if (-not $jdk) { Write-Host "No JDK found." -ForegroundColor Red; exit 1 }

$java  = "$jdk/bin/java.exe"
$javac = "$jdk/bin/javac.exe"
$cp    = "bin;dependencies/antlr-4.13.2-complete.jar"

Write-Host ""
Write-Host "=== miniFlask Compiler - verification ===" -ForegroundColor Cyan
Write-Host "JDK: $jdk"
Write-Host ""

# ---------- 1. compile ----------
$sources = (Get-ChildItem -Recurse -Filter *.java src).FullName
& $javac -encoding UTF-8 -cp dependencies/antlr-4.13.2-complete.jar -d bin @sources 2>&1 | Out-Null
Check "Compile Java sources" ($LASTEXITCODE -eq 0) "$($sources.Count) files"

# ---------- 2. the working project ----------
$out = & $java "-Dfile.encoding=UTF-8" -cp $cp Main --quiet 2>&1
$summary = ($out | Select-String "^Compiled").ToString()
$clean = $summary -match "0 syntax\s+0 semantic\s+5 page"
Check "Good project compiles cleanly" $clean $summary.Trim()

# ---------- 3. generated pages exist ----------
$expected = @("index.html","product_1.html","product_2.html","product_3.html","add_product.html")
$missing = $expected | Where-Object { -not (Test-Path "output/$_") }
Check "All 5 pages generated" ($missing.Count -eq 0) "output/"

# ---------- 4. no template markers survive ----------
$leftovers = Get-ChildItem output -Filter *.html |
             Where-Object { (Get-Content $_.FullName -Raw) -match '\{\{|\{%' }
Check "No leftover {{ }} or {% %}" ($leftovers.Count -eq 0) "$($leftovers.Count) file(s) with markers"

# ---------- 5. every local link resolves ----------
$broken = @()
$links = 0
foreach ($page in Get-ChildItem output -Filter *.html) {
    $html = Get-Content $page.FullName -Raw
    foreach ($m in [regex]::Matches($html, '(?:href|src)\s*=\s*"([^"]+)"')) {
        $target = $m.Groups[1].Value
        if ($target -match '^(https?:|//|#|mailto:|data:)') { continue }
        $links++
        if (-not (Test-Path "output/$target")) { $broken += "$($page.Name) -> $target" }
    }
}
Check "All local links resolve" ($broken.Count -eq 0) "$links links, $($broken.Count) broken"
$broken | ForEach-Object { Write-Host "        $_" -ForegroundColor Yellow }

# ---------- 6. companion files copied untouched ----------
$sameCss = (Get-FileHash "Testing Project/FlaskTestingApp/static/style.css").Hash -eq (Get-FileHash "output/style.css").Hash
$sameApp = (Get-FileHash "Testing Project/FlaskTestingApp/app.py").Hash -eq (Get-FileHash "output/app.py").Hash
Check "Companion files copied byte-for-byte" ($sameCss -and $sameApp) "app.py, style.css"

# ---------- 7. compiler_output artefacts ----------
$reports = @("ast_python.json","ast_jinja.json","semantic_report.txt","generation_log.txt")
$haveAll = ($reports | Where-Object { -not (Test-Path "compiler_output/$_") }).Count -eq 0
$jsonOk = $true
foreach ($f in @("ast_python.json","ast_jinja.json")) {
    try { $null = Get-Content "compiler_output/$f" -Raw | ConvertFrom-Json } catch { $jsonOk = $false }
}
Check "compiler_output/ complete, JSON valid" ($haveAll -and $jsonOk) "4 files"

# ---------- 8. the five semantic errors fire ----------
$demo = & $java "-Dfile.encoding=UTF-8" -cp $cp Main "Testing Project/SemanticErrorsDemo" 2>&1
$kinds = @("Undefined Variable","Type Error","Scope Error","Type Mismatch","Missing Flask Variable")
$reported = $kinds | Where-Object { $demo -match [regex]::Escape("[$_]") }
Check "All 5 error kinds detected" ($reported.Count -eq 5) "$($reported.Count)/5 kinds"
$kinds | Where-Object { $reported -notcontains $_ } | ForEach-Object {
    Write-Host "        missing: $_" -ForegroundColor Yellow
}

# rebuild the good project so the workspace is left clean
& $java "-Dfile.encoding=UTF-8" -cp $cp Main --quiet 2>&1 | Out-Null

# ---------- 9. live server: submit a form, expect regeneration ----------
$port = 8123
$server = Start-Process -FilePath $java `
    -ArgumentList '-Dfile.encoding=UTF-8','-cp',$cp,'Main','--serve','--port',$port,'--quiet' `
    -NoNewWindow -PassThru
Start-Sleep -Seconds 6

$serverOk = $false
$detail = "server did not start"
try {
    $before = (Invoke-WebRequest "http://localhost:$port/" -UseBasicParsing).Content
    $countBefore = ([regex]::Matches($before, '<h2>')).Count

    Invoke-WebRequest "http://localhost:$port/add_product.html" -Method POST `
        -Body "name=VerifyItem&price=42&description=added+by+verify.ps1&image=laptop.jpg" `
        -ContentType "application/x-www-form-urlencoded" `
        -MaximumRedirection 0 -UseBasicParsing -ErrorAction SilentlyContinue | Out-Null

    $after = Get-Content "output/index.html" -Raw          # read the FILE, not the response
    $countAfter = ([regex]::Matches($after, '<h2>')).Count
    $serverOk = ($countAfter -eq $countBefore + 1) -and ($after -match 'VerifyItem')
    $detail = "$countBefore -> $countAfter products on disk"
} catch {
    $detail = $_.Exception.Message
}
Check "Live server regenerates on form POST" $serverOk $detail

Stop-Process -Id $server.Id -Force -ErrorAction SilentlyContinue
Start-Sleep -Milliseconds 500
& $java "-Dfile.encoding=UTF-8" -cp $cp Main --quiet 2>&1 | Out-Null   # restore clean output

# ---------- summary ----------
Write-Host ""
if ($script:fail -eq 0) {
    Write-Host "Result: $($script:pass)/$($script:total) passed - everything works." -ForegroundColor Green
} else {
    Write-Host "Result: $($script:pass)/$($script:total) passed, $($script:fail) failed." -ForegroundColor Red
}
Write-Host ""
Write-Host "Open output/index.html in a browser to see the generated site."
Write-Host ""
exit $script:fail
