package ru.unn.agile.studentsperformance.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ViewModelTest {

    private static final double DELTA = 1e-3;

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
    public void canGetMarkListValues() {
        var marks = Arrays.asList(2, 3, 4, 5);

        assertTrue(viewModel.marksProperty().containsAll(marks));
    }

    @Test
    public void canGetMathsMarkProperty() {
        var property = viewModel.mathsMarkProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetEnglishProperty() {
        var property = viewModel.englishMarkProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetHistoryProperty() {
        var property = viewModel.historyMarkProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetProgrammingProperty() {
        var property = viewModel.programmingMarkProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetMarksListProperty() {
        var property = viewModel.marksListProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetAverageProperty() {
        var property = viewModel.averageProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetExcellentCountProperty() {
        var property = viewModel.excellentCountProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetGoodCountProperty() {
        var property = viewModel.goodCountProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetSatisfactoryCountProperty() {
        var property = viewModel.satisfactoryCountProperty();

        assertNotNull(property);
    }

    @Test
    public void canGetBadCountProperty() {
        var property = viewModel.badCountProperty();

        assertNotNull(property);
    }

    @Test
    public void canAddStudent() {
        viewModel.addStudent();

        assertFalse(viewModel.marksListProperty().isEmpty());
    }

    @Test
    public void canCalculateAverageForGoodStudent() {
        var good = 4;
        setMarksForAllSubjects(good);

        viewModel.addStudent();

        assertEquals(good, Double.parseDouble(viewModel.averageProperty().get()), DELTA);
    }

    @Test
    public void canCalculateCountOfExcellentStudents() {
        var excellent = 5;
        setMarksForAllSubjects(excellent);

        viewModel.addStudent();
        viewModel.addStudent();

        assertEquals(2, Integer.parseInt(viewModel.excellentCountProperty().get()));
    }

    @Test
    public void canClear() {
        setMarksForAllSubjects(3);
        setMarksForAllSubjects(4);
        setMarksForAllSubjects(5);

        viewModel.clearEnteredMarks();
        assertTrue(viewModel.marksListProperty().isEmpty());
    }

    private void setMarksForAllSubjects(final int mark) {
        viewModel.mathsMarkProperty().setValue(mark);
        viewModel.englishMarkProperty().setValue(mark);
        viewModel.historyMarkProperty().setValue(mark);
        viewModel.programmingMarkProperty().setValue(mark);
    }
}
