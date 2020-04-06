# Raspberry Pi RGB Led Strip Remote Control #

This project aims to control a RGB LED light strip using IR Sensor, Raspberry pi, Lirc, Python and an Android App.

as from Kernel 4.19.42-v7+

I use a Raspberry Pi 2 with Kernel Version 4.19.97-v7+ (You can check your Kernel using `uname -a`).

##Steps##

1. Install and Configurate LIRC
2. Setup IR Sender and IR Receiver
3. Setup and run API with the help of Linux Screen
4. Install Android App
5. Ready


##1. Install and Configurate LIRC##

First of all the */boot/config.txt* need to be edited.

`sudo nano /boot/config.txt`

In this file you add these lines and save file (CTRL+o):
`dtoverlay=gpio-ir,gpio_pin=21`
`dtoverlay=gpio-ir-tx,gpio_pin=21`

The first line is for receiving codes and the second line is for sending codes.
It's Important that you only comment in the line that you want to use. When you want to receive codes comment only the first line in otherwise it wouldn't work. 
The pin *21* will be important in step 2.

Next you install lirc with the following comands:

`sudo apt-get update`
`sudo apt-get install lirc`

Then you need to change some lines in the `/etc/lirc/lirc_options.conf` file (Hardware.conf didn't exists anymore):

`[lircd]
driver = default
device = /dev/lirc0

[lircmd]
uinput = True`

Now reboot your system

`sudo reboot`

##2. Setup IR Sender and IR Receiver##

Connect your IR Receiver like in the picture below.