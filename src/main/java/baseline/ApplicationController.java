/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Miguel Rosario
 */
// Credit for UploadArrow and DownloadArrow images:
// Icons made by https://www.flaticon.com/authors/uniconlabs from https://www.flaticon.com.
package baseline;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    private ToDoList masterList;

    private List<Item> visibleList;

    private int currentView = 0;

    @FXML
    private TableView<Item> listTable;

    @FXML
    private TableColumn<Item, String> descriptionCol;

    @FXML
    private TableColumn<Item, String> dueDateCol;

    @FXML
    private TableColumn<Item, String> completionCol;

    @FXML
    private TextArea newDescriptionBox;

    @FXML
    private DatePicker newDateBox;

    @FXML
    private Label inputErrorLabel;

    @FXML
    private TextArea editDescriptionBox;

    @FXML
    private DatePicker editDateBox;

    @FXML
    private CheckBox completeCheckbox;

    @FXML
    private Label addItemCountLabel;

    @FXML
    private Label editItemCountLabel;

    @FXML
    private CheckBox dateClearCheckbox;

    @FXML
    private Label editInputErrorLabel;

    @FXML
    private void onAddItemPressed(ActionEvent event) {
        int listSizeBeforeAdd = masterList.getThingsToDo().size();
        masterList.addToList(newDescriptionBox.getText(),newDateBox.getValue());
        // Validate the description before attempting to make an item.
        if (listSizeBeforeAdd != masterList.getThingsToDo().size()) {
            newDateBox.setValue(null);
            newDescriptionBox.setText("");
            inputErrorLabel.setVisible(false);
        } else {
            inputErrorLabel.setVisible(true);
        }
        updateTable();
    }

    @FXML
    private void onDeleteItemPressed(ActionEvent event) {
        // Get the currently selected item from the currentLists tableview.
        Item itemToDel = listTable.getSelectionModel().getSelectedItem();
        // Call the masterList's deleteItem function on the item.
        masterList.deleteItem(itemToDel);
        // Update the table.
        listTable.setItems(FXCollections.observableArrayList(visibleList));
        if (masterList.getThingsToDo().isEmpty()) {
            currentView = 0;
        }
        updateTable();
    }

    @FXML
    private void onEditItemPressed(ActionEvent event) {
        // Get the currently selected item from the tableview.
        Item itemToChange = listTable.getSelectionModel().getSelectedItem();
        if(editDescriptionBox.getText().length() < 257 && dateClearCheckbox.isSelected()) {
            // If the description is not too long and the user chooses to clear the date.
            masterList.editItem(itemToChange, editDescriptionBox.getText(), null,
                    completeCheckbox.isSelected());
            // Reset values for the boxes.
            resetEditSide();
        } else if(editDescriptionBox.getText().length() < 257 && !dateClearCheckbox.isSelected()) {
            // Else if the description is not too long and the user chooses NOT to clear the date.
            if(editDateBox.getValue() == null && !itemToChange.getDueDate().equals("")) {
                // If there was no input in the date, keep the date the same.
                masterList.editItem(itemToChange, editDescriptionBox.getText(),
                        LocalDate.parse(itemToChange.getDueDate()),
                        completeCheckbox.isSelected());
            } else {
                // Otherwise update the date along with everything else.
                masterList.editItem(itemToChange, editDescriptionBox.getText(), editDateBox.getValue(),
                        completeCheckbox.isSelected());
            }
            // Reset values for the boxes.
            resetEditSide();
        } else {
            editInputErrorLabel.setVisible(true);
        }
        // Update the visibleList and tableview.
        updateTable();
    }

    @FXML
    private void resetEditSide() {
        // Reset values for the boxes on the edit side.
        editDateBox.setValue(null);
        editDescriptionBox.setText("");
        completeCheckbox.setSelected(false);
        dateClearCheckbox.setSelected(false);
        editInputErrorLabel.setVisible(false);
    }

    @FXML
    private void onClearListPressed(ActionEvent event) {
        // Call the masterList's clearList method.
        masterList.clearList();
        visibleList.clear();
        // Update the tableview.
        currentView = 0;
        updateTable();
    }

    @FXML
    private void onDisplayAllPressed(ActionEvent event) {
        // Call the masterList's getThingsToDo function and set the visibleList equal to the result.
        visibleList = masterList.getThingsToDo();
        // Refresh the tableview to display all items.
        currentView = 0;
        updateTable();
    }

    @FXML
    private void onDisplayCompletePressed(ActionEvent event) {
        // Call the masterList's getCompleteThingsToDo function and set the visibleList equal to the result.
        visibleList = masterList.getCompleteThingsToDo();
        // Refresh the tableview to display complete items.
        currentView = 2;
        updateTable();
    }

    @FXML
    private void onDisplayIncompletePressed(ActionEvent event) {
        // Call the masterList's getIncompleteThingsToDo function and set the visibleList equal to the result.
        visibleList = masterList.getIncompleteThingsToDo();
        // Refresh the tableview to display incomplete items.
        currentView = 1;
        updateTable();
    }

    @FXML
    private void onDownloadListPressed(ActionEvent event) {
        // Create a filechooser object.
        FileChooser fileChooser = new FileChooser();
        String currentDir = System.getProperty("user.home");
        fileChooser.setInitialDirectory(new File(currentDir));
        // Set an extension filter for only .txt files.
        FileChooser.ExtensionFilter textFiles = new FileChooser.ExtensionFilter("Text files (*.txt)",
                "*.txt");
        fileChooser.getExtensionFilters().add(textFiles);
        // Open the dialog window for it to get the new file location.
        File downloadFile = fileChooser.showSaveDialog(completeCheckbox.getScene().getWindow());
        // Get the file location and call the masterList's saveListToFile method.
        masterList.saveListToFile(downloadFile);
    }

    @FXML
    private void onUploadListPressed(ActionEvent event) {
        // Create a filechooser and open the dialog window for it to get the file location.
        FileChooser fileChooser = new FileChooser();
        // Set an extension filter for only .txt files.
        FileChooser.ExtensionFilter textFiles = new FileChooser.ExtensionFilter("Text files (*.txt)",
                "*.txt");
        fileChooser.getExtensionFilters().add(textFiles);
        // Get the file location and call the masterList's loadListFromFile method.
        File uploadFile = fileChooser.showOpenDialog(completeCheckbox.getScene().getWindow());
        masterList.loadListFromFile(uploadFile);
        // Update the visibleList and tableView.
        updateTable();
    }

    // Helper Method to update the table immediately while not having to switch back to the complete display.
    private void updateTable() {
        if (currentView == 0) {
            visibleList = masterList.getThingsToDo();
        } else if(currentView == 1) {
            visibleList = masterList.getIncompleteThingsToDo();
        } else {
            visibleList = masterList.getCompleteThingsToDo();
        }
        listTable.setItems(FXCollections.observableArrayList(visibleList));
        listTable.refresh();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the masterList and visibleList.
        masterList = new ToDoList();
        visibleList = new ArrayList<>();
        // Initialize the columns.
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        // Allows resizing of the description column.
        descriptionCol.setCellFactory(tc -> {
            TableCell<Item, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Region.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(descriptionCol.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell ;
        });
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        completionCol.setCellValueFactory(new PropertyValueFactory<>("isComplete"));

        // Create character counters for description boxes.
        addItemCountLabel.textProperty().bind(newDescriptionBox.textProperty()
                .length()
                .asString("Character Count: %d"));
        editItemCountLabel.textProperty().bind(editDescriptionBox.textProperty()
                .length()
                .asString("Character Count: %d"));
        // Update the tableview.
        listTable.setItems(FXCollections.observableArrayList(visibleList));
    }
}