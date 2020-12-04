# Lab 6

Note for all file-related programs: the tests will make temporary files in the temporary_directory_for_test_files folder. You can ignore these, or delete them. 
If your tests are failing then you can check these files to see what the tests are writing to a file, which may help debug your program.


### Question 1: Writing to a File

Write a program that uses the buffered classes to write out your name, your favorite color, and this class's code (2545) to a new file.   
Write one item per line.

Now, read in all the data, line by line, and display it.

Add try-catch blocks for IOException to the writing code, and the reading code. Recommended to use the try-with-resources version.


### Question 2: Write Recycling Report

You work for a recycling company.
You’d like to collect some statistics on how much each of the houses on a certain street is recycling.
Each house has to use crates for their recycling. Your program will count the number of crates set out by each house.

This street is a little unusual since it only has 8 houses, and the city planner
must have been a computer programmer, since the house numbers are 0, 1, 2, 3, 4, 5, 6, and 7.
(Hint – the house numbers are the same as array element indexes.)

Write a program that asks for the number of recycling crates set out by each house.
You should store, and process this data, in an **array**.
DON'T use an ArrayList or LinkedList!

Analyse your data and determine:
* How many recycling crates, in total, from all the houses on the street?
* What is the largest number of crates set out by any house?
* What is the smallest number of crates set out by any house?
* Which house had the most recycling? Display that house number.

Next, add code so that it writes the data as a report to a file. 
The report file will look something like this example,
Note that it should use "crate" for 1 crate, "crates" otherwise.

```
House 0 recycled 1 crate
House 1 recycled 2 crates
House 2 recycled 1 crate
House 3 recycled 2 crates
House 4 recycled 3 crates
House 5 recycled 3 crates
House 6 recycled 2 crates
House 7 recycled 1 crate

Total crates recycled: 15
```

Use try-catch blocks for IOException. Use the try-with-resources style.


### Question 3: Read Recycling Report

There is a file called recycling-report-main-street.txt in the root 
directory of this project. 

This file contains data for a much longer street. Again, the house numbers correspond to array or ArrayList indexes.
Read it into your program, analyze the data, and then display the numbers of the house(s) that recycled the most crates?

Make sure you use try-catch blocks for IOException.


### Question 4: Exception Handling

Java doesn't make you deal with possible NullPointerException,or ArrayIndexOutOfBoundsException in your code.
If these exceptions happen, and are not caught, your code crashes.
NullPointerException, ArrayIndexOutOfBoundsException, and several other exceptions, are called unchecked exceptions.

It's possible to add try-catch blocks for NullPointerException, and other unchecked exceptions.
You can also declare that a method throws NullPointerException.

But, Java insists that you deal with IOException – which is a checked exception - in some way.
The compiler checks that you have done something about code that can throw IOException.
You either have to surround your file IO code with a try-catch block, or declare that the method throws IOException.
If your method throws IOException, then a method that calls this method also has to add a try-catch block, or declare that it also throws IOException.

There are other checked exceptions, for example SQLException, which you'll see when we work with databases.

Java's decision to implement two types of exceptions (checked and unchecked) is unusual.
Other languages like C#, Python, JavaScript... have exceptions, but it's always up to you how to deal with them.
You are never required to add try-catch blocks or declare that a method throws a particular exception;
the responsibility is left to the programmer to implement whatever exception/error handling mechanism is appropriate.

Questions:

Considering many other languages don't require you to deal with exceptions,
think about why Java does make you deal with at least some types of errors/exceptions.

1. List at least 1 benefit of checked exceptions
2. List at least 2 negative consequences of checked exceptions
3. What is your opinion on Java's decision to use checked exceptions?

Usually, it's better to anticipate and try to prevent errors. Almost all unchecked exceptions can be
prevented (in theory) by careful programming.  And, many checked exceptions can also be prevented with careful coding.

It's more common for programmers to try to prevent unchecked exceptions (e.g. NullPointerException)
than to write a try-catch block for code that may throw that type of exception.

4. For unchecked exceptions, why is it usually better to anticipate and avoid errors when possible,
instead of using try-catch blocks? At least 2 reasons.

Questions on this subject are common in Java job interviews!


### Question 5: Fix Code with Exception Handling

This program has two example methods. Both throw exceptions when you run the code.

