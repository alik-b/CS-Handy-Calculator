package com.alikbCalculator.view;

import com.alikbCalculator.controller.BinaryCalculator;
import com.alikbCalculator.controller.Calculator;
import com.alikbCalculator.controller.Utils;
import com.alikbCalculator.model.Binary;
import com.alikbCalculator.model.Decimal;
import com.alikbCalculator.model.Number;

import javax.swing.*;
import java.awt.*;

/**
 * This class constructs a new JPanel that hold all the contents of the binary calculator
 *
 * @author Alik Balika
 * @version 2020.11.22
 */
public class BinaryPanel extends JPanel {

    /**
     * Makes 3 JPanels and add them to this panel.
     */
    public BinaryPanel() {
        super(new GridLayout(3, 1));

        // create a north panel for the arithmetic operations
        JPanel northPanel = northPanelForBinary();

        // Create the center panel
        JPanel centerPanel = centerPanelForBinary();

        // create the south panel
        JPanel southPanel = southPanelForBinary();

        add(northPanel);
        add(centerPanel);
        add(southPanel);

    }

    /**
     * This method handles all of the contents for the binary addition, subtraction, multiplication, and division.
     * It constructs a main panel where all the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for the binary calculations
     */
    private JPanel northPanelForBinary() {
        // create a panel for the arithmetic operations
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // Jlabel for the title
        JLabel arithmeticOP = new JLabel("Binary Calculation—Add, Subtract, Multiply, or Divide");
        arithmeticOP.setFont(new Font(null, Font.BOLD, 20));
        arithmeticOP.setHorizontalAlignment(JLabel.CENTER);
        panel.add(arithmeticOP);

        // 2 textfields where the user can enter in their binary values
        JTextField binaryNum1 = new JTextField(10);
        binaryNum1.setPreferredSize(new Dimension(50, 30));
        JTextField binaryNum2 = new JTextField(10);
        binaryNum2.setPreferredSize(new Dimension(50, 30));


        // string array for the combo box
        String[] ops = {"+", "-", "*", "/"};

        // create a combo box to hold the list of operations
        JComboBox<String> operations = new JComboBox<>(ops);
        operations.setPreferredSize(new Dimension(40, 30));
        operations.setFocusable(false);

        // add textfields and combo box into new panel with flowLayout
        JPanel centerPanel = new JPanel();
        centerPanel.add(binaryNum1);
        centerPanel.add(operations);
        centerPanel.add(binaryNum2);

        // add center to panel
        panel.add(centerPanel);

        // add calculate and clear buttons and result label
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        clear.addActionListener(e -> {
            binaryNum1.setText("");
            binaryNum2.setText("");
            result.setText("");
        });

        calculate.addActionListener(e -> {

            String binary1 = binaryNum1.getText().replaceAll("\\s", "");
            String binary2 = binaryNum2.getText().replaceAll("\\s", "");
            if (!Utils.isBinary(binary1) || !Utils.isBinary(binary2)) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            } else {
                binaryNum1.setText(binary1);
                binaryNum2.setText(binary2);
                result.setForeground(Color.BLACK);
                Calculator bc = new BinaryCalculator();
                Number b1 = new Binary(binary1);
                Number b2 = new Binary(binary2);

                switch (operations.getSelectedIndex()) {
                    case 0 -> result.setText("Binary Value: "+bc.add(b1, b2).toString()+"     Decimal Value: "+bc.add(b1,b2).toDecimal());
                    case 1 -> result.setText("Binary Value: "+bc.subtract(b1, b2).toString()+"     Decimal Value: "+bc.subtract(b1,b2).toDecimal());
                    case 2 -> result.setText("Binary Value: "+bc.multiply(b1, b2).toString()+"     Decimal Value: "+bc.multiply(b1,b2).toDecimal());
                    case 3 -> {
                        try {
                            result.setText(bc.divide(b1, b2));
                        } catch (ArithmeticException exception) {
                            result.setForeground(Color.RED);
                            result.setText("You cannot divide by zero!");
                        }
                    }
                }

            }

        });

