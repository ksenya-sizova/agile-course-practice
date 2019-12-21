package ru.unn.agile.triangle.infrastructure;

import ru.unn.agile.triangle.viewmodel.ViewModel;
import ru.unn.agile.triangle.viewmodel.ViewModelTests;

public class ViewModelWithTxtLoggerTests extends ViewModelTests {
    @Override
    public void setUp() {
        TriangleTxtLogger realLogger =
                new TriangleTxtLogger("./ViewModel_with_TxtLogger_Tests-lab3.log");
        super.setExternalViewModel(new ViewModel(realLogger));
    }
}
