package ru.unn.agile.sorting.model.impl;

import ru.unn.agile.sorting.model.api.Expression;

public class NumberGreaterExpression extends Expression<Integer> {

    @Override
    public boolean compare(final Integer number1, final Integer number2) {
        return number1 > number2;
    }
}
