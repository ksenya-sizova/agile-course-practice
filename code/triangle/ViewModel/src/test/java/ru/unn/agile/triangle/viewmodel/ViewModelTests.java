package ru.unn.agile.triangle.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.triangle.Triangle.*;

import static org.junit.Assert.*;

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
        assertEquals("", viewModel.axProperty().get());
        assertEquals("", viewModel.ayProperty().get());
        assertEquals("", viewModel.bxProperty().get());
        assertEquals("", viewModel.byProperty().get());
        assertEquals("", viewModel.cxProperty().get());
        assertEquals("", viewModel.cyProperty().get());
        assertEquals(Operation.GETANGLEA, viewModel.operationProperty().get());
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsWaitingWhenCalculateWithEmptyFields() {
        viewModel.calculate();
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenFieldsAreFill() {
        viewModel.axProperty().set("1");
        viewModel.ayProperty().set("2");
        viewModel.bxProperty().set("3");
        viewModel.byProperty().set("4");
        viewModel.cxProperty().set("5");
        viewModel.cyProperty().set("6");

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportBadFormat() {
        viewModel.axProperty().set("a");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsWaitingIfNotEnoughCorrectData() {
        viewModel.axProperty().set("1");

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledInitially() {
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWhenFormatIsBad() {
        setInputData();
        viewModel.axProperty().set("trash");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWithIncompleteInput() {
        viewModel.axProperty().set("1");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsEnabledWithCorrectInput() {
        setInputData();

        assertFalse(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void getAngleAIsDefaultOperation() {
        assertEquals(Operation.GETANGLEA, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetAngleBOperation() {
        viewModel.operationProperty().set(Operation.GETANGLEB);
        assertEquals(Operation.GETANGLEB, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetAngleCOperation() {
        viewModel.operationProperty().set(Operation.GETANGLEC);
        assertEquals(Operation.GETANGLEC, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetAreaOperation() {
        viewModel.operationProperty().set(Operation.GETAREA);
        assertEquals(Operation.GETAREA, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetBisectorAOperation() {
        viewModel.operationProperty().set(Operation.GETBISECTORA);
        assertEquals(Operation.GETBISECTORA, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetBisectorBOperation() {
        viewModel.operationProperty().set(Operation.GETBISECTORB);
        assertEquals(Operation.GETBISECTORB, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetBisectorCOperation() {
        viewModel.operationProperty().set(Operation.GETBISECTORC);
        assertEquals(Operation.GETBISECTORC, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetHeightAOperation() {
        viewModel.operationProperty().set(Operation.GETHEIGHTA);
        assertEquals(Operation.GETHEIGHTA, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetHeightBOperation() {
        viewModel.operationProperty().set(Operation.GETHEIGHTB);
        assertEquals(Operation.GETHEIGHTB, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetHeightCOperation() {
        viewModel.operationProperty().set(Operation.GETHEIGHTC);
        assertEquals(Operation.GETHEIGHTC, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetMedianAOperation() {
        viewModel.operationProperty().set(Operation.GETMEDIANA);
        assertEquals(Operation.GETMEDIANA, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetMedianBOperation() {
        viewModel.operationProperty().set(Operation.GETMEDIANB);
        assertEquals(Operation.GETMEDIANB, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetMedianCOperation() {
        viewModel.operationProperty().set(Operation.GETMEDIANC);
        assertEquals(Operation.GETMEDIANC, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetMedianIntersection() {
        viewModel.operationProperty().set(Operation.GETMEDIANINTERSECTION);
        assertEquals(Operation.GETMEDIANINTERSECTION, viewModel.operationProperty().get());
    }

    @Test
    public void canSetGetPerimeter() {
        viewModel.operationProperty().set(Operation.GETPERIMETER);
        assertEquals(Operation.GETPERIMETER, viewModel.operationProperty().get());
    }

    @Test
    public void canSetABLength() {
        viewModel.operationProperty().set(Operation.GETSIDEABLENGTH);
        assertEquals(Operation.GETSIDEABLENGTH, viewModel.operationProperty().get());
    }

    @Test
    public void canSetBCLength() {
        viewModel.operationProperty().set(Operation.GETSIDEBCLENGTH);
        assertEquals(Operation.GETSIDEBCLENGTH, viewModel.operationProperty().get());
    }

    @Test
    public void canSetACLength() {
        viewModel.operationProperty().set(Operation.GETSIDEACLENGTH);
        assertEquals(Operation.GETSIDEACLENGTH, viewModel.operationProperty().get());
    }

    @Test
    public void operationGetAngleAHasCorrectResult() {
        setInputData();
        viewModel.calculate();
        assertEquals("90", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetAngleBHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETANGLEB);
        viewModel.calculate();
        assertEquals("45", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetAngleCHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETANGLEC);
        viewModel.calculate();
        assertEquals("45", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetAreaHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETAREA);
        viewModel.calculate();
        assertEquals("0.5", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetBisectorAHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETBISECTORA);
        viewModel.calculate();
        assertEquals("0.71", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetBisectorBHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETBISECTORB);
        viewModel.calculate();
        assertEquals("1.08", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetBisectorCHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETBISECTORC);
        viewModel.calculate();
        assertEquals("1.08", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetHeightAHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETHEIGHTA);
        viewModel.calculate();
        assertEquals("0.71", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetHeightBHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETHEIGHTB);
        viewModel.calculate();
        assertEquals("1", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetHeightCHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETHEIGHTC);
        viewModel.calculate();
        assertEquals("1", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetMedianAHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETMEDIANA);
        viewModel.calculate();
        assertEquals("0.71", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetMedianBHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETMEDIANB);
        viewModel.calculate();
        assertEquals("1.12", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetMedianCHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETMEDIANC);
        viewModel.calculate();
        assertEquals("1.12", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetMedianIntersectionHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETMEDIANINTERSECTION);
        viewModel.calculate();
        assertEquals("(0.33,0.33)", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetPerimeterHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETPERIMETER);
        viewModel.calculate();
        assertEquals("3.41", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetSideABLengthHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETSIDEABLENGTH);
        viewModel.calculate();
        assertEquals("1", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetSideBCLengthHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETSIDEBCLENGTH);
        viewModel.calculate();
        assertEquals("1.41", viewModel.resultProperty().get());
    }

    @Test
    public void operationGetSideACLengthHasCorrectResult() {
        setInputData();
        viewModel.operationProperty().set(Operation.GETSIDEACLENGTH);
        viewModel.calculate();
        assertEquals("1", viewModel.resultProperty().get());
    }

    @Test
    public void canSetSuccessMessage() {
        setInputData();
        viewModel.calculate();
        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canSetBadFormatMessage() {
        viewModel.axProperty().set("#selfie");
        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenSetProperData() {
        setInputData();
        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    private void setInputData() {
        viewModel.axProperty().set("0");
        viewModel.ayProperty().set("0");
        viewModel.bxProperty().set("0");
        viewModel.byProperty().set("1");
        viewModel.cxProperty().set("1");
        viewModel.cyProperty().set("0");
    }
}
