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
    public void checkDecodeLabelTextByDefaultText() {
        assertEquals(viewModel.getOutputDecode().get(), "Decode");
    }

    @Test
    public void checkEncodeLabelAfterPushStartWithZeroString() {
        viewModel.setInput("");
        viewModel.startEncodeAndDecode();
        assertEquals(viewModel.getOutputEncode().get(), "");
    }

    @Test
    public void checkEncodeLabelAfterPushStartWithString() {
        viewModel.setInput("ab");
        viewModel.startEncodeAndDecode();
        assertEquals(viewModel.getOutputEncode().get(), "01");
    }

    @Test
    public void checkDecodeLabelAfterPushStartWithZeroString() {
        viewModel.setInput("");
        viewModel.startEncodeAndDecode();
        assertEquals(viewModel.getOutputDecode().get(), "");
    }

    @Test
    public void checkShowLabelAfterPushStartWithString() {
        viewModel.setInput("ab");
        viewModel.startEncodeAndDecode();
        assertEquals(viewModel.getShow().get(), "01 -> ab");
    }
}
