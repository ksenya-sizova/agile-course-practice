package ru.unn.agile.fractioncalculator.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String TITLE_OF_APPLICATION = "Fraction Calculator";
    private static final String SCENE = "fractioncalculator.fxml";

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle(TITLE_OF_APPLICATION);
        primaryStage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource(SCENE)))
        );
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
