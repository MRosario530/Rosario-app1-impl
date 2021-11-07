/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    // Note - I did not having many tests for the item class as the item class itself contains nearly no
    // responsibilities. The item class itself is intended to serve as a container for the data associated with an item.
    // I choose to test the toString since it is necessary for my saving to file. I also tested the setIsComplete because
    // it was a setter I added with a different type of parameter than the type of isComplete.

    @Test
    void testToString() {
        // Create a new item object with the following parameters:
            // Description: "Test Description", Due Date: "2022-05-30", isComplete: "Complete"
        Item actualResult = new Item("Test Description", "2022-05-30", "Complete");
        // Then assertEquals to see if the actual string equals "Test Description,2022-05-30,Complete"
        assertEquals("Test Description,2022-05-30,Complete", actualResult.toString());
    }

    @Test
    void testSetIsComplete() {
        // Create a new item object with the following parameters:
            // Description: "Test Description", Due Date: "2022-05-30", isComplete: "Complete"
        Item actualResult = new Item("Test Description", "2022-05-30", "Complete");
        // Edit the isComplete variable using boolean.
        actualResult.setIsComplete(false);
        assertEquals("Incomplete",actualResult.getIsComplete());
    }
}