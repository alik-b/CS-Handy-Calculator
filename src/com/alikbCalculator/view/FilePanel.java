package com.alikbCalculator.view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * This class constructs a new JPanel that requests to user to select a file and save to a new file the calculated
 * file
 *
 * @author Alik Balika
 * @version 2020.11.22
 */
public class FilePanel extends JPanel {
    File file;

    /**
     * adds open/save buttons that open/save to a new JFileChooser
     */
    public FilePanel() {
        setLayout(new GridLayout(3, 1));
        JLabel plsChooseFile = new JLabel("Please choose the file you would like to calculate: ");
        JButton open = new JButton("Open");
        JPanel labelAndButtonOpen = new JPanel();
        labelAndButtonOpen.add(plsChooseFile);
        labelAndButtonOpen.add(open);

        JLabel saveToNewFile = new JLabel("Save to a new File: ");
        JButton save = new JButton("Save");
        JPanel labelAndButtonSave = new JPanel();
        labelAndButtonSave.add(saveToNewFile);
        labelAndButtonSave.add(save);

        JLabel message = new JLabel();
        message.setHorizontalAlignment(JLabel.CENTER);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        open.addActionListener(e -> {
            fileChooser.setApproveButtonText("Select");
            int returnval = fileChooser.showOpenDialog(FilePanel.this);

            if (returnval == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                message.setText("Selected file " + file.getAbsolutePath());
            }
        });

        save.addActionListener(e -> {
            int returnVal = fileChooser.showSaveDialog(FilePanel.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File fileToSave = fileChooser.getSelectedFile();
                    CalculateFile.calculate(file.getAbsolutePath(), fileToSave.getAbsolutePath());
                    message.setText("Saved to " + fileToSave.getAbsolutePath());
                } catch (Exception exception) {
                    message.setText("You have not selected a file!");
                }
            }
        });

        add(labelAndButtonOpen);
        add(labelAndButtonSave);
        add(message);
    }

}
