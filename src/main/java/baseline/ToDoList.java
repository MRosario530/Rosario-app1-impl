/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Item> thingsToDo = new ArrayList<>();

    public ToDoList() {
        // Initializes the toDoList.
    }

    public List<Item> getThingsToDo() {
        // Get the entire list of items in this current toDoList.
        return null;
    }

    public void addToList(String description, LocalDate dueDate) {
        // Create an ItemValidator object and use the validateDescription and validateDate methods.
        // If both return true:
            // Create an item object using the 2 parameters.
            // Add the item to the List thingsToDo.
            // Increase item count by 1.
    }

    public void addToList(String description) {
        // Create an ItemValidator object and use the validateDescription method.
        // If it returns true:
            // Create an item object using the 1 parameter and set the date to NULL.
            // Add the item to the List thingsToDo.
            // Increase numOfItems count by 1.
    }

    public List<Item> getCompleteThingsToDo() {
        // Create a new list.
        // Loop through the thingsToDo list and add all completed things to the list.
        // Return the new list.
        return null;
    }

    public List<Item> getIncompleteThingsToDo() {
        // Create a new list.
        // Loop through the thingsToDo list and add all incomplete things to the list.
        // Return the new list.
        return null;
    }

    public void editItem(Item itemToEdit, String description, LocalDate dueDate, boolean complete) {
        // Get the item the user wants to edit.
        // Call the appropriate setters for each object.
    }

    public void deleteItem(Item selectedItem) {
        // Delete the item in the parameter from the thingsToDo using the list's remove function.
    }

    public void clearList() {
        // Delete all items in thingsToDo using the list's clear method.
    }

    public void loadListFromFile(File saveLocation) {
        // Create a ToDoListFileConverter object.
        // Call the object's loadListFromFile(saveLocation) method and set the result equal to the
        // thingsToDoList.
    }

    public void saveListToFile(File saveLocation) {
        // Create a ToDoListFileConverter object.
        // Call the object's saveListToFile(toString,saveLocation).
    }

    public String toString() {
        // Create a stringbuilder.
        // Loop through the arraylist, adding each item's toString followed by a newline.
        // Return the stringbuilder as a string.
        return "";
    }
}
