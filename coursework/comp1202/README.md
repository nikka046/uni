---
  title: COMP1202 - Coursework
  author: Dominik Tarnowski
---

# Installation

The code was tested on GNU/Linux, Ubuntu 19.10.

 * **JDK** - `sudo apt install openjdk-11-jdk`

## Unit Testing

To run one of the unit tests (`TestPart1, TestPart2, TestPart3`), run:

```bash
./test TestPart1
```

# Extension

I decided to pick the very last extension, based on saving and loading the full state of the simulation:

> You might want to allow the simulation to save out the current state of a simulation to a file so that
it can be reloaded and restarted at another time.

1. Save the current state

In order to save the current state.


## Running the extension

```bash
javac Administrator.java
java Administrator
```
or, as a single line: `javac Administrator.java; java Administrator`.


