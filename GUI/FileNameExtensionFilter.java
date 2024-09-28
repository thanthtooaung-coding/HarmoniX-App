package GUI;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Author: Thant Htoo Aung
 * Date: 09/28/2024
 * Version: 1.0
 *
 * Description: This class filters files to allow only specific file formats
 *
 * License: MIT License
 */
public class FileNameExtensionFilter extends FileFilter {

    private static final String[] ACCEPTED_SONGS_EXTENSIONS = {"mp3", "wav", "aac", "flac", "ogg", "m4a"};

    /**
     * Whether the given file is accepted by this filter.
     *
     * @param file the File to test
     * @return true if the file is to be accepted
     */
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        for (String extension : ACCEPTED_SONGS_EXTENSIONS) {
            if (file.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The description of this filter. For example: "JPG and GIF Images"
     *
     * @return the description of this filter
     */
    @Override
    public String getDescription() {
        return "Supported Audio Files (*.mp3, *.wav, *.aac, *.flac, *.ogg, *.m4a)";
    }
}
