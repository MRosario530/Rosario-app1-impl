/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
// Note - I recognized very late that I needed to build equals methods to accurately test comparisons using items. Due
// to my own time constraints I relied on toStrings to compare objects like these.
package baseline;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    
    @Test
    void testValidDescriptionSize() {
        // Create a new ToDoList object with an item that has valid description and date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.now();
        testList.addToList("This is a valid string length", temp);
        // Verify that the item was created and that the description appears.
        assertEquals("This is a valid string length", testList.getThingsToDo().get(0).getDescription());
    }

    @Test
    void testInvalidDescriptionSize() {
        // Create a new ToDoList object with an item that has an invalid description and valid date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.now();
        testList.addToList("", temp);
        // Verify that no object was added to the testList.
        assertEquals(0,testList.getThingsToDo().size());
    }

    @Test
    void testDueDateCreation() {
        // Create a new ToDoList object with an item that has a valid description and date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Verify the date is correct and in the format YYYY-MM-DD.
        assertEquals("2021-01-02",testList.getThingsToDo().get(0).getDueDate());
    }

    @Test
    void testAddToListDescAndDueDate() {
        // Create a new ToDoList object with an item that has a valid description and date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Create an item with the same parameters and compare the item to the first index of the ToDoList object's
        // list of items.
        Item expectedResult = new Item("test",temp.toString());
        assertEquals(expectedResult.toString(),testList.getThingsToDo().get(0).toString());
    }

    @Test
    void testAddToListDescOnly() {
        // Create a new ToDoList object with an item that has a valid description and invalid date.
        ToDoList testList = new ToDoList();
        testList.addToList("test", null);
        // Create an item with the same parameters and compare the item to the first index of the ToDoList object's
        // list of items.
        Item expectedResult = new Item("test","");
        assertEquals(expectedResult.toString(),testList.getThingsToDo().get(0).toString());
    }

    @Test
    void testDeleteItem() {
        // Create a new ToDoList object with two items.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        testList.addToList("test2", LocalDate.now());
        // Call deleteItem on the above item.
        testList.deleteItem(testList.getThingsToDo().get(1));
        // Use the assert method to verify that only the one correct item remains
        assertEquals("test,2021-01-02,Incomplete\n", testList.toString());
    }

    @Test
    void testClearList() {
        // Create a new ToDoList object with three items - 2 complete items and 1 incomplete item.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        testList.getThingsToDo().get(0).setIsComplete(true);
        testList.addToList("test2", temp);
        testList.getThingsToDo().get(1).setIsComplete(true);
        testList.addToList("test3", temp);
        // Call the clearList method on the testList.
        testList.clearList();
        // Verify that the size of the testList is 0.
        assertEquals(0,testList.getThingsToDo().size());
    }

    @Test
    void testEditItem() {
        // Create a new ToDoList object with an item that has a valid description and valid date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Call the editItem function on the item and change all values.
        temp = LocalDate.of(2022,2,13);
        testList.editItem(testList.getThingsToDo().get(0),"New Description", temp ,true);
        // Verify that all changes went through accurately.
        assertEquals("New Description,2022-02-13,Complete", testList.getThingsToDo().get(0).toString());
    }

    @Test
    void testEditItemPartially() {
        // Create a new ToDoList object with an item that has a valid description and valid date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Call the editItem function on the item and have an invalid description in the edit function.
        temp = LocalDate.of(2022,2,13);
        testList.editItem(testList.getThingsToDo().get(0),"", temp ,true);
        // Verify that all changes went through accurately and that the description did not change.
        assertEquals("test,2022-02-13,Complete", testList.getThingsToDo().get(0).toString());
    }

    @Test
    void testEditItemDescOnly() {
        // Create a new ToDoList object with an item that has a valid description and valid date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Call the editItem function on the item and change all values.
        testList.editItem(testList.getThingsToDo().get(0),"New Description", temp ,false);
        // Verify that all changes went through accurately with on the description changing.
        assertEquals("New Description,2021-01-02,Incomplete", testList.getThingsToDo().get(0).toString());
    }

    @Test
    void testEditItemDueDateOnly() {
        // Create a new ToDoList object with an item that has a valid description and valid date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Call the editItem function on the item and change all values.
        temp = LocalDate.of(2022,2,13);
        testList.editItem(testList.getThingsToDo().get(0),"", temp ,false);
        // Verify that all changes went through accurately with only the date changing.
        assertEquals("test,2022-02-13,Incomplete", testList.getThingsToDo().get(0).toString());
    }

    @Test
    void testEditItemCompletionOnly() {
        // Create a new ToDoList object with an item that has a valid description and valid date.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Call the editItem function on the item and change all values.
        testList.editItem(testList.getThingsToDo().get(0),"", temp ,true);
        // Verify that all changes went through accurately and only the completion status changed.
        assertEquals("test,2021-01-02,Complete", testList.getThingsToDo().get(0).toString());
    }

    @Test
    void testGetThingsToDo() {
        // Create a new ToDoList object with three items - 2 complete items and 1 incomplete item.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        testList.getThingsToDo().get(0).setIsComplete(true);
        testList.addToList("test2", temp);
        testList.getThingsToDo().get(1).setIsComplete(true);
        testList.addToList("test3", null);
        // Call getThingsToDo and set the result equal to a new List of items.
        List<Item> actualResult = testList.getThingsToDo();
        String expectedResult = "[test,2021-01-02,Complete, test2,2021-01-02,Complete, test3,,Incomplete]";
        // Create a string representing the expected result (3 items with descriptions, dates, and Complete/Incomplete),
        // and verify the result.
        assertEquals(expectedResult, actualResult.toString());
    }

    @Test
    void testGetCompleteThingsToDo() {
        // Create a new ToDoList object with three items - 2 complete items and 1 incomplete item.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        testList.getThingsToDo().get(0).setIsComplete(true);
        testList.addToList("test2", temp);
        testList.getThingsToDo().get(1).setIsComplete(true);
        testList.addToList("test3", temp);
        // Call getCompleteThingsToDo and set the result equal to a new List of items.
        List<Item> completeItems = testList.getCompleteThingsToDo();
        // Loop through the new list with a boolean and if any of them do not have isComplete as Complete change the
        // boolean to false.
        boolean actualResult = true;
        for (Item i: completeItems) {
            if(!i.getIsComplete().equals("Complete")) {
                actualResult = false;
            }
        }
        // Use the assert method to verify if the boolean is true.
        assertTrue(actualResult);
    }

    @Test
    void testGetIncompleteThingsToDo() {
        // Create a new ToDoList object with three items - 2 complete items and 1 incomplete item.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        testList.getThingsToDo().get(0).setIsComplete(true);
        testList.addToList("test2", temp);
        testList.getThingsToDo().get(1).setIsComplete(true);
        testList.addToList("test3", temp);
        // Call getIncompleteThingsToDo and set the result equal to a new List of items.
        List<Item> incompleteItems = testList.getIncompleteThingsToDo();
        // Loop through the new list with a boolean and if any of them do not have isComplete as Incomplete change the
        // boolean to false.
        boolean actualResult = true;
        for (Item i: incompleteItems) {
            if(!i.getIsComplete().equals("Incomplete")) {
                actualResult = false;
            }
        }
        // Use the assert method to verify if the boolean is true.
        assertTrue(actualResult);
    }

    @Test
    void testLoadListFromFile() {
        // Create a ToDoList with one item to be overwritten.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        // Create an expected result string of the 3 items to be loaded into the testList.
        String expectedResult = """
                hello,2024-05-20,Incomplete
                goodbye,,Complete
                hola,2021-09-18,Incomplete
                """;
        // Call loadListFromFile on the test file.
        testList.loadListFromFile(new File("docs/testloadlist.txt"));
        // Use assertequals to compare the strings.
        assertEquals(expectedResult,testList.toString());
    }

    @Test
    void testSaveListToFile() {
        // Create a new ToDoList object with three items - 2 complete items and 1 incomplete item.
        ToDoList testList = new ToDoList();
        LocalDate temp = LocalDate.of(2021, 1, 2);
        testList.addToList("test", temp);
        testList.getThingsToDo().get(0).setIsComplete(true);
        testList.addToList("test2", temp);
        testList.getThingsToDo().get(1).setIsComplete(true);
        testList.addToList("test3", null);
        // Call the saveListToFile method on the above testList.
        File testDoc = new File("docs/testsavelist.txt");
        testList.saveListToFile(testDoc);
        // Get the string from the saved file and compare it to the expected result.
        String actualResult;
        try {
            actualResult = Files.readString(Path.of("docs/testsavelist.txt"));
        } catch (IOException e) {
            actualResult = "Failure";
        }
        String expectedResult = "test,2021-01-02,Complete\ntest2,2021-01-02,Complete\ntest3,,Incomplete\n";
        // Use assertEquals to compare the two lists.
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void test100SizedList() {
        ToDoList testList = new ToDoList();
        testList.loadListFromFile(new File("docs/testsize100.txt"));
        assertEquals(100,testList.getThingsToDo().size());
    }
}