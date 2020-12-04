package week_6;

/**
You work for a recycling company.
You’d like to collect some statistics on how much each of the houses on a certain street is recycling.

 Each house has to use crates for their recycling. Your program will count the number of crates set out by each house.

 This street is a little unusual since it only has 8 houses, and the city planner must have been a computer programmer,
 since the house numbers are 0, 1, 2, 3, 4, 5, 6, and 7.

  (Hint – the house numbers are the same as array element indexes.)

 Write a program that asks for the number of recycling crates set out by each house.

 You should store, and process this data, in an array.

 DON'T use an ArrayList or LinkedList!

 Analyse your data and determine:
 * How many recycling crates, in total, from all the houses on the street?
 * What is the largest number of crates set out by any house?
 * What is the smallest number of crates set out by any house?
 * Which house had the most recycling? Display that house number.
 
 Finish the methods that do these calculations.
 Write your methods so that they work for any number of houses.
 
 Add code so that it writes the data as a report to a file.
 The report file should look like this example.
 Note that it should use "crate" for 1 crate, "crates" otherwise.
 
House 0 recycled 1 crate
House 1 recycled 2 crates
House 2 recycled 1 crate
House 3 recycled 2 crates
House 4 recycled 3 crates
House 5 recycled 3 crates
House 6 recycled 2 crates
House 7 recycled 1 crate
Total crates recycled: 15
 
 Add try-catch blocks for IOException in the writeReport method.
 The try-with-resources version is recommended.

 */

public class Question_2_Write_Recycling_Report {
    
    
    public static void main(String[] args) {
        new Question_2_Write_Recycling_Report().recycling();
    }
    
    public void recycling() {
        
        int numberOfHouses = 8;    // you may change this value for testing. Your program should work for any number of houses.
        
        int[] cratesPerHouse = getRecyclingPerHouse(numberOfHouses);
        int totalCrates = calculateTotal(cratesPerHouse);
        int maxCrates = calculateMax(cratesPerHouse);
        int minCrates = calculateMin(cratesPerHouse);
        int houseWithMostRecycling = calculateHouseWithMostRecycling(cratesPerHouse);
        
        System.out.println("Total crates from all houses = " + totalCrates);
        System.out.println("Max crates at any house = " + maxCrates);
        System.out.println("Min crates at any house = " + minCrates);
        System.out.println("House with most recycling = " + houseWithMostRecycling);
    
        String filename = "recycling_report.txt";
    
        writeReport(cratesPerHouse, totalCrates, filename);
    }
    
    
    public int[] getRecyclingPerHouse(int houses) {
        // TODO Ask user for number of crates for each house. Store in array and return this array.
        // this method should work for any value of the houses variable.
    
        // TODO ask user for input in this method.

        return null;  // TODO delete and replace with your code
    }
    
    
    public int calculateTotal(int[] cratesPerHouse) {
        // TODO calculate and return the total.
        //  Add up all of the numbers in the array and return the total.
        //  This method should work for any length cratesPerHouse array.
        
        return 0;  // TODO delete and replace with your code
    }
    
    
    public int calculateMax(int[] cratesPerHouse) {
        // TODO identify the largest number in the array.
        // this method should work for any length cratesPerHouse array.
        // TODO remember to write comments in code
        //   make sure you understand all of your code - add comments to help me know you do
        //   if you copy or adapt code from any other source, you MUST add a note with the source
        return 0; // TODO delete and replace with your code
    }
    
    
    public int calculateMin(int[] cratesPerHouse) {
        // TODO identify the smallest number in the array.
        //  this method should work for any length cratesPerHouse array.
    
        return 0; // TODO delete and replace with your code
    }
    
    
    public int calculateHouseWithMostRecycling(int[] cratesPerHouse) {
        // TODO work with the cratesPerHouse array to figure out which house number
        //   or array element number - has the most recycling

        // TODO which house had the most recycling? If more than one house
        //  has the max number, return either house number.
        //  this method should work for any length cratesPerHouse array.
        //
        // Example: if cratesPerHouse is { 1, 0, 3, 0, 2 } the max is 3, and the largest value
        // is in position 2 of the array. So this method should return 2.
    
        return 0; // TODO delete and replace with your code
    }
    
    
    public void writeReport(int[] cratesPerHouse, int totalCrates, String filename) {
        
        // TODO write report to file with the name in the filename variable.
        
        /* Your file should look exactly like this
        
         House 0 recycled 1 crate
         House 1 recycled 2 crates
         House 2 recycled 1 crate
         House 3 recycled 2 crates
         House 4 recycled 3 crates
         House 5 recycled 3 crates
         House 6 recycled 2 crates
         House 7 recycled 1 crate
         Total crates recycled: 15
 
        The grader is looking for this exact format.
 
        */
    }
}
