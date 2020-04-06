from flask import Flask
from logging import FileHandler, WARNING
import subprocess

app = Flask(__name__)

file_handler = FileHandler('errorlog.txt')
file_handler.setLevel(WARNING)

app.logger.addHandler(file_handler)

#API endpoint
@app.route('/api/v1/com/<string:code>', methods={'GET'})
def api_all(code):
    print ("Received code:" + code)
    subprocess.call(["irsend", "SEND_ONCE", "ledcontrol", code])
    return str(id)
    
  

if __name__ == '__main__':
    #change this to Raspberry Pi IP-Address
    app.run(host='192.168.0.108')

    #uncomment this for localhost
    #app.run()