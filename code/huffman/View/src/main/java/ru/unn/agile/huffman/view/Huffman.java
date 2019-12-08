package ru.unn.agile.huffman.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import ru.unn.agile.huffman.viewmodel.HuffmanViewModel;

public class Huffman {
    @FXML
    private HuffmanViewModel huffmanViewModel;
    @FXML
    private TextField textFieldRef;
    @FXML
    private Label labelEncode;
    @FXML
    private Button buttonStart;

    @FXML
    void initialize() {
        labelEncode.textProperty().bindBidirectional(huffmanViewModel.getInput());
        buttonStart.setOnAction(event -> huffmanViewModel.swapText());
    }
}
