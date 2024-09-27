package GUI;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: The {@code GUI.LoginValidator} class handles the logic for
 * validating user credentials. It contains methods to check whether the entered
 * username and password match the expected values.
 *
 * License: MIT License
 */
public class LoginValidator {

    /**
     * Validates the entered username and password.
     *
     * @param username the entered username
     * @param password the entered password
     * @return true if the credentials are valid, false otherwise
     */
    public static boolean validate(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }
}
