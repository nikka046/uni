# Lab 2 prep

1. The Linux kernel includes a piece of software called a scheduler, determining the process to execute next and how much processor time should be allocated to each process.
This way, the more prioritised tasks/processes will have the most CPU time allocated, allowing for them to execute quicker. 
This priority system uses two properties, the real-time priority and the niceness value to determine the order of execution. The niceness value is an integer between -20 and 19, defaulting at 0. The lower the value, the higher the priority of the process.
The nice command can be used to run a process with a forced niceness value, for example "nice -n -20 firefox" would run firefox in the highest priority.
The renice command can be used to change the niceness value of an already running process. This can be done given the process ID (PID) ("renice -n NICENESS_VALUE -p PID") or the process name ("renice -n NICENESS_VALUE -p PNAME").

2. Setting the priority to 19 would make it run with lowest priority value, allocating least CPU time to it.
3. Setting the priority to -20 would prioritise the process and give it the most CPU time.
4. In order to run a program in the background, add a "&" to the end of the command.

5. 

https://www.tecmint.com/set-linux-process-priority-using-nice-and-renice-commands/
