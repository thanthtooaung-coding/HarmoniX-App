package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: The {@code GUI.LoginForm} class represents the user interface
 * for the login form. It provides fields for the username and password
 * , and validates credentials using the {@link LoginValidator} class.
 *
 * License: MIT License
 */
public class LoginForm {

    public static void main(String[] args) {
        new LoginForm().createAndShowLoginForm();
    }

    /**
     * Creates and displays the login form with user inputs and a login button.
     */
    public void createAndShowLoginForm() {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add Title Label
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Username Label and Text Field
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        JTextField userText = new JTextField(20);
        userText.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(userText, gbc);

        // Password Label and Password Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(passwordText, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(66, 135, 245));
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton, gbc);

        // Action listener for login button
        loginButton.addActionListener(_ -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill in username field.",
                        "Input Required", JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Please fill in password field.",
                        "Input Required", JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Validate login using GUI.LoginValidator class
            if (LoginValidator.validate(username, password)) {
                JOptionPane.showMessageDialog(frame,
                        "Login successful!"
                );
                frame.dispose();
                new HomePage().show();
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Invalid username or password."
                );
            }
        });

        frame.getRootPane().setDefaultButton(loginButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
