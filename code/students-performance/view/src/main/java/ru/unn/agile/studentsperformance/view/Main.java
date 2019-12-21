package ru.unn.agile.studentsperformance.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String APPLICATION_TITLE = "Students Performance";
    private static final String APPLICATION_SCENE = "StudentPerformance.fxml";

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource(APPLICATION_SCENE)))
        );
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
