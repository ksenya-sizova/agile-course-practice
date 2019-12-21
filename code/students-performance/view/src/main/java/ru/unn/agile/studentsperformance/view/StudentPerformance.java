package ru.unn.agile.studentsperformance.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ru.unn.agile.studentsperformance.viewmodel.ViewModel;

public class StudentPerformance {

    @FXML private ViewModel viewModel;

    @FXML private ChoiceBox<Integer> mathsMark;
    @FXML private ChoiceBox<Integer> englishMarks;
    @FXML private ChoiceBox<Integer> historyMarks;
    @FXML private ChoiceBox<Integer> programmingMarks;
    @FXML private Button addStudentMarksButton;
    @FXML private Button clearButton;

    @FXML private ListView<String> marksList;

    @FXML private Label average;
    @FXML private Label excellentCount;
    @FXML private Label goodCount;
    @FXML private Label satisfactoryCount;
    @FXML private Label badCount;

    @FXML
    void initialize() {
        mathsMark.valueProperty().bindBidirectional(viewModel.mathsMarkProperty());
        englishMarks.valueProperty().bindBidirectional(viewModel.englishMarkProperty());
        historyMarks.valueProperty().bindBidirectional(viewModel.historyMarkProperty());
        programmingMarks.valueProperty().bindBidirectional(viewModel.programmingMarkProperty());

        average.textProperty().bindBidirectional(viewModel.averageProperty());
        excellentCount.textProperty().bindBidirectional(viewModel.excellentCountProperty());
        goodCount.textProperty().bindBidirectional(viewModel.goodCountProperty());
        satisfactoryCount.textProperty().bindBidirectional(viewModel.satisfactoryCountProperty());
        badCount.textProperty().bindBidirectional(viewModel.badCountProperty());

        marksList.itemsProperty().bindBidirectional(viewModel.marksListProperty());

        addStudentMarksButton.setOnAction(event -> viewModel.addStudent());
        clearButton.setOnAction(event -> viewModel.clearEnteredMarks());
    }
}
