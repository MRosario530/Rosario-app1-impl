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

    private List<Item> thingsToDo;

    public ToDoList() {
        // Initializes the toDoList.
        thingsToDo = new ArrayList<>();
    }

    public List<Item> getThingsToDo() {
        // Get the entire list of items in this current toDoList.
        return thingsToDo;
    }

    public void addToList(String description, LocalDate dueDate) {
        boolean validItem = validateDescriptionLength(description);
        if(validItem && dueDate != null) {
            addItemWithDescAndDate(description, dueDate.toString());
        } else if (validItem) {
            addItemOnlyDesc(description);
        }
    }

    private void addItemWithDescAndDate(String description, String dueDate) {
            // Create an item object using the 2 parameters and add the item to the List thingsToDo.
            thingsToDo.add(new Item(description,dueDate));
    }

    private void addItemOnlyDesc(String description) {
            // Create an item object using the 1 parameter and add the item to the List thingsToDo.
            thingsToDo.add(new Item(description));
    }

    public List<Item> getCompleteThingsToDo() {
        // Create a new list.
        List<Item> completeItems = new ArrayList<>();
        // Loop through the thingsToDo list and add all completed things to the list.
        for (Item toDo: thingsToDo) {
            if(toDo.getIsComplete().equals("Complete")) {
                completeItems.add(toDo);
            }
        }
        // Return the new list.
        return completeItems;
    }

    public List<Item> getIncompleteThingsToDo() {
        // Create a new list.
        List<Item> incompleteItems = new ArrayList<>();
        // Loop through the thingsToDo list and add all incomplete things to the list.
        for (Item toDo: thingsToDo) {
            if(toDo.getIsComplete().equals("Incomplete")) {
                incompleteItems.add(toDo);
            }
        }
        // Return the new list.
        return incompleteItems;
    }

    public void editItem(Item itemToEdit, String description, LocalDate dueDate, boolean isComplete) {
        // Get the item the user wants to edit.
        int itemIndex = thingsToDo.indexOf(itemToEdit);
        // If the item is actually in the list.
        if (itemIndex > -1) {
            // If the description entered is of valid length, replace the item's current description with the new one.
            if (validateDescriptionLength(description)) {
                thingsToDo.get(itemIndex).setDescription(description);
            }
            // Ensure that the due date isn't blank. If it is, set the string to "". Otherwise, replace the date.
            if (dueDate != null) {
                thingsToDo.get(itemIndex).setDueDate(dueDate.toString());
            } else {
                thingsToDo.get(itemIndex).setDueDate("");
            }
            // Update the completion status.
            thingsToDo.get(itemIndex).setIsComplete(isComplete);
        }
    }

    public void deleteItem(Item selectedItem) {
        // Delete the item in the parameter from the thingsToDo using the list's remove function.
        thingsToDo.remove(selectedItem);
    }

    public void clearList() {
        // Delete all items in thingsToDo using the list's clear method.
        thingsToDo.clear();
    }

    public void loadListFromFile(File saveLocation) {
        // Have to check for null since closing out of filechooser returns null.
        if (saveLocation != null) {
            // Create a ToDoListFileConverter object.
            ToDoListFileConverter converter = new ToDoListFileConverter();
            // Call the object's loadListFromFile(saveLocation) method and set the result equal to the
            // thingsToDoList.
            thingsToDo = converter.loadListFromFile(saveLocation);
        }
    }

    public void saveListToFile(File saveLocation) {
        // Have to check for null since closing out of filechooser returns null.
        if (saveLocation != null) {
            // Create a ToDoListFileConverter object.
            ToDoListFileConverter converter = new ToDoListFileConverter();
            // Call the object's saveListToFile(toString,saveLocation).
            converter.saveListToFile(toString(), saveLocation);
        }
    }

    // Validate description length is here instead of in Item because all values need to be verified before being
    // created, and I would rather verify the description first instead of creating an item, determining that the
    // description is invalid, and then do nothing after.
    private boolean validateDescriptionLength(String description) {
        // Check to see if the length of the string description is between 1 and 256.
        // Return the result.
        return description.length() >= 1 && description.length() <= 256;
    }

    public String toString() {
        // Create a stringbuilder.
        StringBuilder result = new StringBuilder();
        // Loop through the arraylist, adding each item's toString followed by a newline.
        for (Item thing: thingsToDo) {
            result.append(thing).append("\n");
        }
        // Return the stringbuilder as a string.
        return result.toString();
    }
}
