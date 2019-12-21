package ru.unn.agile.arabicromanconverter.model;

public interface Converter {
    String convertValue(String number);

    boolean validate(String number);
}
