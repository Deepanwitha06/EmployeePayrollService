import java.io.File;

// Class to perform different file and directory operations
public class FileOperations {

    // Checks whether a file or directory exists at the given path
    public boolean checkFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    // Deletes the file at the given path
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    // Creates a directory, including any required parent directories
    public boolean createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        return directory.mkdirs();
    }

    // Creates a new empty file at the given path
    public boolean createFile(String filePath) {
        try {
            File file = new File(filePath);
            return file.createNewFile();
        } catch (Exception e) {
            // Returns false if file creation fails
            return false;
        }
    }

    // Returns the names of all files and directories inside a directory
    public String[] listFilesAndDirectories(String directoryPath) {
        File directory = new File(directoryPath);
        return directory.list();
    }

    // Lists only the files that match the given extension
    public String[] listFilesByExtension(String directoryPath, String extension) {
        File directory = new File(directoryPath);
        return directory.list((dir, name) ->
                name.endsWith(extension));
    }
}