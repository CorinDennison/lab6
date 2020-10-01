package week_6;

import org.junit.Before;
import org.junit.Test;
import test_utils.ArrayListUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by clara on 8/3/17.
 */
public class Question_3_Read_Recycling_ReportTest {
    
    private File tempFileDirectory = new File("temporary_directory_for_test_files");
    
    @Before()
    public void ensureTempDirectoryExists() {
        tempFileDirectory.mkdir();
    }
    
    
    @Test(timeout=3000)
    public void readRecyclingFile() {

        try {

            File outFile = File.createTempFile("q3_recycling_report", ".txt", tempFileDirectory);
            
            String exampleData = "House 0 recycled 2 crates\nHouse 1 recycled 4 crates\nHouse 2 recycled 0 crates";
            byte[] exampleDataBytes = exampleData.getBytes();
            List<String> exampleDataList = ArrayListUtils.newArrayList(exampleData.split("\n"));
            Files.write(outFile.toPath(), exampleDataBytes);
            
            Question_3_Read_Recycling_Report q3 = new Question_3_Read_Recycling_Report();
            
            List<String> dataReadFromFile = q3.readLinesFromRecyclingDataFile(outFile.getAbsolutePath());
            
            assertTrue("Read in each line from the file, and add each line to an ArrayList. Don't modify the lines",
                    ArrayListUtils.stringListEqual(exampleDataList, dataReadFromFile));
        }

        catch (IOException e) {
           fail("Catch IOException in your readLinesFromRecyclingDataFile method. \nMake sure the " + tempFileDirectory.getName() + " directory exists.");
        }
    }


    @Test(timeout=3000)
    public void extractCrateData() {

        List<String> examples = ArrayListUtils.newArrayList("House 0 recycled 2 crates", "House 1 recycled 4 crates", "House 2 recycled 0 crates");

        List<Integer> expectedCrates = ArrayListUtils.newArrayList(2, 4, 0);

        Question_3_Read_Recycling_Report q3 = new Question_3_Read_Recycling_Report();

        List<Integer> crateData = q3.extractCrateQuantityData(examples);

        assertTrue("Extract the number of crates from each String, convert to an integer, and add to a new ArrayList." +
                "\nThe example data was " + examples + "\nand the expected crate data was " + expectedCrates +
                "\n Your program returned " + crateData,
                ArrayListUtils.intListEqual(expectedCrates, crateData));


    }

    @Test(timeout=3000)
    public void calculateMax() {

        Question_3_Read_Recycling_Report q3 = new Question_3_Read_Recycling_Report();

        ArrayList<Integer> exampleCrates = ArrayListUtils.newArrayList(2, 4, 0);
        assertEquals("Verify calculateMax returns the highest number in the ArrayList", q3.calculateMax(exampleCrates), 4);

        exampleCrates = ArrayListUtils.newArrayList(2, 4, 0, 6, 5, 2, 6, 0);
        assertEquals("Verify calculateMax returns the highest number in the ArrayList", q3.calculateMax(exampleCrates), 6);

        exampleCrates = ArrayListUtils.newArrayList(-2, -4, -6);
        assertEquals("Verify calculateMax returns the highest number in the ArrayList. Make your code as general as possible - what if the ArrayList is all negative numbers?", q3.calculateMax(exampleCrates), -2);


    }


    @Test(timeout=3000)
    public void calculateMaxHousesManyMax() {
    
        Question_3_Read_Recycling_Report q3 = new Question_3_Read_Recycling_Report();
    
        List<Integer> exampleCrates = ArrayListUtils.newArrayList(2, 4, 0, 6, 5, 2, 6, 0, 6);
    
        // Elements 3 and 6 have the maximum value of 6
        List<Integer> exampleMaxHouses = ArrayListUtils.newArrayList(3, 6, 8);
    
        List<Integer> maxHouses = q3.copyIndexesToNewList(exampleCrates, 6);
    
        assertTrue("For a list of crates " + exampleCrates + " copying indexes of every " + 6 + ", the indexes " + exampleMaxHouses + " should be copied. The values copied were " + maxHouses,
                ArrayListUtils.intListEqual(exampleMaxHouses, maxHouses));
    
    }
    
    @Test(timeout=3000)
    public void calculateMaxHousesOneMax() {
    
        Question_3_Read_Recycling_Report q3 = new Question_3_Read_Recycling_Report();
    
        List<Integer> exampleCrates = ArrayListUtils.newArrayList(2, 4, 10, 6, 0);
    
        // Element 2 has the maximum value of 10
        List<Integer> exampleMaxHouses = ArrayListUtils.newArrayList(2);
    
        List<Integer> maxHouses = q3.copyIndexesToNewList(exampleCrates, 10);
    
        assertTrue("For a list of crates " + exampleCrates + " copying indexes of every " + 10 + ", the indexes " + exampleMaxHouses + " should be copied. The values copied were " + maxHouses,
                ArrayListUtils.intListEqual(exampleMaxHouses, maxHouses));
    
    }
    
        @Test(timeout=3000)
        public void calculateMaxHousesNotMax()  {
            // Another example: copyIndexesToNewArrayList is general and doesn't have to operate on the max value in the ArrayList.
    
            Question_3_Read_Recycling_Report q3 = new Question_3_Read_Recycling_Report();
        
            List<Integer>
            
        exampleCrates = ArrayListUtils.newArrayList(2, 4, 10, 6, -2, 4, 0);
    
            List<Integer> exampleValueToCopy = ArrayListUtils.newArrayList(1, 5);
    
            List<Integer> maxHouses = q3.copyIndexesToNewList(exampleCrates, 4);

        assertTrue("For a list of crates " + exampleCrates + " copying indexes of every " + 4 + ", " +
                        "the indexes " + exampleValueToCopy + " should be copied. " +
                        "The values copied were " + maxHouses ,
                ArrayListUtils.intListEqual(exampleValueToCopy, maxHouses));


    }


    @Test(timeout=3000)
    public void testUsesTryCatchBlocks() throws Exception {
        Class q3 = Class.forName("week_6.Question_3_Read_Recycling_Report");
        Method mWrite = q3.getMethod("readLinesFromRecyclingDataFile", String.class);
        assertEquals("Add try-catch blocks to your writeToFile method. Handle any possible exceptions within the method.", 0, mWrite.getExceptionTypes().length);
    }



}