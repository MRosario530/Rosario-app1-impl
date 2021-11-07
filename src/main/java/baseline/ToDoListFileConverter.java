/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoListFileConverter {

    public List<Item> loadListFromFile(File saveLocation) {
        // Create a temporary List.
        List<Item> tempList = new ArrayList<>();
        // Open the file at the location saveLocation.
        try (BufferedReader br = new BufferedReader(new FileReader(saveLocation))) {
            // Loop every line until the end of the file.
            String tempString;
            while ((tempString = br.readLine()) != null) {
                // For every line scanned in, call csvParser on that string.
                // Every line should contain the information of an item in this order:
                // Item i description, item i due date, item i completion status.
                String[] itemInfo = csvParser(tempString);
                // Use the values of the csvParser to create an item object.
                Item temp = new Item(itemInfo[0], itemInfo[1], itemInfo[2]);
                // Add the item object to the list.
                tempList.add(temp);
            }
        } catch (IOException| ArrayIndexOutOfBoundsException e) {
            System.out.println("Error scanning in file.");
        }
        // Return the List.
        return tempList;
    }

    public void saveListToFile(String listText, File saveLocation) {
        // Open the file at saveLocation.
        // Create a printwriter object within a try-catch.
        try (PrintWriter writer = new PrintWriter(saveLocation)) {
            // Print the listText string to the document.
            writer.write(String.valueOf(listText));
        } catch (IOException e) {
            System.out.println("Error writing to a file.");
        }
    }

    private String[] csvParser(String listString) {
        // Use the split() method with a comma as the delimiter and return the String array.
        return listString.split(",",3);
    }

}
