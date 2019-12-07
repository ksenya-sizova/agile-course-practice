package ru.unn.agile.huffman.viewmodel;

import javafx.beans.property.StringProperty;

public class HuffmanViewModel {
    private StringProperty input;

    public HuffmanViewModel() {
        input.set("Hello world");
    }

    public StringProperty getInput() {
        return input;
    }

    public void swapText() {
        input.set("Hello Roma");
    }
}
