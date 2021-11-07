/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoListFileConverterTest {

    @Test
    void testLoadListFromFile() {
        // Have a text file for testing with the toString of 3 items.
        // Create a ToDoListFileConverter object.
        // Create a ToDoList object with the 3 items mentioned above.
        // Create a new ToDoList and call the ToDoListFileConverter loadListFromFile on the text file above.
        // Use assertequals to compare the ToDoLists.
        ToDoListFileConverter converter = new ToDoListFileConverter();
        // Create an expected result string of the 2 items to be loaded from the text document.
        String expectedResult = "[Goodbye,2021-05-31,Incomplete, Goodbye,2021-05-31,Complete]";
        // Call loadListFromFile on the test file and save the resulting list.
        List<Item> actualResult = converter.loadListFromFile(new File("docs/testfileconverterloadlist.txt"));
        // Use assertequals to compare the strings.
        assertEquals(expectedResult,actualResult.toString());
    }

    @Test
    void testSaveListToFile() {
        // Create a ToDoListFileConverter object.
        ToDoListFileConverter converter = new ToDoListFileConverter();
        // Create a String to load into a file.
        String itemString = "Hello,2021-05-30,Complete";
        // Call the saveListToFile method on the above String.
        File testDoc = new File("docs/testfileconvertersavelist.txt");
        converter.saveListToFile(itemString,testDoc);
        // Get the string from the saved file and compare it to the expected result.
        String actualResult;
        try {
            actualResult = Files.readString(Path.of("docs/testfileconvertersavelist.txt"));
        } catch (IOException e) {
            actualResult = "Failure";
        }
        String expectedResult = "Hello,2021-05-30,Complete";
        // Use assertEquals to compare the two lists.
        assertEquals(expectedResult,actualResult);
    }
}