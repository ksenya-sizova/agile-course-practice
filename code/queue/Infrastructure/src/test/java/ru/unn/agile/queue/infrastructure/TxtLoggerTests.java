package ru.unn.agile.queue.infrastructure;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;



public class TxtLoggerTests {
    private static final String LOGGER_FILENAME = "./TxtLoggerTests.log";
    private TxtLogger logger;

    @Before
    public void setUp() {
        logger = new TxtLogger(LOGGER_FILENAME);
    }

    @Test
    public void canCreateLoggerWithFileName() {
        assertNotNull(logger);
    }

    @Test
    public void canCreateLogFileOnDisk() {
        try {
            new BufferedReader(new FileReader(LOGGER_FILENAME));
        } catch (FileNotFoundException e) {
            fail("File " + LOGGER_FILENAME + " wasn't found!");
        }
    }
}
