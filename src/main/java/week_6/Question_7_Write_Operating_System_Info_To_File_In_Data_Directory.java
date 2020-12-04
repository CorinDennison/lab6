package week_6;


/**
 *
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

 Linux, Max, and Unix-based computers use / to separate file path components, e.g. /Bob/Documents/homework1.doc
 Windows uses backslashes \ to separate file path components, e.g. C:\Bob\Documents\homework1.doc

 FileWriter can take a filename or path as an argument. A filename is assumed to be in the current working directory.
 So these may work on one computer, but error on another:
 
 new FileWriter fw = new FileWriter("data/testing.txt");   // Mac and Linux ok, PC may Error
 new FileWriter fw = new FileWriter("data\testing.txt");   // Windows OK, Mac and Linux Error
 
 FileWriter can also take a File object as an argument, and a File object can store a path to a file
 elsewhere on your system (or even on a remote system).

 Here’s one way to create a File object on a Mac, Linux, Unix etc. system; using / as a file path separator, for example,
 
 File f = new File("mydirectory/mysubdirectory/textfile.txt");   // But may error on PC
 
 Or on a PC, which uses backslash as the path separator, for example,
 
 File f = new File("mydirectory\mysubdirectory\textfile.txt");   // But error on Mac and Linux
 
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
 
 For more information, see the Java File documentation.
 https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/io/File.html
 
 Note: In general, it is possible, but **not recommended**, to use absolute path names, for example
 
 C:\program files\java\textfile.txt on Windows, or
 /users/admin/Documents/textfile.txt on a Unix-based system like Linux or Mac.
 
 but if you do that, your program will almost certainly not work on anyone else's computer.
 And, the tests will fail when the grader runs them.

 */

public class Question_7_Write_Operating_System_Info_To_File_In_Data_Directory {
    
    public static void main(String[] args) {
        writeOSName();
    }
    
    public static void writeOSName() {
        
        // TODO write the name of the operating system running this code to a file
        //  in the data directory called os.txt

        // Hint: https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

        // The file has to be written in the data directory of this project
        // Use System Properties to get the operating system name.
        // Remember this exact same code needs to work on a Mac/Linux and Windows computer without any modifications.
        
        // Handle any exceptions in this method. Do not declare that this method throws any exceptions.
        
        // If possible, test your code on two types of operating systems: Windows, and Mac/Linux.
        
    }
    
}
