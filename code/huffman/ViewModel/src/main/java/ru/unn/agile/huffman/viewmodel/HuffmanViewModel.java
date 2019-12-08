package ru.unn.agile.huffman.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ru.unn.agile.huffman.model.Huffman;

public class HuffmanViewModel {
    private StringProperty input = new SimpleStringProperty();

    public HuffmanViewModel() {
        input.set("Hello world");
    }

    public StringProperty getInput() {
        return input;
    }

    public void swapText() {
        String inputString = input.get();
        Huffman huffmanModel = new Huffman(inputString);
        input.set(huffmanModel.getEncodedString());
    }
}
