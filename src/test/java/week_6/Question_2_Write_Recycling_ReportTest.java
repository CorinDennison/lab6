package week_6;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.Assert.*;


public class Question_2_Write_Recycling_ReportTest {
    
    private final File tempFileDirectory = new File("temporary_directory_for_test_files");
    
    @Before()
    public void ensureTempDirectoryExists() {
        tempFileDirectory.mkdir();
    }
    
    @Test(timeout=3000)
    public void testWriteReport() {

        // Verify that the correct report is written

        // Example data
    
        int[] crates = { 1, 4, 2, 1 };  // Code should work with any length array
        int total = 0;
        for (int x : crates) {
            total += x;
        }

        Question_2_Write_Recycling_Report writeReport = new Question_2_Write_Recycling_Report();
        
        try {
            File outFile = File.createTempFile("recycling", ".txt", tempFileDirectory);
            
            writeReport.writeReport(crates, total, outFile.getAbsolutePath());

            byte[] bytes = Files.readAllBytes(outFile.toPath());
            String contents = new String(bytes);
            String fileContents = contents.trim().replace("\n", "").replace("\r", "");
          
            String expectedContents = "House 0 recycled 1 crateHouse 1 recycled 4 cratesHouse 2 recycled 2 cratesHouse 3 recycled 1 crate";
            String expectedSummary = "Total crates recycled: 8";

            String msg = "Make sure you write the correct data to the file. " +
                    "\nOne line per house, in the format 'House 3 recycled 2 crates'. " +
                    "\nIf there's one crate, it should say '1 crate'. Else, use 'crates'" +
                    "\nThe test is looking for the specific strings given in the assignment description." +
                    "\n\nThe example data array used by the test was: " + Arrays.toString(crates) +
                    "\nThe file your program created for this array was:\n" + contents;
            
            
            assertTrue(msg, fileContents.contains(expectedContents));

            assertTrue("Make sure you have the last line with the total crates, for example\n" +
                    expectedSummary, fileContents.contains(expectedSummary));
        }

        catch (IOException e) {
            e.printStackTrace();
            fail("Exception thrown. Check for errors in your code.");
        }
    }



    @Test(timeout=3000)
    public void testUsesTryCatchBlocks() throws Exception {

        // Verify that the writeReport method does not throw any exceptions,
        // implying that exceptions are handled within the method.
        Class q2 = Class.forName("week_6.Question_2_Write_Recycling_Report");
        Method mWrite = q2.getMethod("writeReport", int[].class, int.class, String.class);
        assertEquals("Add try-catch blocks to your writeReport method. Handle any possible exceptions within the method.", 0, mWrite.getExceptionTypes().length);

    }
    
    @Test(timeout=3000)
    public void testCalculateTotal() {
    
        Question_2_Write_Recycling_Report q3 = new Question_2_Write_Recycling_Report();
        
        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Totals 12
        assertEquals("Add up the total of all the integers in the array. Example: If the array contains [3, 1, 2] then return 6. " +
                "\nRemember that this method should work with any length of array.",
                12, q3.calculateTotal(testHouseCrates));
        
    }
    
    @Test(timeout=3000)
    public void testCalculateMax() {
    
        Question_2_Write_Recycling_Report q3 = new Question_2_Write_Recycling_Report();
        
        String msg = "Figure out the largest number in the array and return that. Remember that this method should work with any length of array. ";
        
        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Max is 5
        assertEquals(msg + "\n For the array [4, 2, 0, 1, 5], the max is 5. ", 5, q3.calculateMax(testHouseCrates));
        
        int[] testHouseCrates2 = { 4, 6, 0, 1, 6 } ;  // Joint equal max
        assertEquals(msg + "\n For the array [4, 6, 0, 1, 6], the max is 6. ", 6, q3.calculateMax(testHouseCrates2));
        
        int[] testHouseCrates3 = { 0, 0, 0, 0, 0 } ;  // All zeros
        assertEquals(msg + "\n For the array [0, 0, 0, 0, 0], the max is 0. ", 0, q3.calculateMax(testHouseCrates3));
    
        int[] testHouseCrates4 = { -20000000, -23, -35345, -3, -20 } ;  // Negative numbers
        assertEquals(msg + "\n For the array [-20000000, -23, -35345, -3, -20], the max is -3. ", -3, q3.calculateMax(testHouseCrates4));
    
    }
    
