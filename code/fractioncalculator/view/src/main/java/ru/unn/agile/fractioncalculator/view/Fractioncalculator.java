package ru.unn.agile.fractioncalculator.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ru.unn.agile.fractioncalculator.viewmodel.ViewModel;

public class Fractioncalculator {

    @FXML private ViewModel viewModel;

    @FXML private Button plusButton;
    @FXML private Button minusButton;
    @FXML private Button multipleButton;
    @FXML private Button divideButton;

    @FXML private Label resultLabel;

    @FXML
    void init() {

    }
}
