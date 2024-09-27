package GUI;

import javax.swing.*;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: The {@code GUI.AppMenuBar} class creates a reusable menu bar for
 * the application. It provides menus for navigation, settings, and help, enabling
 * user-friendly interaction with the Music Player App.
 *
 * License: MIT License
 */
public class AppMenuBar {

    private final JFrame parentFrame;

    public AppMenuBar(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    /**
     * Creates and returns a JMenuBar with different menus.
     *
     * @return the created JMenuBar
     */
    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // "Pages" menu
        JMenu pagesMenu = getPagesMenu();
        menuBar.add(pagesMenu);

        // "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(_ -> System.exit(0));
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // "Settings" menu
        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem preferencesMenuItem = new JMenuItem("Preferences");
        settingsMenu.add(preferencesMenuItem);
        menuBar.add(settingsMenu);

        // "Help" menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(_ -> JOptionPane.showMessageDialog(null, "HarmoniX App Version 1.0"));
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private JMenu getPagesMenu() {
        JMenu pagesMenu = new JMenu("Pages");

        // Home page menu item
        JMenuItem homePageMenuItem = new JMenuItem("Home");
        homePageMenuItem.addActionListener(_ -> {
            parentFrame.dispose();
            new HomePage().show();
        });
        pagesMenu.add(homePageMenuItem);

        // Add Songs page menu item
        JMenuItem addSongsPageMenuItem = new JMenuItem("Add Songs");
        addSongsPageMenuItem.addActionListener(_ -> {
            parentFrame.dispose();
            new AddSongsPage().showDialog();
        });
        pagesMenu.add(addSongsPageMenuItem);
        return pagesMenu;
    }
}