    @Test(timeout=3000)
    public void testCalculateMin() {
    
        Question_2_Write_Recycling_Report q3 = new Question_2_Write_Recycling_Report();
        
        String msg = "Figure out the smallest number in the array and return that. Remember that this method should work with any length of array. ";
        
        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Min is 0
        assertEquals(msg + "\n For the array [4, 2, 0, 1, 5], the min is 0. ", 0, q3.calculateMin(testHouseCrates));
        
        int[] testHouseCrates2 = { 4, 6, 2, 3, 2 } ;  // Joint equal min
        assertEquals(msg + "\n For the array [4, 6, 2, 3, 2], the min is 2. ", 2, q3.calculateMin(testHouseCrates2));
        
        int[] testHouseCrates3 = { 0, 0, 0, 0 } ;  // All zeros
        assertEquals(msg + "\n For the array [0, 0, 0, 0], the min is 0. ", 0, q3.calculateMin(testHouseCrates3));
    
        int[] testHouseCrates4 = { -20000000, -23, -35345, -3, -20 } ;  // Negative numbers
        assertEquals(msg + "\n For the array [-20000000, -23, -35345, -3, -20], the min is -20000000. ", -20000000, q3.calculateMin(testHouseCrates4));
    
    }
    
    
    @Test(timeout=3000)
    public void testCalculateHouseWithMostRecycling() {
    
        Question_2_Write_Recycling_Report q3 = new Question_2_Write_Recycling_Report();
        
        int[] testHouseCrates = { 2, 4, 0, 1, 5, 3} ;  // House with max is house 4
        assertEquals("For the array [2, 4, 0, 1, 5, 3], the largest value is in element 4. This method should return 4", 4, q3.calculateHouseWithMostRecycling(testHouseCrates));
        
        int[] testHouseCrates2 = { 4, 2, 10, 1, 5} ;  // House with max is house 2
        assertEquals("For the array [4, 2, 10, 1, 5], the largest value is in element 2. This method should return 2", 2, q3.calculateHouseWithMostRecycling(testHouseCrates2));
        
        int[] testHouseCrates3 = { 4, 7, 0, 7, 5} ;  // 1 and 3 are both max, can pick either
        int calcMaxHouse = q3.calculateHouseWithMostRecycling(testHouseCrates3);
        
        assertTrue("For the array [4, 7, 0, 7, 5], the joint largest values are in 1 and 3. Return either 1 or 3", calcMaxHouse == 1 || calcMaxHouse == 3);
    }
    
    @Test(timeout=3000)
    public void testGetRecyclingPerHouse() {
    
        try {
            Question_2_Write_Recycling_Report q3 = new Question_2_Write_Recycling_Report();
    
            int[] crateInput = {4, 3, 6, 2};
    
            String input = "";
            for (Integer i : crateInput) {
                input += i + "\n";
            }
    
            //input is made from elements of array separated by \n e.g. {4, 3, 6} becomes  "4\n3\n\6\n"
    
            //Where does the user input come from? This is a different approach to mocking the InputUtil classes.
            //Can replace the System.in input stream with an input stream of our creation
            //credit to this Stack Overflow http://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
    
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
    
            int[] recycling = q3.getRecyclingPerHouse(crateInput.length);
            assertArrayEquals("Save all of the user input in an array. If there are 3 houses, and the user enters 4, 1, 3, return an array [4, 1, 3]. " +
                    "\nRemember that this method should work with any length of array.", crateInput, recycling);
    
        } finally {
            //And reset the System.in input stream when done
            System.setIn(System.in);
        }
    }
}
