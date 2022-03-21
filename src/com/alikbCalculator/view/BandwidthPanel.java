package com.alikbCalculator.view;

import com.alikbCalculator.controller.Converter;
import com.alikbCalculator.controller.DownloadUploadTimeCalculator;
import com.alikbCalculator.controller.WebsiteBandwidthCalculator;
import com.alikbCalculator.model.*;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 * This class constructs a new JPanel that hold all the contents of the bandwidth calculator
 *
 * @author Alik Balika
 * @version 2020.11.22
 */
public class BandwidthPanel extends JPanel {

    /**
     * boolean to keep track of what has been swapped
     */
    private boolean isMonthlyUsage = true;

    /**
     * fields needed for the hosting converter
     */
    private JComboBox<String> monthlyUsageUnit;
    private JComboBox<String> bandwidthUnit;

    /**
     * Makes 4 JPanels and add them to this panel.
     */
    public BandwidthPanel() {
        super(new GridLayout(4, 1));

        // create first panel
        JPanel firstPanel = firstPanelForBandwidth();

        // create second panel
        JPanel secondPanel = secondPanelForBandwidth();

        // create third panel
        JPanel thirdPanel = thirdPanelForBandwidth();

        // create fourth panel
        JPanel fourthPanel = fourthPanelForBandwidth();

        add(firstPanel);
        add(secondPanel);
        add(thirdPanel);
        add(fourthPanel);

    }

    /**
     * This method handles all of the contents for the data unit converter. It constructs a main panel where all
     * the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for the data unit converter
     */
    private JPanel firstPanelForBandwidth() {
        // create a panel for the data unit converter
        JPanel panel = new JPanel(new BorderLayout());

        // Jlabel for the title
        JLabel dataUnitConverter = new JLabel("Data Unit Converter");
        dataUnitConverter.setFont(new Font(null, Font.BOLD, 20));
        dataUnitConverter.setHorizontalAlignment(JLabel.CENTER);

        // new JPanel with flowLayout containing the textfield and the combobox
        JTextField value = new JTextField(10);
        value.setPreferredSize(new Dimension(50, 25));

        String[] u = {"bits (b)", "kilobits (kb)", "megabits (mb)", "gigabits (gb)", "terabits (tb)", "Bytes (B)",
                "Kilobytes (KB)", "Megabytes (MB)", "Gigabytes (GB)", "Terabytes (TB)"};
        JComboBox<String> units = new JComboBox<>(u);
        units.setFocusable(false);
        JPanel textFieldAndComboBox = new JPanel();
        textFieldAndComboBox.add(value);
        textFieldAndComboBox.add(units);

        // add calculate and clear buttons and into a new JPanel
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JPanel calculateAndClear = new JPanel();
        calculateAndClear.add(calculate);
        calculateAndClear.add(clear);

        // make a new text area to display the result
        JTextPane result = new JTextPane();
        result.setFont(new Font(null, Font.BOLD, 15));
        result.setPreferredSize(new Dimension(312, 240));
        result.setEditable(false);

        // center the text in the textpane
        StyledDocument doc = result.getStyledDocument();
        SimpleAttributeSet cenText = new SimpleAttributeSet();
        StyleConstants.setAlignment(cenText, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), cenText, false);

        // add textfield and combo box and textarea into one center panel
        JPanel center = new JPanel(new BorderLayout());
        center.add(textFieldAndComboBox, BorderLayout.NORTH);
        center.add(result);



        // add action listener for clear button
        clear.addActionListener(e -> {
            value.setText("");
            result.setText("");
        });

