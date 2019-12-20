package ru.unn.agile.fractioncalculator.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.fractioncalculator.model.Fraction;


public class ViewModel {

    private StringProperty firstFraction = new SimpleStringProperty();
    private StringProperty secondFraction = new SimpleStringProperty();
    private StringProperty resultFraction = new SimpleStringProperty();

    public StringProperty firstFractionProperty() {
        return firstFraction;
    }

    public StringProperty secondFractionProperty() {
        return secondFraction;
    }

    public StringProperty resultFractionProperty() {
        return resultFraction;
    }

    public void setFirstFraction(String fraction) {
        firstFraction.set(fraction);
    }

    public void setSecondFraction(String fraction) {
        secondFraction.set(fraction);
    }
}
