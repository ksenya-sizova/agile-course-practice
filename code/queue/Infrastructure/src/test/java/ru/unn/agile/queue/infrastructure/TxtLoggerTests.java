package ru.unn.agile.queue.infrastructure;

import org.junit.Before;
import org.junit.Test;

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
}
