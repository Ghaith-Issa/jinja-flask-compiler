from flask import Flask, render_template, request

app = Flask(__name__)

products = [
    {
        "id": 1,
        "name": "Laptop",
        "price": 999
    }
]

@app.route("/")
def home():
    label = "Total: "
    total = 0
    summary = label + total
    count = len(products)
    first = count["id"]
    return render_template("broken.html", products=products)

@app.route("/report")
def report():
    if count > 0:
        step = 2
    return render_template("report.html", step=step)

@app.route("/checkout")
def checkout():
    return render_template("broken.html", grandTotal=undefined_total)
