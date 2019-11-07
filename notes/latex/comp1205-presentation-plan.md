# Presentation Plan

## Technology behind autonomous cars

Currently, most self driving cars utilise both cameras and sensors. Tesla for example, has been using a combination of 12 ultrasonic sensors, 8 cameras and one forward facing radar [todo: include images].
This large amount of data is then fed to multiple different machine learning models, in order to achieve collision avoidance and lane keep assistance.

## Accelerated machine learning hardware

A CPU is very good at executing traditional algorithms, consisting of sequential instructions.

This is a great solution for most algorithms that require instructions to be executed one after the other. However, there are things some things that don't require waiting for the previous instruction to execute, one of them being machine learning.

Originally, instead of engineering a brand new processing unit, some computer scientists came up with an idea of utilising a GPU (which has hundreds of cores and is designed to run things in parallel) and running the parallel instructions on the GPU itself.

More specifically, the process of
