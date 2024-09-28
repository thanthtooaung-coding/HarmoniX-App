package GUI;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: The {@code GUI.InternetAvailabilityChecker} class provides utility methods
 * to check if the system is connected to the internet by attempting to connect to multiple
 * well-known servers. It attempts to establish a socket connection to several hosts like
 * Google, Amazon, Facebook, and Apple.
 *
 * This utility can be useful in applications that need to ensure an active internet connection
 * is available before proceeding with network-dependent tasks.
 *
 * License: MIT License
 */
public class InternetAvailabilityChecker {

    /**
     * Checks if the system has an active internet connection by attempting to connect
     * to well-known hosts. The method tries to establish socket connections to Google,
     * Amazon, Facebook, and Apple.
     *
     * @return true if at least one host is reachable, false otherwise
     * @throws IOException if there is an error when trying to check the connection
     */
    public static boolean isInternetAvailable() throws IOException {
        return isHostAvailable("google.com") || isHostAvailable("amazon.com")
                || isHostAvailable("facebook.com") || isHostAvailable("apple.com");
    }

    /**
     * Attempts to establish a socket connection to the specified host on port 80
     * with a timeout of 3 seconds.
     *
     * @param hostName the name of the host to connect to
     * @return true if the host is reachable, false otherwise
     * @throws IOException if there is an error when trying to establish the connection
     */
    private static boolean isHostAvailable(String hostName) throws IOException {
        try (Socket socket = new Socket()) {
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);
            return true;
        } catch (UnknownHostException unknownHost) {
            return false;
        }
    }
}
