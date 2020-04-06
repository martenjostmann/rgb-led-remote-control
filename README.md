LED-Control

1. Goal
The goal of this Project is to control my LED lightning System by using and Android App

2. Reflections
What I need is to programm an Android App with basic function to control the LED System, an API to communicate with the backend and a backend with the business logic

the API should become a json File or only paramaters (Think about it later)
	-RESTful API with Flask


3. LIRC
	-Lirc is a Framework to setuop IR Remote Communication

	LIRC important commands
		-mode2 -d /dev/lirc0 #Tests the IR Connection (dtoverlay=gpio-ir,gpio_pin=21 - for receive task and dtoverlay=gpio-ir-tx,gpio_pin=21 - for send task) must stop Demon with command below (/boot/config.txt)
		-sudo /etc/init.d/lircd [start][stop][restart][status]
		-irsend SEND_ONCE ledcontrol KEY_F2 #sends code
	-explanation video: https://www.youtube.com/watch?v=pK6Rn8hp784&feature=youtu.be
