package com.alikbCalculator.view;

import javax.swing.*;
import java.awt.*;

/**
 * This class constructs a TabbedPane and add all the necessary panel to it
 *
 * @author Alik Balika
 * @version 2020.11.22
 */
public class TabbedPane extends JPanel {

    /**
     * Constructs a new TabbedPane and adds it to the panel. It uses a GridLayout.
     */
    public TabbedPane() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Binary Calculator", null, new BinaryPanel(), "Calculates binary operations");
        tabbedPane.addTab("Hex Calculator", null, new HexPanel(), "Calculates hex operations");
        tabbedPane.addTab("Bandwidth Calculator", null, new JScrollPane(new BandwidthPanel()), "Calculates bandwidth operations");
        tabbedPane.addTab("Enter A File", null, new FilePanel(), "Computes operations on a given file");

        add(tabbedPane);

        // allows scrollable tabs
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

}
