/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import java.time.LocalDate;

public class Item {
    private String description;
    private LocalDate dueDate;
    private boolean isComplete;

    public Item(String description, LocalDate dueDate) {
        // Initialize an item object and assign the parameters to the corresponding variables.
    }

    public Item(String description) {
        // Initialize an item object and assign the parameters to the corresponding variables.
        // Set the isComplete variable to false by default.
        // Set the dueDate to NULL.
    }

    public Item() {
        // Initialize an item object.
        // Set the description to "".
        // Set the isComplete variable to false by default.
        // Set the dueDate to NULL.
    }

    public void setComplete(boolean complete) {
        // Sets the boolean isComplete to complete.
    }

    public boolean isComplete() {
        // Return whether the item is complete.
        return false;
    }

    public void setDescription(String description) {
        // Create an ItemValidator and validate the description string.
        // If true:
            // Sets the item's description.
    }

    public String getDescription() {
        // Return the item's description.
        return "";
    }

    public void setDueDate(LocalDate dueDate) {
        // Create an ItemValidator and validate the dueDate string.
        // If true:
            // Sets the item's dueDate.
    }

    public LocalDate getDueDate() {
        // Returns the item's due date.
        return null;
    }

    public String toString() {
        // Return a string containing the info as following:
        // description + "," + dueDate toString + "," + isComplete
        return "";
    }

}
