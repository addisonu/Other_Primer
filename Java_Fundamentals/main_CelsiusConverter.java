//ASSIGNMENT : Project 10
//DATE : 03/22/15
//FILE : main_CelsiusConverter.java
//DESC : GUI application that converts Celsius degrees into Fahrenheit degrees

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class main_CelsiusConverter{
    public static void main(String args[]){
        CelsiusConverter demo = new CelsiusConverter();
    }
}

class CelsiusConverter extends JFrame{

// DATA MEMBERS //
    private JPanel panel;
    private JLabel messageLabel;
    private JLabel resultLabel;
    private JTextField celsiusTextField;
    private JButton calcButton;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 100;

// MEMBER FUNCTIONS //
// CONSTRUCTOR //
    CelsiusConverter(){
        setTitle("Celsius to Fahrenheit Temperature Converter");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
    }

    private void buildPanel(){

// Panel components
        messageLabel = new JLabel("Enter a temperature in Celsius :");
        celsiusTextField = new JTextField(10);
        calcButton = new JButton("Calculate");
        calcButton.addActionListener(new CalcButtonListener());
        resultLabel = new JLabel();
        panel = new JPanel();

//Add panel components to panel
        panel.add(messageLabel);
        panel.add(celsiusTextField);
        panel.add(calcButton);
        panel.add(resultLabel);
    }

//Action listener class for Calculate button
    private class CalcButtonListener implements ActionListener{

// actionPerformed will be invoked when user clicks button
        public void actionPerformed(ActionEvent e){
            String input;
            double temp; // hold Celsius temperature
            input = celsiusTextField.getText();
            temp = Double.parseDouble(input) * (9.0/5.0) + 32;
            DecimalFormat form_temp = new DecimalFormat("#.0000"); //Control display size of temps with many sig figs
            resultLabel.setText("Fahrenheit temperature is " + form_temp.format(temp));
            setVisible(true);
        }
    }
}
