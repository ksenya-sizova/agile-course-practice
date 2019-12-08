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
    public void checkRefLabelTextByDefaultText() {
        assertEquals(viewModel.getInput().get(), "Reference string");
    }

    @Test
    public void checkEncodeLabelTextByDefaultText() {
        assertEquals(viewModel.getOutputEncode().get(), "Encode");
    }

    @Test
    public void checkEncodeLabelAfterPushStartWithZeroString() {
        viewModel.setInput("");
        viewModel.startEncodeAndDecode();
        assertEquals(viewModel.getOutputEncode().get(), "");
    }
}
