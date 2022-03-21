package com.alikbCalculator.view;

import javax.swing.*;
import java.awt.*;

/**
 * This is the main driver class that provides a GUI with all the different calculators that the user can
 * switch between in order to do their desired operations
 * THIS IS FOR THE GUI
 *
 * @author Alik Balika
 * @version 2020.11.22
 */
public class MainGUI extends JFrame {

    /**
     * runs the whole program and constructs a new MainGUI object
     *
     * @param args args
     */
    public static void main(String[] args) {
        new MainGUI();
    }

    /**
     * Constructs a new GUI and sets all the standard things like title, size, icon, closing operation, visibility,
     * and add a new TabbedPane
     */
    public MainGUI() {

        setTitle("CS Student's Handy Calculator");
        setSize(500, 500);
        setPreferredSize(new Dimension(500, 600));
        ImageIcon calculatorIcon = new ImageIcon("calculatorIcon.png");
        setIconImage(calculatorIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new TabbedPane(), BorderLayout.CENTER);
        pack();

        setVisible(true);
    }

}
