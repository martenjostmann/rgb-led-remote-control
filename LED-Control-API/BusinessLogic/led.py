import sys
sys.path.insert(0, "/usr/lib/python3/dist-packages")
from gpiozero import LED

led = LED(17)
while True:
    on = input("LED einschalten: ")
    if on=="1":
        led.on()
    elif on=="0":
        led.off()