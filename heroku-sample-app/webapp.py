from flask import Flask

app = Flask(__name__)

@app.route("/")
def home():
    return "Hello, world!\n"

@app.route("/<name>")
def hello(name):
    return "Hello, " + name + "!\n"

if __name__ == "__main__":
    app.run()
