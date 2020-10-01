package week_6;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by clara on 8/3/17.
 */
public class Question_7_Write_Operating_System_Info_To_File_In_Data_DirectoryTest {
    

    @Test(timeout=3000)
    public void writeOSName()  {
        
        Question_7_Write_Operating_System_Info_To_File_In_Data_Directory q7 = new Question_7_Write_Operating_System_Info_To_File_In_Data_Directory()  ;
        
        q7.writeOSName();
        
        // Read file, verify contains correct OS name
        
        try {
            byte[] bytes = Files.readAllBytes((new File("data", "os.txt").toPath()));
            String fileContents = new String(bytes);
            String osName = System.getProperty("os.name");
            
            assertTrue("Write the operating system name to the file os.txt in the data directory.",
                    fileContents.contains(osName));
            
        } catch (FileNotFoundException f) {
            fail("os.txt File not found. Make sure your code creates a file called " +
                    "os.txt in the data directory of this project");
        } catch (IOException ioe) {
            fail("Error reading os.txt file. " + ioe.getMessage());
        }
        
    }
    
    @Test(timeout=3000)
    public void testUsesTryCatchBlocks() throws Exception {
        
        // More accurately, check that the methods don't declare that they throw an exception.
        
        Class q1 = Class.forName("week_6.Question_7_Write_Operating_System_Info_To_File_In_Data_Directory");
        
        Method[] methods = q1.getDeclaredMethods();
        
        Arrays.stream(methods).forEach(m -> {
            String methodName = m.getName();
            assertEquals( methodName + " should not declare that it throws an exception. " +
                            "\nAdd try-catch blocks to your writeOSName method. " +
                            "\nHandle any possible exceptions within the method.",
                    0, m.getExceptionTypes().length);
        });
    }
    
}