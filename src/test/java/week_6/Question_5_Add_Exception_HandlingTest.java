package week_6;

import org.junit.Test;
import test_utils.PrintUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Clara on 8/3/17.
 *
 */


public class Question_5_Add_Exception_HandlingTest {
    
    @Test(timeout=3000)
    public void printLanguageList() throws Exception {
    
        // Ensure code does not crash
    
        // Check that code still prints the same output
    
        try {
        
            Question_5_Add_Exception_Handling q5 = new Question_5_Add_Exception_Handling();
        
            PrintUtils.catchStandardOut();   // Catch the program's output
        
            q5.printLanguageList();
        
            String out = PrintUtils.resetStandardOut();   // And save it, to chck the program still prints the same data
    
            out = out.replace("\n", "");
            out = out.replace("\r", "");
            assertTrue("printLanguageList should still print the same 3 languages in the same order.\n" +
                            "Don't print anything apart from the names of the languages from the list.",
                    out.contains("C#SwiftPython"));
    
            
        } catch (NoSuchElementException e) {
            fail("Add try-catch statements to catch the exception thrown in printLanguageList");
        }
    
    
    }
    
    @Test(timeout=3000)
    public void printLanguageListTryCatch() throws Exception {
        
        // Read source code and check that a try-catch statement has been added
        // Not something that would be done in a commercial test :)
        
        String path = String.join(System.getProperty("file.separator"), "src", "main", "java", "week_6", "Question_5_Add_Exception_Handling.java");
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        
        String line = reader.readLine();
        
        StringBuilder allLines = new StringBuilder();
        
        boolean inMethod = false;
        
        while (line != null) {
            
            if (line.contains("Start of printLanguageList.")) {
                inMethod = true;
            }
    
            if (line.contains("End of printLanguageList.")) {
                break;
            }
    
    
            if (inMethod) {
                allLines.append(line);
            }
    
            line = reader.readLine();
        
        }
        
        String allCode = allLines.toString();
        
        String pattern = "[\\S\\s]*catch.*\\(\\s*NoSuchElementException[\\S\\s]*";
        
        assertTrue("Add try-catch statements inside the printLanguageList method to catch the exception being thrown",
                allCode.matches(pattern));
    }
    
    
    
    @Test(timeout=3000)
    public void wordCount() throws Exception {
        // Ensure code does not crash
        // Read source code to check for presence of try-catch block for the specific exception thrown
    
        try {
            Question_5_Add_Exception_Handling q5 = new Question_5_Add_Exception_Handling();
            int words = q5.wordCount("testing one two three");
            assertEquals("Make sure you don't change the behavior of wordCount. It should still count words.", 4, words);
            int nowords = q5.wordCount(null);
            assertEquals("wordCount should return 0 if sentence is null.", 0, nowords);
    
        } catch (NullPointerException npe) {
            fail("Add try-catch statements to catch the exception thrown in wordCount when sentence is null");
    
        }
    }
    
    
    @Test(timeout=3000)
    public void wordCountTryCatch() throws Exception {
        
        // Read source code and check that a try-catch statement has been added
        // Not something that would be done in a commercial test :)
        
        String path = String.join(System.getProperty("file.separator"), "src", "main", "java", "week_6", "Question_5_Add_Exception_Handling.java");
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        
        String line = reader.readLine();
        
        StringBuffer allLines = new StringBuffer();
        
        boolean inMethod = false;
        
        while (line != null) {
            
            if (line.contains("Start of wordCount.")) {
                inMethod = true;
            }
            
            if (line.contains("End of wordCount.")) {
                break;
            }
            
            if (inMethod) {
                allLines.append(line);
            }
            
            line = reader.readLine();
            
        }
        
        String allCode = allLines.toString();
        
        String pattern = "[\\S\\s]*catch.*\\(\\s*NullPointerException[\\S\\s]*";
        
        assertTrue("Add try-catch statements inside the wordCount method to catch the exception being thrown",
                allCode.matches(pattern));
        
        
    }
    
    
    
}