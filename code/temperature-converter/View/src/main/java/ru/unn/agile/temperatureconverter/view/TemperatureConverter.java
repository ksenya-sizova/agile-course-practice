package ru.unn.agile.temperatureconverter.view;
import ru.unn.agile.temperatureconverter.viewmodel.ViewModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TemperatureConverter {
    private JLabel labelHello;
    private JPanel mainPanel;
    private JLabel labelFrom;
    private JComboBox<ViewModel.ListOfTemperatures> comboBoxFrom;
    private JLabel labelTo;
    private JComboBox<ViewModel.ListOfTemperatures> comboBoxTo;
    private JLabel labelResult;
    private JButton buttonConvert;
    private JLabel labelStatus;
    private JTextField fromField;

    private ViewModel viewModel;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setContentPane(new TemperatureConverter(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public TemperatureConverter(final ViewModel viewModel) {
        this.viewModel = viewModel;
        ViewModel.ListOfTemperatures[] temperatures = ViewModel.ListOfTemperatures.values();

        comboBoxFrom.setModel(new JComboBox<>(temperatures).getModel());
        comboBoxTo.setModel(new JComboBox<>(temperatures).getModel());

        backBind();
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                TemperatureConverter.this.viewModel.calculate();
                backBind();
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                TemperatureConverter.this.viewModel.processInput();
                backBind();
            }
        };
        fromField.addKeyListener(keyListener);
    }

    private void backBind() {
        buttonConvert.setEnabled(viewModel.isConvertButtonEnabled());
        labelResult.setText(viewModel.getResultTemperature());
        labelStatus.setText(viewModel.getStatusText());
    }

    private void bind() {
        viewModel.setFromTemperature(fromField.getText());
        viewModel.setFrom((ViewModel.ListOfTemperatures) comboBoxFrom.getSelectedItem());
        viewModel.setTo((ViewModel.ListOfTemperatures) comboBoxTo.getSelectedItem());
    }
}
