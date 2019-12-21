package ru.unn.agile.binarytree.viewmodel;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import ru.unn.agile.binarytree.model.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private BinaryTree storage = new BinaryTree();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    private final StringProperty addKey = new SimpleStringProperty();
    private final StringProperty addValue = new SimpleStringProperty();
    private final StringProperty findKey = new SimpleStringProperty();
    private final StringProperty removeKey = new SimpleStringProperty();

    private final StringProperty addStatus = new SimpleStringProperty();

    private final StringProperty findResult = new SimpleStringProperty();
    private final StringProperty findStatus = new SimpleStringProperty();

    private final StringProperty removeResult = new SimpleStringProperty();
    private final StringProperty removeStatus = new SimpleStringProperty();

    public ViewModel() {
        addKey.set("");
        addValue.set("");
        addStatus.set(Status.WAITING.toString());

        findKey.set("");
        findResult.set("");
        findStatus.set(Status.WAITING.toString());

        removeKey.set("");
        removeResult.set("");
        removeStatus.set(Status.WAITING.toString());

        final List<StringProperty> fields = new ArrayList<>() {
            {
                add(addKey);
                add(addValue);
                add(findKey);
                add(removeKey);
            }
        };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    public StringProperty addKeyProperty() {
        return addKey;
    }

    public StringProperty addValueProperty() {
        return addValue;
    }

    public StringProperty addStatusProperty() {
        return addStatus;
    }

    public StringProperty findKeyProperty() {
        return findKey;
    }

    public StringProperty findResultProperty() {
        return findResult;
    }

    public StringProperty findStatusProperty() {
        return findStatus;
    }

    public StringProperty removeKeyProperty() {
        return removeKey;
    }

    public StringProperty removeResultProperty() {
        return removeResult;
    }

    public StringProperty removeStatusProperty() {
        return removeStatus;
    }

    public String getAddStatus() {
        return addStatus.get();
    }

    public String getFindResult() {
        return findResult.get();
    }

    public String getFindStatus() {
        return findStatus.get();
    }

    public String getRemoveResult() {
        return removeResult.get();
    }

    public String getRemoveStatus() {
        return removeStatus.get();
    }

    public void add() {
        final int key = Integer.parseInt(addKey.get());
        final String value = addValue.get();

        storage.add(key, value);

        addStatus.set(Status.SUCCESS.toString());
    }

    public void find() {
        final int key = Integer.parseInt(findKey.get());

        String result = storage.find(key);

        if (result == null) {
            result = ">NOT FOUND<";
        }

        findResult.set(result);
        findStatus.set(Status.SUCCESS.toString());
    }

    public void remove() {
        final int key = Integer.parseInt(removeKey.get());

        final boolean result = storage.remove(key);

        removeResult.set(Boolean.toString(result));
        removeStatus.set(Status.SUCCESS.toString());
    }

    private Status getAddInputStatus() {
        Status addStatus = Status.READY;
        if (addKey.get().isEmpty() || addValue.get().isEmpty()) {
            addStatus = Status.WAITING;
        }
        try {
            if (!addKey.get().isEmpty()) {
                Integer.parseInt(addKey.get());
            }
            if (!addValue.get().isEmpty()) {
                addValue.get();
            }
        } catch (NumberFormatException nfe) {
            addStatus = Status.BAD_FORMAT;
        }

        return addStatus;
    }

    private Status getFindInputStatus() {
        Status findStatus = Status.READY;
        if (findKey.get().isEmpty()) {
            findStatus = Status.WAITING;
        }
        try {
            if (!findKey.get().isEmpty()) {
                Integer.parseInt(findKey.get());
            }
        } catch (NumberFormatException nfe) {
            findStatus = Status.BAD_FORMAT;
        }

        return findStatus;
    }

    private Status getRemoveInputStatus() {
        Status removeStatus = Status.READY;
        if (removeKey.get().isEmpty()) {
            removeStatus = Status.WAITING;
        }
        try {
            if (!removeKey.get().isEmpty()) {
                Integer.parseInt(removeKey.get());
            }
        } catch (NumberFormatException nfe) {
            removeStatus = Status.BAD_FORMAT;
        }

        return removeStatus;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            addStatus.set(getAddInputStatus().toString());
            findStatus.set(getFindInputStatus().toString());
            removeStatus.set(getRemoveInputStatus().toString());
        }
    }
}

enum Status {
    WAITING("Please provide full input data"),
    READY("Press button"),
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
