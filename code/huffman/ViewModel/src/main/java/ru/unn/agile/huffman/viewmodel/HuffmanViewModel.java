package ru.unn.agile.huffman.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import ru.unn.agile.huffman.model.Huffman;

public class HuffmanViewModel {
    private StringProperty input = new SimpleStringProperty();
    private StringProperty outputEncode = new SimpleStringProperty();
    private StringProperty outputDecode = new SimpleStringProperty();
    private StringProperty show = new SimpleStringProperty();
    private boolean enabledButtonStart = true;

    public HuffmanViewModel() {
        input.set("Reference string");
        outputEncode.set("Encode");
        outputDecode.set("Decode");
    }

    public StringProperty getInput() {
        return input;
    }

    public void setInput(String str) {
        input.set(str);
    }

    public StringProperty getOutputEncode() {
        return outputEncode;
    }

    public StringProperty getOutputDecode() {
        return outputDecode;
    }

    public StringProperty getShow() {
        return show;
    }

    public void startEncodeAndDecode() {
        String inputString = input.get();
        Huffman huffmanModel = new Huffman(inputString);
        outputEncode.set(huffmanModel.getEncodedString());
        outputDecode.set(huffmanModel.getDecodedString());
        show.set(huffmanModel.toString());
    }

    public boolean getButtonStartEnabled() {
        return enabledButtonStart;
    }
}
