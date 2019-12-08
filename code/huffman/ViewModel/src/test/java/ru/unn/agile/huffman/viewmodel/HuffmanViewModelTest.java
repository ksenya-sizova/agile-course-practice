package ru.unn.agile.huffman.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanViewModelTest {
    private HuffmanViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new HuffmanViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void checkRefLabelByDefaultText() {
        assertEquals(viewModel.getInput().get(), "Reference string");
    }
}
