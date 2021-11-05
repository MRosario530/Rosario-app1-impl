/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class ApplicationController {

    private ToDoList masterList;

    private List<Item> visibleList;

    @FXML
    private Button addItemButton;

    @FXML
    private TableView<ToDoList> allListTable;

    @FXML
    private TableColumn<ToDoList, String> titleCol;

    @FXML
    private TableColumn<ToDoList, Integer> itemNumCol;

    @FXML
    private TableColumn<ToDoList, Integer> incompleteItemCol;

    @FXML
    private Button changeTitleButton;

    @FXML
    private CheckBox completeCheckbox;

    @FXML
    private Button createListButton;

    @FXML
    private TableView<ToDoList> currentListTable;

    @FXML
    private TableColumn<Item, String> descriptionCol;

    @FXML
    private TableColumn<Item, String> dueDateCol;

    @FXML
    private TableColumn<Item, Boolean> completionCol;

    @FXML
    private DatePicker dateEntryBox;

    @FXML
    private Button deleteItemButton;

    @FXML
    private Button deleteListButton;

    @FXML
    private TextArea descriptionEntryBox;

    @FXML
    private Button displayAllItemsButton;

    @FXML
    private Button displayCompleteButton;

    @FXML
    private Button displayIncompleteButton;

    @FXML
    private Button editItemButton;

    @FXML
    private Button loadListFromFileButton;

    @FXML
    private Button saveListToFileButton;

    @FXML
    private TextField titleEntryBox;

    @FXML
    private Button clearListButton;

    @FXML
    private Button downloadListButton;

    @FXML
    private DatePicker editDateBox;

    @FXML
    private TextArea editDescriptionBox;

    @FXML
    private DatePicker newDateBox;

    @FXML
    private TextArea newDescriptionBox;

    @FXML
    private Button uploadListButton;

    @FXML
    private void onAddItemPressed(ActionEvent event) {
        // Get the data from the newDescriptionBox.
        // Get the data from the newDate date picker.
        // Call the masterList's addToList function with the appropriate values given.
        // Add the item to the visibleList as well.
        // Refresh the tableview.
    }

    @FXML
    private void onDeleteItemPressed(ActionEvent event) {
        // Get the currently selected item from the currentLists tableview.
        // Call the masterList's deleteItem function on the item.
        // Remove the item from the visibleList as well.
    }


    @FXML
    private void onDisplayAllPressed(ActionEvent event) {
        // Call the masterList's getThingsToDo function and set the visibleList equal to the result.
        // Refresh the tableView to display all items.
    }

    @FXML
    private void onDisplayCompletePressed(ActionEvent event) {
        // Call the masterList's getCompleteThingsToDo function and set the visibleList equal to the result.
        // Refresh the tableView to display all items.
    }

    @FXML
    private void onDisplayIncompletePressed(ActionEvent event) {
        // Call the masterList's getIncompleteThingsToDo function and set the visibleList equal to the result.
        // Refresh the tableView to display all items.
    }

    @FXML
    private void onEditItemPressed(ActionEvent event) {
        // Get the data from the descriptionEntry text area.
        // Get the data from the dueDate date picker.
        // Get the data from the completion check box.
        // Get the currently selected item from the tableview.
        // Call the masterList's editItem function.
        // Update the visibleList and tableview.
    }

    @FXML
    private void onClearListPressed(ActionEvent event) {
        // Call the masterList's clearList method.
        // Call the visibleList's clear method and update the tableView.
    }

    @FXML
    private void onDownloadListPressed(ActionEvent event) {
        // Create a filechooser and open the dialog window for it to get the file location.
        // Set an extension filter for only .txt files.
        // Get the file location and call the masterList's saveListToFile method.
    }

    @FXML
    private void onUploadListPressed(ActionEvent event) {
        // Create a filechooser and open the dialog window for it to get the file location.
        // Set an extension filter for only .txt files.
        // Get the file location and call the masterList's loadListFromFile method.
        // Update the visibleList and tableView.
    }

    @FXML
    public void initialize() {
        // To be honest I don't really know what this does I just assumed I needed an initialize method.
        // Initialize the masterList.
    }
}