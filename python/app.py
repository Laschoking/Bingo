from flask import Flask

app=Flask(__name__)

@app.route('/')

def index():
  return "Hallo"

#@app.route("/hallo/<name>")
#def halle(name):
#		return render_template

app.run()