        // add action listener for calculate button
        calculate.addActionListener(e -> {
            try {
                String valueString = value.getText().replaceAll("\\s", "");
                if (Double.parseDouble(valueString) < 0 ) {
                    result.setText("Number cannot be negative!");
                } else {
                    value.setText(valueString);
                    // change color to black
                    Style style = result.addStyle("Black", null);
                    StyleConstants.setForeground(style, Color.BLACK);
                    try {
                        doc.insertString(doc.getLength(), "Black", style);
                    } catch (BadLocationException exception1) {
                        exception1.printStackTrace();
                    }

                    Size size = SizeUnit.intChooserDataUnitConverter(units.getSelectedIndex());
                    result.setText(Converter.convertDataUnit(new SizeUnit(size, Double.parseDouble(valueString))));
                }
            } catch (NumberFormatException exception) {
                //change color to red
                Style style = result.addStyle("Red", null);
                StyleConstants.setForeground(style, Color.RED);
                try {
                    doc.insertString(doc.getLength(), "Red", style);
                } catch (BadLocationException exception1) {
                    exception1.printStackTrace();
                }
                result.setText("Number is invalid or too large!");
            }

        });

        // add panels/labels into main panel
        panel.add(dataUnitConverter, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);
        panel.add(calculateAndClear, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * This method handles all of the contents for the download/upload time calculator. It constructs a main panel where all
     * the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for the download/upload time calculator
     */
    private JPanel secondPanelForBandwidth() {
        // create a panel for download/upload time
        JPanel panel = new JPanel(new GridLayout(5, 1));

        // Jlabel for the title
        JLabel downUpTime = new JLabel("Download/Upload Time Calculator");
        downUpTime.setFont(new Font(null, Font.BOLD, 20));
        downUpTime.setHorizontalAlignment(JLabel.CENTER);

        // create fileSize label, JTextField, and JComboBox and add into a new panel
        JLabel fileSizeLabel = new JLabel("File Size: ");
        fileSizeLabel.setFont(new Font(null, Font.PLAIN, 15));
        JTextField fileSizeText = new JTextField(10);
        fileSizeText.setPreferredSize(new Dimension(50, 25));
        String[] fileSizeUnits = { "Bytes (B)", "Kilobytes (KB)", "Megabytes (MB)", "Gigabytes (GB)", "Terabytes (TB)" };
        JComboBox<String> fileSizeUnit = new JComboBox<>(fileSizeUnits);
        fileSizeUnit.setFocusable(false);
        JPanel labelTextFieldComboBoxFileSize = new JPanel();
        labelTextFieldComboBoxFileSize.add(fileSizeLabel);
        labelTextFieldComboBoxFileSize.add(fileSizeText);
        labelTextFieldComboBoxFileSize.add(fileSizeUnit);

        // create bandwidth label, JTextField, and JComboBox and add into a new panel
        JLabel bandwidthLabel = new JLabel("Bandwidth: ");
        bandwidthLabel.setFont(new Font(null, Font.PLAIN, 15));
        JTextField bandwidthText = new JTextField(10);
        bandwidthText.setPreferredSize(new Dimension(50, 25));
        String[] bandUnits = { "bit/s", "Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s" };
        JComboBox<String> bandwidthUnit = new JComboBox<>(bandUnits);
        bandwidthUnit.setPreferredSize(new Dimension(119, 25));
        bandwidthUnit.setFocusable(false);
        JLabel paddingLabel = new JLabel("   ");
        JPanel labelTextFieldComboBoxBandwidth = new JPanel();
        labelTextFieldComboBoxBandwidth.add(bandwidthLabel);
        labelTextFieldComboBoxBandwidth.add(bandwidthText);
        labelTextFieldComboBoxBandwidth.add(bandwidthUnit);
        labelTextFieldComboBoxBandwidth.add(paddingLabel);

        // add calculate and clear buttons into a new JPanel
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JPanel calculateAndClear = new JPanel();
        calculateAndClear.add(calculate);
        calculateAndClear.add(clear);

        // create result label
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        // add action listener to clear button
        clear.addActionListener(e -> {
            fileSizeText.setText("");
            bandwidthText.setText("");
            result.setText("");
        });

        // add action listener to calculate button
        calculate.addActionListener(e -> {
            try {
                String fileSizeString = fileSizeText.getText().replaceAll("\\s", "");
                String bandwidthString = bandwidthText.getText().replaceAll("\\s", "");
                if (Double.parseDouble(fileSizeString) < 0 || Double.parseDouble(bandwidthString) < 0) {
                    result.setForeground(Color.RED);
                    result.setText("Number cannot be negative!");
                } else {
                    result.setForeground(Color.BLACK);
                    fileSizeText.setText(fileSizeString);
                    bandwidthText.setText(bandwidthString);

                    Size size = SizeUnit.intChooserOther(fileSizeUnit.getSelectedIndex());
                    Rate rate = RateUnit.intChooser(bandwidthUnit.getSelectedIndex());

                    result.setText(DownloadUploadTimeCalculator.calculate(
                            new SizeUnit(size, Double.parseDouble(fileSizeString)),
                            new RateUnit(rate, Double.parseDouble(bandwidthString))));
                }

            } catch (NumberFormatException exception) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            }
        });


        // add panels/labels
        panel.add(downUpTime);
        panel.add(labelTextFieldComboBoxFileSize);
        panel.add(labelTextFieldComboBoxBandwidth);
        panel.add(calculateAndClear);
        panel.add(result);


        return panel;
    }

