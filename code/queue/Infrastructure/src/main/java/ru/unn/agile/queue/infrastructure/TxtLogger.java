package ru.unn.agile.queue.infrastructure;

import ru.unn.agile.queue.viewmodel.ILogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TxtLogger implements ILogger {
    private static final String DATE_AND_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final BufferedWriter writer;
    private final String file;

    public TxtLogger(final String filename) {
        this.file = filename;

        BufferedWriter logWriter = null;
        try {
            logWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.writer = logWriter;
    }

    @Override
    public void log(final String message) {
    }

    @Override
    public List<String> getLog() {
          ArrayList<String> log = new ArrayList<String>();
          return log;
    }
}
