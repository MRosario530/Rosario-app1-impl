/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import org.junit.jupiter.api.Test;

class ItemTest {
    // Note - I did not having many tests for the item class as the item class itself contains nearly no
    // responsibilities. The item class itself is intended to serve as a container for the data associated with an item.
    // I choose to test the toString since it is necessary for my saving to file.

    @Test
    void testToString() {
        // Create a new item object with the following parameters:
            // Description: "Test Description"
            // Due Date: "2022-05-30"
            // isComplete: true
        // Then assertEquals to see if the actual string equals "Test Description,2022-05-30,true"
    }
}