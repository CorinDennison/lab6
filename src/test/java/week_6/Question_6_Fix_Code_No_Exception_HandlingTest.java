package week_6;

import org.junit.Test;
import test_utils.PrintUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by Clara on 8/3/17.
 *
 */

public class Question_6_Fix_Code_No_Exception_HandlingTest {
    
    
    @Test(timeout=3000)
    public void printLanguageList() throws Exception {
        
        try {
            
            // Check that code still prints the same output
            Question_6_Fix_Code_No_Exception_Handling q6 = new Question_6_Fix_Code_No_Exception_Handling();
            PrintUtils.catchStandardOut();   // Catch the program's output
            q6.printLanguageList();
            String out = PrintUtils.resetStandardOut();   // And save it, to check the program still prints the same data
            out = out.replace("\n", "");
            out = out.replace("\r", "");
            assertTrue("printLanguageList should still print the same 3 languages in the same order.",
                    out.contains("C#PythonJavaScript"));
            
        } catch (NoSuchElementException e) {
            // Ensure code does not crash
            fail("Check if the languages LinkedList is empty before removing elements from it");
        }
    }
    
    
    @Test(timeout=3000)
    public void wordCount() throws Exception {
        // Ensure code does not crash
        // Read source code to check for presence of try-catch block for the specific exception thrown
        
        try {
            Question_6_Fix_Code_No_Exception_Handling q6 = new Question_6_Fix_Code_No_Exception_Handling();
            int words = q6.wordCount("testing one two three");
            assertEquals("Make sure you don't change the behavior of wordCount. It should still count words.", 4, words);
            int nowords = q6.wordCount(null);
            assertEquals("wordCount should return 0 if sentence is null.", 0, nowords);
            
        } catch (NullPointerException npe) {
            fail("Check if the sentence is null before calling sentence.split()");
            
        }
        
    }
    
    
    @Test(timeout=3000)
    public void findTryCatch() throws Exception {
        
        // Read source code and check that try-catch statements have not been added
        // Not something that would be done in a commercial test :)
        String path = String.join(System.getProperty("file.separator"), "src", "main", "java", "week_6", "Question_6_Fix_Code_No_Exception_Handling.java");
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        
        
        Pattern nseePattern = Pattern.compile("catch.*\\(\\s*NoSuchElementException");
        Pattern npePattern = Pattern.compile("catch.*\\(\\s*NullPointerException");
        
        String line = reader.readLine();
        
        while (line != null) {
            
            Matcher nseeMatcher = nseePattern.matcher(line);
            Matcher npeMatcher = npePattern.matcher(line);
            
            assertFalse("The text \"catch (NoSuchElementException ... ) { ... }\" should not appear in your code for this problem. " +
                            "Your code should make checks to avoid an exception being thrown",
                    nseeMatcher.find());
            
            
            assertFalse("The text \"catch (NullPointerException ... ) { ... }\" should not appear in your code for this problem. " +
                            "Your code should make checks to avoid an exception being thrown",
                    npeMatcher.find());
            
            
            line = reader.readLine();
            
        }
    }
    
}
    
