package com.alikbCalculator.view;

import com.alikbCalculator.controller.Calculator;
import com.alikbCalculator.controller.HexCalculator;
import com.alikbCalculator.controller.Utils;
import com.alikbCalculator.model.Decimal;
import com.alikbCalculator.model.Hex;
import com.alikbCalculator.model.Number;

import javax.swing.*;
import java.awt.*;

/**
 * This class constructs a new JPanel that hold all the contents of the hexadecimal calculator
 *
 * @author Alik Balika
 * @version 2020.11.22
 */
public class HexPanel extends JPanel {

    /**
     * Makes 3 JPanels and add them to this panel.
     */
    public HexPanel() {
        super(new GridLayout(3, 1));

        // create a north panel for arithmetic operations
        JPanel northPanel = northPanelForHex();

        // create the center panel
        JPanel centerPanel = centerPanelForHex();

        // create the south panel
        JPanel southPanel = southPanelForHex();

        add(northPanel);
        add(centerPanel);
        add(southPanel);

    }

    /**
     * This method handles all of the contents for the hex addition, subtraction, multiplication, and division.
     * It constructs a main panel where all the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for the hex calculations
     */
    private JPanel northPanelForHex() {
        // create a panel for the arithmetic operations
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // Jlabel for the title
        JLabel arithmeticOP = new JLabel("Hexadecimal Calculation—Add, Subtract, Multiply, or Divide");
        arithmeticOP.setFont(new Font(null, Font.BOLD, 20));
        arithmeticOP.setHorizontalAlignment(JLabel.CENTER);
        panel.add(arithmeticOP);

        // 2 textfields where the user can enter in their hex values
        JTextField hexNum1 = new JTextField(10);
        hexNum1.setPreferredSize(new Dimension(50, 30));
        JTextField hexNum2 = new JTextField(10);
        hexNum2.setPreferredSize(new Dimension(50, 30));


        // string array for the combo box
        String[] ops = {"+", "-", "*", "/"};

        // create a combo box to hold the list of operations
        JComboBox<String> operations = new JComboBox<>(ops);
        operations.setPreferredSize(new Dimension(40, 30));
        operations.setFocusable(false);

        // add textfields and combo box into new panel with flowLayout
        JPanel centerPanel = new JPanel();
        centerPanel.add(hexNum1);
        centerPanel.add(operations);
        centerPanel.add(hexNum2);

        // add center to panel
        panel.add(centerPanel);

        // add calculate and clear buttons and result label
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        clear.addActionListener(e -> {
            hexNum1.setText("");
            hexNum2.setText("");
            result.setText("");
        });

        calculate.addActionListener(e -> {

            String hex1 = hexNum1.getText().replaceAll("\\s", "").toUpperCase();
            String hex2 = hexNum2.getText().replaceAll("\\s", "").toUpperCase();
            if (!Utils.isHex(hex1) || !Utils.isHex(hex2)) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            } else {
                hexNum1.setText(hex1);
                hexNum2.setText(hex2);
                Calculator hc = new HexCalculator();
                Number h1 = new Hex(hex1);
                Number h2 = new Hex(hex2);
                result.setForeground(Color.BLACK);
                switch (operations.getSelectedIndex()) {
                    case 0 -> result.setText("Hex Value: "+hc.add(h1, h2).toString()+"     Decimal Value: "+hc.add(h1,h2).toDecimal());
                    case 1 -> result.setText("Hex Value: "+hc.subtract(h1, h2).toString()+"     Decimal Value: "+hc.subtract(h1,h2).toDecimal());
                    case 2 -> result.setText("Hex Value: "+hc.multiply(h1, h2).toString()+"     Decimal Value: "+hc.multiply(h1,h2).toDecimal());
                    case 3 -> {
                        try {
                            result.setText(hc.divide(h1, h2));
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
        JPanel southPanel = new JPanel(new BorderLayout());
        panel.add(calculateAndClear);
        panel.add(result);
        return panel;
    }

    /**
     * This method handles all of the contents for the hex conversion to decimal.
     * It constructs a main panel where all the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for hex conversion to decimal
     */
    private JPanel centerPanelForHex() {

        // Create the panel
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // add a jlabel to the panel
        JLabel convertHexToDec = new JLabel("Convert Hex Value to Decimal Value");
        convertHexToDec.setFont(new Font(null, Font.BOLD, 20));
        convertHexToDec.setHorizontalAlignment(JLabel.CENTER);
        panel.add(convertHexToDec);

        // create a new panel with a flow layout
        JPanel centerPanel = new JPanel();

        // create jlabel and jtextfield and add them to the center panel
        JLabel hexValue = new JLabel("Hex Value: ");
        hexValue.setFont(new Font(null, Font.PLAIN, 15));
        JTextField hexToConvert = new JTextField(10);
        centerPanel.add(hexValue);
        centerPanel.add(hexToConvert);
        panel.add(centerPanel);

        // add calculate and clear buttons and result label
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        // clear action listener
        clear.addActionListener(e -> {
            hexToConvert.setText("");
            result.setText("");
        });

        // calculate action listener
        calculate.addActionListener(e -> {
            String h = hexToConvert.getText().replaceAll("\\s", "").toUpperCase();
            if (!Utils.isHex(h)) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            } else {
                hexToConvert.setText(h);
                result.setForeground(Color.BLACK);
                Hex hex = new Hex(h);
                result.setText(hex.toDecimal() + "");
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
     * This method handles all of the contents for the decimal conversion to hex.
     * It constructs a main panel where all the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for decimal conversion to hex
     */
    private JPanel southPanelForHex() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // add a jlabel to the south panel
        JLabel convertDecToHex = new JLabel("Convert Decimal Value to Hex Value");
        convertDecToHex.setFont(new Font(null, Font.BOLD, 20));
        convertDecToHex.setHorizontalAlignment(JLabel.CENTER);
        panel.add(convertDecToHex);

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
                result.setText(dec.toHex());
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
