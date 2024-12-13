package com.calculator;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Defines the graphical user interface (GUI) for the calculator.
 * This class handles the layout and UI components programmatically using JavaFX APIs.
 */
public class calculatorScreen {

    private final VBox root; // Root container for the UI
    private final TextField display; // Text field to display inputs and results
    private final calculatorScreenController controller; // Controller for handling logic

    public  calculatorScreen() {

        // Initialize the controller for the calculator logic
        controller = new calculatorScreenController();

        // Create the calculator display (TextField)
        display = new TextField();
        display.setEditable(false); // Prevent the user from manually typing
        display.setPrefHeight(50); // Set the preferred height for better visibility

        // Create the grid layout for the buttons
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10); // Set horizontal gap between buttons
        buttonGrid.setVgap(10); // Set vertical gap between buttons
        buttonGrid.setPadding(new Insets(10)); // Add padding around the grid

        // Define the button labels for the calculator
        String[] buttons = {

                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        // Add buttons to the grid dynamically
        int row = 0, col = 0;

        for (String text : buttons) {

            // Create a button with the text label
            Button button = new Button(text);
            button.setPrefSize(50, 50); // Set size for consistency

            // Attach an element handler to the button to process user actions
            button.setOnAction(controller::handleButtonClick);

            // Add the button to the grid at the specific row and column
            buttonGrid.add(button, col, row);

            // Update column and row positions for the next button
            col++;
            if(col > 3) { // Move to the next row after 4 buttons

                col = 0;
                row++;
            }
        }

        // Create the root container and assemble the UI
        root = new VBox(10); // Vertical layout with spacing between elements
        root.setPadding(new Insets(10)); // Padding around the root container
        root.getChildren().addAll(display, buttonGrid); // Add display and button grid to root

        // Link the controller to the display for dynamic updates
        controller.setDisplay(display);
    }

    /**
     * Returns the root container for the UI.
     * This method is used to attach the UI to the Scene in the main application.
     */
    public VBox getRoot() {

        return root;
    }
}