Fix by adding a try-catch block in each method.  Don't modify any of the existing code. Here, you will be adding new code.

For the printLanguageList method, add try-catch statements. 
In the catch block, print a message that the LinkedList is empty. You don't need to do anything else, just let the method return.

For the wordCount method, add try-catch statements so the NullPointerException thrown when the list is empty, is caught.
In the catch block, return 0. So if the sentence is null, your method will return 0.


### Question 6: Fix Loop, No Exception Handling

This question uses the same code as Question 5 in Question_5_Add_Exception_Handling.java

Instead of waiting for an exception and catching it, it is often better to try to prevent problems.

Can you think of a better way to stop this code crashing?

Modify the printLanguageList and wordCount methods so that both methods work correctly without using try-catch statements.


### Question 7 Write your Operating System's Name to a File in Another Directory

**The short version**:

Write the name of the operating system that's running this code, to a file
called `os.txt`. os.txt should be saved in the `data` directory of this project.

You can get find out how to get the name of your operating system by reading
http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

The /data/ directory has been created for you in the root directory of this project.

The file called `placeholder.file` in the data directory may be ignored, and should not affect this assignment.
The text in the file should explain why it's there.

Make sure you catch and handle any exceptions in the `writeOSName` method.

 Test your program on computer with a different operating system to yours.
 Try running your code at https://repl.it/languages/java10 - what OS does this use?

**The long version**:

All the code so far has assumed that we are working with a file in the root directory of your project.
But, a file could be anywhere on your system, so Java needs to support reading files anywhere on your
computer (and even on remote computers).

For example, your program want to work with many files, and want to organize them into directories.
Or, you've got different types of files, (maybe images, and text data files) and you'd like to organize
these files into an images directory, and a data directory.

For this question, write a program that creates and stores a file in the data directory. The file should be called
`os.txt` and should contain your computer's operating system name.

Linux, Max, and Unix-based computers use / to separate file components, e.g. /Bob/Documents/homework1.doc
 Windows uses backslashes \ to separate path components, e.g. \Bob\Documents\homework1.doc

 FileWriter can take a filename or path as an argument. If a filename is provided, it's assumed to be in the current working directory.
 So these may work on one computer, but error on another:
 
 new FileWriter fw = new FileWriter(“data/testing.txt”);   // Mac and Linux ok, PC Error
 new FileWriter fw = new FileWriter(“data\testing.txt”);   // Windows OK, Mac and Linux Error
 
 FileWriter can also take a File object as an argument, and a File object can store a path to a file
 elsewhere on your system (or even on a remote system).

 Here’s one way to create a File object on a Mac, Linux, Unix etc. system; using / as a file separator, for example,
 
 File f = new File(“mydirectory/mysubdirectory/textfile.txt”);   // But error on PC
 
 Or on a PC, which uses backslash as the file separator, for example,
 
 File f = new File(“mydirectory\mysubdirectory\textfile.txt”);   // But error on Mac and Linux

Assuming these directories exist, you can create and write `textfile.txt` file in this location.  The location
is relative to the root directory of your project.

But, there's a problem. If you write a forward slash, or backslash, your program will work fine on one system, but
crash on the other.

Java is architecture-neutral and the same code is supposed to run in the same way on PC and Mac and Linux,
and anything else a JVM can be installed on, like a TV, Android device, refrigerator, car, toaster...

Until we got to files, all of our code will run the same on any device, and we'd like to maintain this advantage
as we work with files.

There's two ways to handle this.

1. Java code can get information about the system it running on - system properties - which include the file
separator for the current system, the name and version of the operating system, and various others. You can get the
file separator and use it to build the file path String.

2. Or, a cleaner approach: create a File object with the File(parentDirectory, filename) constructor. For example,

File f = new File("mydirectory", "MyFileName.txt");

Java will check the system properties for you, and construct the correct path for the computer.

For more information, see the Java File documentation. https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/io/File.html

Note: In general, it is possible, but **not recommended**, to use absolute path names, for example

C:\program files\java\textfile.txt on Windows, or
/users/admin/Documents/textfile.txt on a Unix-based system like Linux or Mac.

But if you do that, your program will almost certainly not work on anyone else's computer.
And, the tests will fail when the grader runs them.
