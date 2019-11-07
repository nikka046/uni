# Lab 1 prep

1. Raspberry pi 3 is small computer running on a 4 core, 64 bit processor based on the ARM architecture. In terms of the IO, it is equipped with 40 GPIO pins, 4 USB ports, HDMI port, ethernet port, micro-SD slot, 3.5mm audio jack and two connectors used for a display and a camera. 

https://magpi.raspberrypi.org/articles/raspberry-pi-3-specs-benchmarks

2. An LED is a light emitting diode. When using it, you need to supply a minimum operating voltage that it requires, usually between 1.8V and 3.3V, however supplying slightly more such as 5V should be fine.
As it's a diode, it will only work in forward bias. You should also make sure to limit the current going through the LED by using a resistor, as otherwise the high current will cause it to burn.

3. An SPI is a serial peripheral Interface that allows for serial synchronous communication with peripherical devices. This allows for interfacing between microcontrollers/microprocessors and peripherical integrated circuits, often including shift registers, ADCs, DACs, sensors, and more. The data is synchronised on the rising or faling clock edge that is sent from the master to slave device. Due to two separate channels, both the master and slave devices can send and receive at the same time. There is also a chip select signal that is sent from the master to the slave, which is an indication from the master to the slave whether the slave is currently being used. This can be used to improve the battery usage on the device.

4. An LDR is a light dependent resistor, which changes its resistance (amount of current going across it) based on the light intensity. With most LDRs, the resistance is invesely proportional to the light intensity, meaning as the light intensity increases, the resistance decreases.

5. The ls command on its own just lists the directories and files in the current directory. 
The -l option specifies to use a long listing format, which shows the access rights, owner, date of last modification, and other metadata.

6. The cd command is simply used to change the current directory that the terminal session is currently operating in, relative to the current directory unless specified otherwise. For example, "cd .." would go to the parent directory, "cd /" would go to the root directory, and "cd ~" would go to the user's home directory.

7. The chmod command is used to change what's called the "file mode bits" which control the usage/access permissions of a given file. For example, a file could be made executable by typing "chmod +x filename.sh". The file mode bits can also be seen on the previously mentioned "ls -l" command, which will show a combination of "r", "w", "x" and "-", respectively meaning the file is readable, writable, executable, or none of them.

todo: table

8. Cat can be used to print file's content to the standard output (cat filename), create new files (cat >filename), append contents of one file to another (cat file1 >> file2).

9. The sudo command is used to gain root (administrator) access on a linux shell. It will prompt for the administrator's password and will run the given command with root permissions. This is sometimes required when accessing certain peripherals or making modifications to files belonging to the system.

10. writing "sudo chmod +x file" would make it executable, followed by "ls -l", which should include "x" in the access rights.

11. "./" is the current directory that the shell sessions is in. This can be used to change directories without typing the whole path but by writing it relative to the current directory. If you want to find out the full absolute path of the working directory, simply write "pwd".

12. Output:
"Hello world"
"Here is a number0.716498626944"

13.
```
#!/usr/bin/env python
from datetime import datetime
print “Hello world”
print “Current date: ” + str(datetime.now())
```


