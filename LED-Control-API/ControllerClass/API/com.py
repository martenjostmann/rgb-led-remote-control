from flask import Flask, request
from logging import FileHandler, WARNING
import subprocess
import json
import os

app = Flask(__name__)

file_handler = FileHandler('errorlog.txt')
file_handler.setLevel(WARNING)

app.logger.addHandler(file_handler)

#API endpoint
@app.route('/api/v1/com/<string:code>', methods={'GET'})
def api_all(code):
    key = str(getkey('api_key.json'))
    authKey = request.headers.get('authHeader')

    if key == authKey:
        print ("Received code:" + code)
        print ("Authorization approved")
        ["irsend","SEND_ONCE","your-remote-name","your-code-to-send"]
        subprocess.call(["irsend", "SEND_ONCE", "ledcontrol", code])
        return str(code),200
    else:
        return ("Authorization failed"),401

def getkey(file):
    __location__ = os.path.realpath(
        os.path.join(os.getcwd(), os.path.dirname(__file__)))
    keyfile = open(os.path.join(__location__, file))
    keyfile = json.load(keyfile)
    return keyfile['key']

def main():
    #change this to Raspberry Pi IP-Address
    app.run(host='192.168.0.108')
    #uncomment this for localhost
    #app.run()


if __name__ == '__main__':
    main()
    
