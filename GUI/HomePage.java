package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: The {@code GUI.HomePage} class represents the main page
 * after a successful login. It displays a welcome message and an introduction
 * to the Music Player App. It also contains a menu bar for navigation.
 *
 * License: MIT License
 */
public class HomePage {
    private static JFrame frame;

    /**
     * Displays the home page with a full-screen layout, a welcome message,
     * an introduction, and a menu bar.
     */
    public void show() {
        // A new JFrame for the home page
        if (frame == null) {
            frame = new JFrame("Home Page - HarmoniX");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Menu bar using GUI.AppMenuBar class
            AppMenuBar menuBar = new AppMenuBar(frame);
            frame.setJMenuBar(menuBar.createMenuBar());

            // A panel for the welcome message and introduction
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(Color.WHITE);

            // Welcome label
            JLabel welcomeLabel = new JLabel("Welcome to the Music Player App!", JLabel.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
            welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createVerticalStrut(100));
            panel.add(welcomeLabel);

            // Introduction label
            JLabel introLabel = new JLabel(
                    "<html>This Music Player App allows you to easily import your favorite songs.<br>Use the menu bar above to navigate through the features.</html>",
                    JLabel.CENTER
            );
            introLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            introLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createVerticalStrut(50));
            panel.add(introLabel);

            // Add Songs button
            JButton addSongsButton = new JButton("Add Songs");
            addSongsButton.setFont(new Font("Arial", Font.BOLD, 14));
            addSongsButton.addActionListener(_ -> {
                frame.dispose();
                new AddSongsPage().showDialog();
            });
            addSongsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createVerticalStrut(30));
            panel.add(addSongsButton);

            // Panel to the frame
            frame.add(panel);
        }
        // Show the frame
        frame.setVisible(true);
    }
}