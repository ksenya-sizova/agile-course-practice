package ru.unn.agile.triangle.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.triangle.*;
import ru.unn.agile.triangle.Triangle.*;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private final StringProperty ax = new SimpleStringProperty();
    private final StringProperty ay = new SimpleStringProperty();
    private final StringProperty bx = new SimpleStringProperty();
    private final StringProperty by = new SimpleStringProperty();
    private final StringProperty cx = new SimpleStringProperty();
    private final StringProperty cy = new SimpleStringProperty();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));
    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public ViewModel() {
        ax.set("");
        ay.set("");
        bx.set("");
        by.set("");
        cx.set("");
        cy.set("");
        operation.set(Operation.GETANGLEA);
        result.set("");
        status.set(Status.WAITING.toString());

        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(ax, ay, bx, by, cx, cy);
            }

            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());

        final List<StringProperty> fields = new ArrayList<StringProperty>() {
            {
                add(ax);
                add(ay);
                add(bx);
                add(by);
                add(cx);
                add(cy);
            }
        };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    public void calculate() {
        if (calculationDisabled.get()) {
            return;
        }

        Point a = new Point(ax.get(), ay.get());
        Point b = new Point(bx.get(), by.get());
        Point c = new Point(cx.get(), cy.get());

        try {
            Triangle triangle = new Triangle(a, b, c);
            result.set(operation.get().apply(triangle).toString());
            status.set(Status.SUCCESS.toString());
        } catch (Exception ex) {
            status.set(ex.getMessage());
        }
    }

    public StringProperty axProperty() {
        return ax;
    }

    public StringProperty ayProperty() {
        return ay;
    }

    public StringProperty bxProperty() {
        return bx;
    }

    public StringProperty byProperty() {
        return by;
    }

    public StringProperty cxProperty() {
        return cx;
    }

    public StringProperty cyProperty() {
        return cy;
    }

    public ObjectProperty<ObservableList<Operation>> operationsProperty() {
        return operations;
    }

    public final ObservableList<Operation> getOperations() {
        return operations.get();
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }

    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }

    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    public StringProperty resultProperty() {
        return result;
    }

    public final String getResult() {
        return result.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public final String getStatus() {
        return status.get();
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        if (ax.get().isEmpty() || ay.get().isEmpty()
                || bx.get().isEmpty() || by.get().isEmpty()
                || cx.get().isEmpty() || cy.get().isEmpty()) {
            inputStatus = Status.WAITING;
        }
        try {
            if (!ax.get().isEmpty()) {
                Double.parseDouble(ax.get());
            }
            if (!ay.get().isEmpty()) {
                Double.parseDouble(ay.get());
            }
            if (!bx.get().isEmpty()) {
                Double.parseDouble(bx.get());
            }
            if (!by.get().isEmpty()) {
                Double.parseDouble(by.get());
            }
            if (!cx.get().isEmpty()) {
                Double.parseDouble(cx.get());
            }
            if (!cy.get().isEmpty()) {
                Double.parseDouble(cy.get());
            }
        } catch (NumberFormatException nfe) {
            inputStatus = Status.BAD_FORMAT;
        }

        return inputStatus;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
        }
    }
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Calculate' or Enter"),
    BAD_FORMAT("Bad format"),
    SUCCESS("Success");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