        JPanel calculateAndClear = new JPanel();
        calculateAndClear.add(calculate);
        calculateAndClear.add(clear);
        panel.add(calculateAndClear);
        panel.add(result);
        return panel;
    }

    /**
     * This method handles all of the contents for the binary conversion to decimal.
     * It constructs a main panel where all the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for binary conversion to decimal
     */
    private JPanel centerPanelForBinary() {
        // Create the panel
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // add a jlabel to the panel
        JLabel convertBintoDec = new JLabel("Convert Binary Value to Decimal Value");
        convertBintoDec.setFont(new Font(null, Font.BOLD, 20));
        convertBintoDec.setHorizontalAlignment(JLabel.CENTER);
        panel.add(convertBintoDec);

        // create a new panel with a flow layout
        JPanel centerPanel = new JPanel();

        // create jlabel and jtextfield and add them to the center panel
        JLabel binaryValue = new JLabel("Binary Value: ");
        binaryValue.setFont(new Font(null, Font.PLAIN, 15));
        JTextField binaryToConvert = new JTextField(10);
        centerPanel.add(binaryValue);
        centerPanel.add(binaryToConvert);
        panel.add(centerPanel);

        // add calculate and clear buttons and result label
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        // clear action listener
        clear.addActionListener(e -> {
            binaryToConvert.setText("");
            result.setText("");
        });

        // calculate action listener
        calculate.addActionListener(e -> {

            String b = binaryToConvert.getText().replaceAll("\\s", "");
            if (!Utils.isBinary(b)) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            } else {
                result.setForeground(Color.BLACK);
                Binary binary = new Binary(b);
                binaryToConvert.setText(b);
                result.setText(binary.toDecimal()+"");
            }
        });


        // add everything to the required panels
        JPanel calculateAndClear = new JPanel();
        calculateAndClear.add(calculate);
        calculateAndClear.add(clear);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(calculateAndClear, BorderLayout.NORTH);
        panel.add(southPanel);
        panel.add(result);
        return panel;
    }

    /**
     * This method handles all of the contents for the decimal conversion to binary.
     * It constructs a main panel where all the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for decimal conversion to binary
     */
    private JPanel southPanelForBinary() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // add a jlabel to the south panel
        JLabel convertDecToBin = new JLabel("Convert Decimal Value to Binary Value");
        convertDecToBin.setFont(new Font(null, Font.BOLD, 20));
        convertDecToBin.setHorizontalAlignment(JLabel.CENTER);
        panel.add(convertDecToBin);

        // create a new panel with a flow layout
        JPanel centerPanel = new JPanel();

        // create jlabel and jtextfield and add them to the center panel
        JLabel decimalValue = new JLabel("Decimal Value: ");
        decimalValue.setFont(new Font(null, Font.PLAIN, 15));
        JTextField decimalToConvert = new JTextField(10);
        centerPanel.add(decimalValue);
        centerPanel.add(decimalToConvert);
        panel.add(centerPanel);

        // add calculate and clear buttons and result label
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        clear.addActionListener(e -> {
            decimalToConvert.setText("");
            result.setText("");
        });

        calculate.addActionListener(e -> {
            try {
                String d = decimalToConvert.getText().replaceAll("\\s", "");
                result.setForeground(Color.BLACK);
                Decimal dec = new Decimal(Long.parseLong(d));
                decimalToConvert.setText(d);
                result.setText(dec.toBinary());
            } catch (NumberFormatException exception) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            }
        });

        JPanel calculateAndClear = new JPanel();
        calculateAndClear.add(calculate);
        calculateAndClear.add(clear);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(calculateAndClear);
        panel.add(southPanel);
        panel.add(result);

        return panel;
    }

}
