package ru.unn.agile.huffman.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import ru.unn.agile.huffman.viewmodel.HuffmanViewModel;

public class Huffman {
    @FXML
    private HuffmanViewModel huffmanViewModel;
    @FXML
    private Label lable1;
    @FXML
    private Button button1;

    @FXML
    void initialize() {
        lable1.textProperty().bindBidirectional(huffmanViewModel.getInput());
        button1.setOnAction(event -> huffmanViewModel.swapText());
    }
}
