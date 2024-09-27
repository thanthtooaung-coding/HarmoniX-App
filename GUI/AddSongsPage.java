package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: The {@code GUI.AddSongsPage} class represents a frame for adding
 * songs to the music player. It provides a file input and an import button to
 * select and import song files into the application.
 *
 * License: MIT License
 */
public class AddSongsPage {

    private final JFrame frame;

    /**
     * Creates an instance of GUI.AddSongsPage.
     */
    public AddSongsPage() {
        frame = new JFrame("Add Songs - HarmoniX");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu bar using GUI.AppMenuBar class
        AppMenuBar menuBar = new AppMenuBar(frame);
        frame.setJMenuBar(menuBar.createMenuBar());

        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // File chooser label
        JLabel fileLabel = new JLabel("Choose song files:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(fileLabel, gbc);

        // File chooser
        JTextField filePathField = new JTextField(20);
        gbc.gridx = 1;
        frame.add(filePathField, gbc);

        JButton browseButton = new JButton("Browse");
        gbc.gridx = 2;
        frame.add(browseButton, gbc);

        // Import button
        JButton importButton = new JButton("Import");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        frame.add(importButton, gbc);

        // Browse button action listener
        browseButton.addActionListener(_ -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            int returnValue = fileChooser.showOpenDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File[] selectedFiles = fileChooser.getSelectedFiles();
                StringBuilder filePaths = new StringBuilder();
                for (File file : selectedFiles) {
                    filePaths.append(file.getAbsolutePath()).append("; ");
                }
                filePathField.setText(filePaths.toString());
            }
        });

        // Import button action listener
        importButton.addActionListener(_ -> {
            String paths = filePathField.getText();
            if (!paths.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Songs imported: " + paths);
                frame.dispose();
                new HomePage().show();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select at least one song file.");
            }
        });
    }

    /**
     * Displays the dialog.
     */
    public void showDialog() {
        frame.setVisible(true);
    }
}