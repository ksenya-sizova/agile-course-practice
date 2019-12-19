package ru.unn.agile.calc.model;

import java.util.List;

public interface ILogger {
    void log(String s);

    List<String> getLog();
}
