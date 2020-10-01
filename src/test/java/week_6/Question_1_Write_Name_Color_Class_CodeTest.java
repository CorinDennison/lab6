package week_6;

import org.junit.Before;
import org.junit.Test;

import test_utils.PrintUtils;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Question_1_Write_Name_Color_Class_CodeTest {

    private File tempFileDirectory = new File("temporary_directory_for_test_files");

    @Before()
    public void ensureTempDirectoryExists() {
        tempFileDirectory.mkdir();
    }
    
    @Test(timeout=3000)
    public void testWriteToFile() {
        
        try {
            Question_1_Write_Name_Color_Class_Code q1 = new Question_1_Write_Name_Color_Class_Code();
    
            File tempFile = File.createTempFile("question1write", ".txt", tempFileDirectory);
            String filename = tempFile.getAbsolutePath();
            q1.writeToFile(filename, "alice", "blue", 2545);
    
            byte[] bytes = Files.readAllBytes(tempFile.toPath());
            String fileData = new String(bytes);
            
            fileData = fileData.trim().replace("\r", "").replace("\n", "");
            String expected = "aliceblue2545";
            
            assertEquals("Make sure you have written all the data, one item per line, " +
                    "Don't write anything else to the file." +
                    "\nMake sure you close the file when you are done writing" +
                    "\nCheck what is written for the class code. Is it 2524?", expected, fileData);
            
        } catch (IOException ioe) {
            fail("IOException with message " + ioe.getMessage() +
                    "\nCheck your writeToFile method, make sure it's creating a file, and closing the file once the data has been written. " +
                    "\nAnd, check for any errors it might throw");
        }
    }

    
    @Test(timeout=3000)
    public void testPrintDataFromFile()  {

        try {
            PrintUtils.catchStandardOut();
    
            Question_1_Write_Name_Color_Class_Code q1 = new Question_1_Write_Name_Color_Class_Code();
    
            File tempOutFile = File.createTempFile("question1read", ".txt", new File("temporary_directory_for_test_files"));
    
            FileWriter writer = new FileWriter(tempOutFile);
            writer.write("alice\nblue\n2545");
            writer.close();
    
            q1.printDataFromFile(tempOutFile.getPath());
            
            String out = PrintUtils.resetStandardOut();
            
            assertTrue("Print your name, from the file", out.contains("alice"));
            assertTrue("Print your favorite color, from the file", out.contains("blue"));
            assertTrue("Print this class code, from the file", out.contains("2545"));
        
            
        } catch (IOException ioe) {
            fail("IOException with message " + ioe.getMessage() +
                    "\nCheck your printDataFromFile method, make sure it's creating a file, " +
                    "and closing the file once the data has been read. " +
                    "\nAnd, check for any errors your method throws.");
        }
        
    }

    
    @Test(timeout=3000)
    public void testUsesTryCatchBlocks() throws Exception {

        // More accurately, check that the methods don't declare that they throw an exception.
        
        Class q1 = Class.forName("week_6.Question_1_Write_Name_Color_Class_Code");
        
        Method[] methods = q1.getDeclaredMethods();
        
        Arrays.stream(methods).forEach( m -> {
            String methodName = m.getName();
            assertEquals( methodName + " should not declare that it throws an exception. " +
                            "\nAdd try-catch blocks to your writeToFile and printDataFromFile methods. " +
                            "\nHandle any possible exceptions within the method.",
                    0, m.getExceptionTypes().length);
        });
    }


}