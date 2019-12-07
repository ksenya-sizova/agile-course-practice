package ru.unn.agile.binarytree.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.addKeyProperty().get());
        assertEquals("", viewModel.addValueProperty().get());
        assertEquals("", viewModel.addResultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.addStatusProperty().get());

        assertEquals("", viewModel.findKeyProperty().get());
        assertEquals("", viewModel.findResultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.findStatusProperty().get());

        assertEquals("", viewModel.removeKeyProperty().get());
        assertEquals("", viewModel.removeResultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.removeStatusProperty().get());
    }

    @Test
    public void addStatusIsWaitingWhenOnlyKeyInserted() {
        viewModel.addKeyProperty().set("18");
        assertEquals(Status.WAITING.toString(), viewModel.addStatusProperty().get());
    }

    @Test
    public void addStatusIsWaitingWhenOnlyValuesInserted() {
        viewModel.addValueProperty().set("FOO");
        assertEquals(Status.WAITING.toString(), viewModel.addStatusProperty().get());
    }

    @Test
    public void addStatusIsReadyWhenInsertedBoth() {
        viewModel.addKeyProperty().set("18");
        viewModel.addValueProperty().set("FOO");
        assertEquals(Status.READY.toString(), viewModel.addStatusProperty().get());
    }

    @Test
    public void addStatusIsBadWhenInsertKeyNotInteger() {
        viewModel.addKeyProperty().set("PASS");
        assertEquals(Status.BAD_FORMAT.toString(), viewModel.addStatusProperty().get());
    }

    @Test
    public void findStatusIsReadyWhenIntegerInserted() {
        viewModel.findKeyProperty().set("18");
        assertEquals(Status.READY.toString(), viewModel.findStatusProperty().get());
    }

    @Test
    public void findStatusIsBadWhenNotIntegerInserted() {
        viewModel.findKeyProperty().set("PASS");
        assertEquals(Status.BAD_FORMAT.toString(), viewModel.findStatusProperty().get());
    }

    @Test
    public void removeStatusIsReadyWhenIntegerInserted() {
        viewModel.removeKeyProperty().set("18");
        assertEquals(Status.READY.toString(), viewModel.removeStatusProperty().get());
    }

    @Test
    public void removeStatusIsBadWhenNotIntegerInserted() {
        viewModel.removeKeyProperty().set("PASS");
        assertEquals(Status.BAD_FORMAT.toString(), viewModel.removeStatusProperty().get());
    }

    @Test
    public void addStatusIsSuccessWhenInputCorrect() {
        viewModel.addKeyProperty().set("2");
        viewModel.addValueProperty().set("PASS");

        viewModel.add();

        assertEquals(Status.SUCCESS.toString(), viewModel.addStatusProperty().get());
    }
}
