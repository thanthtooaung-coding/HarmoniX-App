package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: The {@code GUI.AddSongsPage} class represents a frame for adding
 * songs to the music player. It provides a file input, song name input, and an
 * import button to select and import song files into the application.
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
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // File chooser label
        JLabel fileLabel = new JLabel("Choose song files:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(fileLabel, gbc);

        // File chooser text field
        JTextField filePathField = new JTextField(20);
        gbc.gridx = 1;
        frame.add(filePathField, gbc);

        // Browse button
        JButton browseButton = new JButton("Browse");
        gbc.gridx = 2;
        frame.add(browseButton, gbc);

        // Song name label
        JLabel songNameLabel = new JLabel("Song Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(songNameLabel, gbc);

        // Song name text field
        JTextField songNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(songNameField, gbc);

        // Import button
        JButton importButton = new JButton("Import");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(importButton, gbc);

        // Browse button action listener
        browseButton.addActionListener(_ -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setFileFilter(new FileNameExtensionFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setDialogTitle("Choose song file");
            fileChooser.setAcceptAllFileFilterUsed(false);
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
            String filePaths = filePathField.getText();
            String songName = songNameField.getText();
            if (!filePaths.isEmpty() && !songName.isEmpty()) {
                try {
                    boolean isAvailable = InternetAvailabilityChecker.isInternetAvailable();
                    if (isAvailable) {
                        String[] paths = filePaths.split("; ");
                        boolean success = FileCopyHandler.copyFilesToDirectory(paths);

                        if (success) {
                            JOptionPane.showMessageDialog(frame, "Song '" + songName + "' imported: " + filePaths);
                            frame.dispose();
                            new HomePage().show();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Some files failed to copy.",
                                    "Copy Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(frame, "No internet connection. Please check your connection and try again.",
                                "Connection Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "Unable to check internet connection. Please try again later.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a file and enter a song name.");
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
