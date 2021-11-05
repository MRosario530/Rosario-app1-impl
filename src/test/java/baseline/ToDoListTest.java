/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import org.junit.jupiter.api.Test;

class ToDoListTest {

    @Test
    void testAddToListDescAndDueDate() {
        // Create a ToDoList object with the title ActualResult.
        // Call addToList("Test", "2022-05-30")
        // Create an item with the same parameters and compare the item to the first index of the ToDoList object's
        // list of items.
    }

    @Test
    void testAddToListDescOnly() {
        // Create a ToDoList object with the title ActualResult.
        // Call addToList("Test")
        // Create an item with the same parameters and compare the item to the first index of the ToDoList object's
        // list of items.
    }

    @Test
    void testGetCompleteThingsToDo() {
        // Create a ToDoList object.
        // Add three items to the ToDoList with 2 complete items and 1 incomplete item.
        // Call getCompleteThingsToDo and set the result equal to a new List of items.
        // Loop through the new list with a boolean and if any of them have isComplete as false change the boolean to
        // false.
        // Use the assert method to verify if the boolean is true.
    }

    @Test
    void testGetIncompleteThingsToDo() {
        // Create a ToDoList object.
        // Add three items to the ToDoList with 2 complete items and 1 incomplete item.
        // Call getCompleteThingsToDo and set the result equal to a new List of items.
        // Loop through the new list with a boolean and if any of them have isComplete as true change the boolean to
        // false.
        // Use the assert method to verify if the boolean is true.
    }

    @Test
    void testEditItem() {
        // Create a ToDoList object.
        // Add three items to the ToDoList with 2 complete items and 1 incomplete item.
        // Create a new ToDoList with the same values except for 1 edit.
        // Call the editItem function on the second item.
        // Compare the two lists to ensure that the original list has been edited to mirror the one with the edit
        // already made.
    }

    @Test
    void testDeleteItem() {
        // Create a ToDoList object with the title ActualResult.
        // Call addToList("Test", "2022-05-30", false)
        // Call addToList("Test", "2022-05-31", false)
        // Create an item with the parameters "Test", "2022-05-31", false.
        // Call deleteItem on the above item.
        // Use the assert method to verify the first item of the list does not equal the deleted item.
    }

    @Test
    void testClearList() {
        // Create a ToDoList object.
        // Add three items to the ToDoList with 2 complete items and 1 incomplete item.
        // Call the clearList method on the toDoList object.
        // Verify that the size of the ToDoList is 0.
    }

    @Test
    void testLoadListFromFile() {
        // Have a text file for testing with the toString of 3 items.
        // Create a ToDoList object with the 3 items mentioned above.
        // Create a new ToDoList and call the ToDoList loadListFromFile on the text file above.
        // Use assertequals to compare the ToDoLists.
    }

    @Test
    void testSaveListToFile() {
        // Create a ToDoList with three items.
        // Call the saveListToFile method using the ToDoList saveListToFile method.
        // Create a new ToDoList and load the list from the file.
        // Use assertEquals to compare the two lists.
    }

    @Test
    void testToString() {
        // Create a ToDoList object with the title ActualResult.
        // Call addToList("Test", "2022-05-30")
        // Create a testResult string and give it the value:
            // 1
            // Test Description,2022-05-30,false"
        // Use the assert method to compare the string above with the toString of the ToDoList object.
    }
}