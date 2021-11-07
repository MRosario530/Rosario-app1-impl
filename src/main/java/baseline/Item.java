/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;
import javafx.beans.property.SimpleStringProperty;

public class Item {

    // Instance Variables
    private final SimpleStringProperty description;
    private final SimpleStringProperty dueDate;
    private final SimpleStringProperty isComplete;
    private static final String INC = "Incomplete";

    // Constructors.
    public Item(String description, String dueDate, String isComplete) {
        // Initialize an item object and assign the parameters to the corresponding variables.
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.isComplete = new SimpleStringProperty(isComplete);
    }

    public Item(String description, String dueDate) {
        // Initialize an item object and assign the parameters to the corresponding variables.
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleStringProperty(dueDate);
        // Set the isComplete variable to Incomplete by default.
        this.isComplete = new SimpleStringProperty(INC);
    }

    public Item(String description) {
        // Initialize an item object and assign the parameters to the corresponding variables.
        this.description = new SimpleStringProperty(description);
        // Set the dueDate to "".
        this.dueDate = new SimpleStringProperty("");
        // Set the isComplete variable to false by default.
        this.isComplete = new SimpleStringProperty(INC);
    }

    // Setters and Getters.
    public void setIsComplete(boolean isComplete) {
        // Sets the boolean isComplete to the proper string depending on the boolean given.
        if (isComplete) {
            this.isComplete.set("Complete");
        } else {
            this.isComplete.set(INC);
        }
    }

    public String getIsComplete() {
        // Return whether the item is complete.
        return isComplete.get();
    }

    public void setDescription(String description) {
        // Sets the item's description.
        this.description.set(description);
    }

    public String getDescription() {
        // Return the item's description.
        return this.description.get();
    }

    public void setDueDate(String dueDate) {
        // Set the item's due date.
        this.dueDate.set(dueDate);
    }

    public String getDueDate() {
        // Returns the item's due date.
        return this.dueDate.get();
    }

    // ToString.
    public String toString() {
        // Return a string containing the info as following:
        // description + "," + dueDate + "," + isComplete
        return description.get() + "," + dueDate.get() + "," + isComplete.get();
    }

}
