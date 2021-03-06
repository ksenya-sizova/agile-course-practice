package ru.unn.agile.polygon.view;

import javafx.beans.property.Property;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.unn.agile.polygon.model.Point;
import ru.unn.agile.polygon.viewmodel.ViewModel;

public class CalcArea {
    private final PseudoClass errorClass = PseudoClass.getPseudoClass("error");
    private final String pointInputTooltip = "Only numbers allowed";

    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField xTextField;
    @FXML
    private TextField yTextField;
    @FXML
    private Button addPointButton;
    @FXML
    private Button calcAreaButton;

    @FXML
    private TableView<Point> tablePoints;
    @FXML
    private TableColumn<Point, Double> xColumn;
    @FXML
    private TableColumn<Point, Double> yColumn;

    @FXML
    private TextArea resultTextArea;

    @FXML
    void initialize() {
        initAddPointForm();
        initTableView();
        initControlPanel();
    }

    private void initAddPointForm() {
        initTextField(xTextField, viewModel.xProperty());
        initTextField(yTextField, viewModel.yProperty());

        viewModel.xProperty().addListener(obs ->
                setErrorBorder(xTextField, !viewModel.isCoordinatesInputCorrect()));
        viewModel.yProperty().addListener(obs ->
                setErrorBorder(yTextField, !viewModel.isCoordinatesInputCorrect()));

        addPointButton.disableProperty()
                .bindBidirectional(viewModel.addingNewPointDisabledProperty());
        addPointButton.setOnAction(e -> viewModel.addPoint());
    }
    private void initTableView() {
        xColumn.setCellValueFactory(
                new PropertyValueFactory<Point, Double>("X"));
        yColumn.setCellValueFactory(
                new PropertyValueFactory<Point, Double>("Y"));
    }

    private void initControlPanel() {
        calcAreaButton.setOnAction(e -> viewModel.calcArea());
        resultTextArea.textProperty().bindBidirectional(viewModel.resultProperty());
    }

    private void initTextField(final TextField textField,
                               final Property<String> property) {
        bindTextFieldProperty(textField, property);
        setTextFieldTooltip(textField);
    }

    private void setTextFieldTooltip(final TextField textField) {
        textField.tooltipProperty().setValue(new Tooltip(pointInputTooltip));
    }

    private void bindTextFieldProperty(final TextField textField,
                                       final Property<String> property) {
        textField.textProperty().bindBidirectional(property);
    }

    private void setErrorBorder(final TextField textField, final boolean active) {
        textField.pseudoClassStateChanged(errorClass, active);
    }

}
