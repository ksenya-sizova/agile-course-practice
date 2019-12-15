package ru.unn.agile.temperatureconverter.viewmodel;

import java.util.ArrayList;
import java.util.List;

class FakeLogger implements ILogger {
    private ArrayList<String> log = new ArrayList<String>();

    @Override
    public void log(final String message) {
        log.add(message);
    }

    @Override
    public List<String> getLog() {
        return log;
    }
}
