package GUI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.1
 *
 * Description: The {@code FileCopyHandler} class is a utility class responsible for
 * handling file copying operations in the application. It provides a static method
 * for copying multiple files from their source locations to a target directory. The
 * target directory is defined as a class-level field and initialized to "D:/Songs".
 *
 * Methods:
 * - {@link #copyFilesToDirectory(String[])}: Copies the specified files to the target directory.
 *
 * Usage Example:
 * <pre>
 *     String[] files = { "C:/Music/song1.mp3", "C:/Music/song2.mp3" };
 *     boolean success = FileCopyHandler.copyFilesToDirectory(files);
 *     if (success) {
 *         System.out.println("Files copied successfully.");
 *     } else {
 *         System.err.println("Some files failed to copy.");
 *     }
 * </pre>
 *
 * License: MIT License
 */
public class FileCopyHandler {

    // Class-level target directory field
    private static final File targetDir = new File("D:/Songs");

    /**
     * Copies multiple files to the specified target directory.
     *
     * @param filePaths Array of file paths to be copied.
     * @return {@code true} if all files were copied successfully, {@code false} if one or more files failed to copy.
     */
    public static boolean copyFilesToDirectory(String[] filePaths) {
        boolean allFilesCopied = true;

        for (String path : filePaths) {
            try {
                File sourceFile = new File(path);
                Path destinationPath = Paths.get(targetDir.getAbsolutePath(), sourceFile.getName());
                Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println("Failed to copy file: " + path);
                allFilesCopied = false;
            }
        }

        return allFilesCopied;
    }
}
