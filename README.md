# Catalina (Demo)
----

+ Requirements:
    + Java 8 JDK
    + Maven


----

+ Satisfying the requirements for stage one and stage two.

+ Maven structure project

+ Proper unit tests with JUnit4 support
    + One TestSuite with two test cases
    + test cases covering:
        + expected exception in invalid inputs
        + full execution from 1 to 100

+ Proper Git ignored file list for Java based project

+ Dynamic and changale strategies with reused looping execution structure

    + package `com.bowen.catalina.executor` for loop and execution framework

    + package `com.bowen.catalina.stratagy` for the definition and implementation of strategies for different stages

+ The main generating strategy: Just-In-Time
    + Go through the whole list one by one
    + Check all conditions and generate the output text on scene

+ Alternative generating strategy considered: Color-Marking
    + mark the necessary slots without run though all the numbers and conditions
    + Efficient method with less memory footprints for especially larger scale senarios, like for max number in 10000, 20000, or even max Integers.
    + Using array list of integers initialized in all zero as color-marking plates
    + color-marking the number in a different steps and strategies, eg.
        + eg. for multiples of 3, start from 3 with a step length in 3 and mark the target slot colored in last bit, 3, 6, 9, 12...
        + eg. for number text containing of 3, start from 3xx , and x3x and xx3, loop all the number and mark the target slot colored in last second bit
    + outputting text with bit operations to check the results 
    + In massive scale senario, multi-thread execution methods could be applied
    + Not implemented this time as 100 is relative small input number 