    /**
     * This method handles all of the contents for the website bandwidth calculator. It constructs a main panel where all
     * the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for the website bandwidth calculator
     */
    private JPanel thirdPanelForBandwidth() {
        // create a panel for the website bandwidth calculator
        JPanel panel = new JPanel(new GridLayout(6, 1));

        // Jlabel for the title
        JLabel websiteBandwidth = new JLabel("Website Bandwidth Calculator");
        websiteBandwidth.setFont(new Font(null, Font.BOLD, 20));
        websiteBandwidth.setHorizontalAlignment(JLabel.CENTER);

        // create page view label, JTextField, and JComboBox and add into a new panel
        JLabel pageViewsLabel = new JLabel("Page Views: ");
        pageViewsLabel.setFont(new Font(null, Font.PLAIN, 15));
        JTextField pageViewsText = new JTextField(10);
        pageViewsText.setPreferredSize(new Dimension(50, 25));
        String[] pageViewsUnits = { "Per Second", "Per Minute", "Per Hour", "Per Day", "Per Week", "Per Month", "Per Year" };
        JComboBox<String> pageViewsUnit = new JComboBox<>(pageViewsUnits);
        pageViewsUnit.setFocusable(false);
        JPanel labelTextFieldComboBoxPageViews = new JPanel();
        labelTextFieldComboBoxPageViews.add(pageViewsLabel);
        labelTextFieldComboBoxPageViews.add(pageViewsText);
        labelTextFieldComboBoxPageViews.add(pageViewsUnit);

        // create average page size label, JTextField, and JComboBox and add into a new panel
        JLabel avgPageSizeLabel = new JLabel("Average Page Size: ");
        avgPageSizeLabel.setFont(new Font(null, Font.PLAIN, 15));
        JTextField avgPageSizeText = new JTextField(10);
        avgPageSizeText.setPreferredSize(new Dimension(50, 25));
        String[] avgPageSizeUnits = { "Bytes (B)", "Kilobytes (KB)", "Megabytes (MB)", "Gigabytes (GB)", "Terabytes (TB)" };
        JComboBox<String> avgPageSizeUnit = new JComboBox<>(avgPageSizeUnits);
        avgPageSizeUnit.setFocusable(false);
        JLabel paddingLabel1 = new JLabel("      ");
        JPanel labelTextFieldComboBoxAvgPageSize = new JPanel(new FlowLayout());
        labelTextFieldComboBoxAvgPageSize.add(avgPageSizeLabel);
        labelTextFieldComboBoxAvgPageSize.add(avgPageSizeText);
        labelTextFieldComboBoxAvgPageSize.add(avgPageSizeUnit);
        labelTextFieldComboBoxAvgPageSize.add(paddingLabel1);

        // create redundancy label and JTextField and add into a new panel
        JLabel redundancyLabel = new JLabel("Redundancy: ");
        redundancyLabel.setFont(new Font(null, Font.PLAIN, 15));
        JTextField redundancyText = new JTextField(10);
        redundancyText.setPreferredSize(new Dimension(50, 25));
        JLabel paddingLabel2 = new JLabel("                                  ");
        JPanel labelTextFieldRedundancy = new JPanel();
        labelTextFieldRedundancy.add(redundancyLabel);
        labelTextFieldRedundancy.add(redundancyText);
        labelTextFieldRedundancy.add(paddingLabel2);


        // add calculate and clear buttons into a new JPanel
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JPanel calculateAndClear = new JPanel();
        calculateAndClear.add(calculate);
        calculateAndClear.add(clear);

        // create result label
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        // add action listener to clear button
        clear.addActionListener(e -> {
            pageViewsText.setText("");
            avgPageSizeText.setText("");
            redundancyText.setText("");
            result.setText("");
        });

        // add action listener to calculate button
        calculate.addActionListener(e -> {
            try {
                String pageViewsString = pageViewsText.getText().replaceAll("\\s", "");
                String avgPageSizeString = avgPageSizeText.getText().replaceAll("\\s", "");
                String redundancyString = redundancyText.getText().replaceAll("\\s", "");
                if (Double.parseDouble(pageViewsString) < 0 || Double.parseDouble(avgPageSizeString) < 0
                    || Double.parseDouble(redundancyString) < 0) {
                    result.setForeground(Color.RED);
                    result.setText("Number cannot be negative!");
                } else {
                    result.setForeground(Color.BLACK);
                    pageViewsText.setText(pageViewsString);
                    avgPageSizeText.setText(avgPageSizeString);
                    redundancyText.setText(redundancyString);

                    Frequency frequency = FrequencyUnit.intChooserWebsiteBandwidth(pageViewsUnit.getSelectedIndex());
                    Size size = SizeUnit.intChooserOther(avgPageSizeUnit.getSelectedIndex());

                    result.setText(WebsiteBandwidthCalculator.calculate(
                            new SizeUnit(size, Double.parseDouble(avgPageSizeString)),
                            new FrequencyUnit(frequency, Double.parseDouble(pageViewsString)),
                            Double.parseDouble(redundancyString)));
                }

            } catch (NumberFormatException exception) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            }
        });


