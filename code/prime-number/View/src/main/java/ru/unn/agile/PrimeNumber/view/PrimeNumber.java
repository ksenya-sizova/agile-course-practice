package ru.unn.agile.PrimeNumber.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.unn.agile.PrimeNumber.viewmodel.ViewModel;

public class PrimeNumber {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField startElement;
    @FXML
    private TextField endElement;
    @FXML
    private Button btnOk;
    @FXML
    private TextArea outputField;

    @FXML
    void initialize() {

        // Two-way binding hasn't supported by FXML yet, so place it in code-behind
        startElement.textProperty().bindBidirectional(viewModel.startElemProperty());
        endElement.textProperty().bindBidirectional(viewModel.endElemProperty());
        outputField.textProperty().bindBidirectional(viewModel.outputProperty());


        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.findPrimaryNums();
            }
        });
    }
}
