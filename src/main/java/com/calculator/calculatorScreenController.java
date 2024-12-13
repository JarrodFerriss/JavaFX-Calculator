package com.calculator;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Handles the logic and event handling for the calculator.
 * This class separates UI logic from application logic, following MVC principles.
 */
public class calculatorScreenController {

    private TextField display; // Responsible for the display and updating text
    private String currentInput = ""; // Stores the current user input
    private String operator = ""; // Stores the selected operator (+, -, *, /)
    private double firstOperand; // Stores the first operand for calculations

    /**
     * Links the display from the UI to the controller for updates.
     *
     * @param display the TextField representing the calculator's display.
     */
    public void setDisplay(TextField display) {

        this.display = display;
    }

    /**
     * Handles the button click events for the numbers, operators, and special keys.
     *
     * @param event The event triggered by clicking a button.
     */
    public void  handleButtonClick(javafx.event.ActionEvent event) {

        // Get the button that was clicked
        Button button = (Button) event.getSource();
        String text = button.getText(); // Get the text on the button

        switch (text) {

            case "C" -> { // Clear the display and reset all variables
                currentInput = "";
                operator = "";
                firstOperand = 0;
                display.setText(""); // Clear the display
            }

            case "=" -> handleEquals(); // Perform the Calculation

            case "+", "-", "*", "/" -> handleOperator(text); // Set the operator

            default -> { // Append number to the current input

                currentInput += text;
                display.setText(currentInput); // Update the display
            }
        }
    }

    /**
     * Handles the "=" button click to perform calculations.
     */
    private void handleEquals() {

        if (!operator.isEmpty() && !currentInput.isEmpty()) {

            // Parse the second operand from the current input
            double secondOperand = Double.parseDouble(currentInput);

            // Perform the calculation based on the operator
            double result = switch (operator) {
                case "+" -> firstOperand + secondOperand;

                case "-" -> firstOperand - secondOperand;

                case  "*" -> firstOperand * secondOperand;

                case "/" -> firstOperand / secondOperand;

                default -> 0; // Default result if operator is invalid
            };

            // Display the result and reset variables
            display.setText(String.valueOf(result));
            currentInput = "";
            operator = "";
        }
    }

    /**
     * Handles operator button clicks (+, -, *, /).
     *
     * @param op The operator selected by the user.
     */
    private void handleOperator(String op) {

        // Store the first operand and the selected operator
        firstOperand = Double.parseDouble(currentInput);
        operator = op;

        // Clear the current input for the next operand
        currentInput = "";
    }
}
