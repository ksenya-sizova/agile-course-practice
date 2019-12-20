package ru.unn.agile.fractioncalculator.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.unn.agile.fractioncalculator.viewmodel.ViewModel;

public class Fractioncalculator {

    @FXML private ViewModel viewModel;

    @FXML private TextField firstFraction;
    @FXML private TextField secondFraction;

    @FXML private Button plusButton;
    @FXML private Button minusButton;
    @FXML private Button multipleButton;
    @FXML private Button divideButton;

    @FXML private Label resultLabel;

    @FXML
    void init() {
        firstFraction.textProperty().bindBidirectional(viewModel.firstFractionProperty());
        secondFraction.textProperty().bindBidirectional(viewModel.secondFractionProperty());
    }
}
