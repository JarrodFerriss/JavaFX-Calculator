package com.calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the JavaFX Calculator application.
 * This class initializes and launches the JavaFX application.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create an instance of the calculator screen
        calculatorScreen screen = new calculatorScreen();

        // Create a Scene using the root container of the calculator screen
        Scene scene = new Scene(screen.getRoot());

        // Set up the primary stage (main application window)
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {

        // Launch the JavaFX application
        launch(args);
    }
}
