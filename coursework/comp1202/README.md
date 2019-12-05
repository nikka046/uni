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

I decided to pick the extension that introduces prerequisites to each subject. It stops students from enrolling to courses if they haven't got all the prerequisites yet.

## Running the extension

```bash
javac Administrator.java
java Administrator mySchool.txt 500
```

This will run the extension with the `mySchool.txt` file and 500 iterations.

You'll notice that subject 6 (lab2) will always be the final certificate students obtain, as it requires all the other subject certificates to be complete first.
Basics (subject number 1) will always be done first, as all the other subjects require a certificate in basics before enrolling in them.

```java
Subject basics = new Subject(1, 1, 5);
Subject lab1 = new Subject(2, 2, 2, basics);
Subject arrays = new Subject(3, 1, 3, basics);
Subject algorithms = new Subject(4, 1, 1, basics, arrays);
Subject testing = new Subject(5, 1, 3, basics);
Subject lab2 = new Subject(6, 2, 2, basics, lab1, algorithms, testing);
```