        // add panels/labels
        panel.add(websiteBandwidth);
        panel.add(labelTextFieldComboBoxPageViews);
        panel.add(labelTextFieldComboBoxAvgPageSize);
        panel.add(labelTextFieldRedundancy);
        panel.add(calculateAndClear);
        panel.add(result);

        return panel;
    }

    /**
     * This method handles all of the contents for the hosting bandwidth converter. It constructs a main panel where all
     * the other components are added to and returns that main panel
     *
     * @return a new JPanel that contain the contents for the hosting bandwidth converter
     */
    private JPanel fourthPanelForBandwidth() {
        // create a panel for the hosting bandwidth converter
        JPanel panel = new JPanel(new GridLayout(6, 1));

        // Jlabel for the title
        JLabel hostingBandwidth = new JLabel("Hosting Bandwidth Converter");
        hostingBandwidth.setFont(new Font(null, Font.BOLD, 20));
        hostingBandwidth.setHorizontalAlignment(JLabel.CENTER);

        // create monthly usage label and textfield and add into a new panel
        JLabel monthlyUsageLabel = new JLabel("Monthly Usage: ");
        monthlyUsageLabel.setFont(new Font(null, Font.PLAIN, 15));
        JTextField textField = new JTextField(10);
        textField.setPreferredSize(new Dimension(50, 25));
        String[] monthlyUsageUnits = { "Bytes (B)", "Kilobytes (KB)", "Megabytes (MB)", "Gigabytes (GB)", "Terabytes (TB)" };
        monthlyUsageUnit = new JComboBox<>(monthlyUsageUnits);
        monthlyUsageUnit.setFocusable(false);
        JPanel labelTextFieldComboBoxMonthlyUsage = new JPanel();
        labelTextFieldComboBoxMonthlyUsage.add(monthlyUsageLabel);
        labelTextFieldComboBoxMonthlyUsage.add(textField);
        labelTextFieldComboBoxMonthlyUsage.add(monthlyUsageUnit);

        // add a swap button
        JPanel swapPanel = new JPanel();
        JButton swap = new JButton("Swap");
        swapPanel.add(swap);

        // create bandwidth label and textfield and add into a new panel
        JLabel bandwidthLabel = new JLabel("Bandwidth:");
        bandwidthLabel.setFont(new Font(null, Font.PLAIN, 15));
        String[] bandUnits = { "bit/s", "Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s" };
        bandwidthUnit = new JComboBox<>(bandUnits);
        bandwidthUnit.setPreferredSize(new Dimension(119, 25));
        bandwidthUnit.setFocusable(false);
        JPanel labelAndTextFieldBandwidth = new JPanel();
        labelAndTextFieldBandwidth.add(bandwidthLabel);
        labelAndTextFieldBandwidth.add(bandwidthUnit);

        // add calculate and clear buttons into a new JPanel
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JPanel calculateAndClear = new JPanel();
        calculateAndClear.add(calculate);
        calculateAndClear.add(clear);

        // create result label
        JLabel result = new JLabel("");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font(null, Font.ITALIC, 15));

        // add action listener for clear button
        clear.addActionListener(e -> {
            textField.setText("");
            result.setText("");
        });

        // create ComboBoxModels to allow for swapping combo boxes
        ComboBoxModel<String> model1 = monthlyUsageUnit.getModel();
        ComboBoxModel<String> model2 = bandwidthUnit.getModel();

        // add action listener for swap button
        swap.addActionListener(e -> {

            if (isMonthlyUsage) {
                monthlyUsageLabel.setText("Bandwidth: ");
                bandwidthLabel.setText("Monthly Usage: ");
                monthlyUsageUnit.setModel(model2);
                bandwidthUnit.setModel(model1);
                isMonthlyUsage = false;

            } else {
                monthlyUsageLabel.setText("Monthly Usage: ");
                bandwidthLabel.setText("Bandwidth: ");
                monthlyUsageUnit.setModel(model1);
                bandwidthUnit.setModel(model2);
                isMonthlyUsage = true;
            }
        });

        // add action listener for calculate button
        calculate.addActionListener(e -> {
            try {
                String text = textField.getText().replaceAll("\\s", "");
                if (Double.parseDouble(text) < 0) {
                    result.setForeground(Color.RED);
                    result.setText("Number cannot be negative!");
                } else {
                    result.setForeground(Color.BLACK);
                    textField.setText(text);

                    if (isMonthlyUsage) {
                        Size size = SizeUnit.intChooserOther(monthlyUsageUnit.getSelectedIndex());
                        Rate rate = RateUnit.intChooser(bandwidthUnit.getSelectedIndex());

                        result.setText(Converter.convertHostingBandwidth(new SizeUnit(size, Double.parseDouble(text)),
                                                                         new RateUnit(rate, 0)));
                    } else {
                        Size size = SizeUnit.intChooserOther(bandwidthUnit.getSelectedIndex());
                        Rate rate = RateUnit.intChooser(monthlyUsageUnit.getSelectedIndex());

                        result.setText(Converter.convertHostingBandwidth(new SizeUnit(size, 0),
                                new RateUnit(rate, Double.parseDouble(text))));
                    }

                }
            } catch (NumberFormatException exception) {
                result.setForeground(Color.RED);
                result.setText("Number is invalid or too large!");
            }
        });

        // add panels/labels
        panel.add(hostingBandwidth);
        panel.add(labelTextFieldComboBoxMonthlyUsage);
        panel.add(swapPanel);
        panel.add(labelAndTextFieldBandwidth);
        panel.add(calculateAndClear);
        panel.add(result);

        return panel;
    }
}
