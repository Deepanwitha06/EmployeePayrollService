
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirectoryWatch {

    // Counts files and subdirectories inside the given directory
    public int countEntries(String directoryPath) {
        File directory = new File(directoryPath);

        // Check whether the directory exists
        if (!directory.exists() || !directory.isDirectory()) {
            return 0;
        }

        // Get all entries inside the directory
        File[] entries = directory.listFiles();

        return entries == null ? 0 : entries.length;
    }

    // Monitors a directory for creation, deletion and modification events
    public void watchDirectory(String directoryPath)
            throws IOException, InterruptedException {

        Path path = Paths.get(directoryPath);

        // Create a WatchService to monitor directory changes
        WatchService watchService =
                FileSystems.getDefault().newWatchService();

        // Register the directory for three types of events
        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
        );

        System.out.println("Watching directory: " + directoryPath);
        System.out.println("Press Ctrl+C to stop watching.");

        // Continuously monitor directory events
        while (true) {
            WatchKey key = watchService.take();

            // Process detected events
            for (WatchEvent<?> event : key.pollEvents()) {

                WatchEvent.Kind<?> kind = event.kind();
                Path fileName = (Path) event.context();

                System.out.println("Event: " + kind.name());
                System.out.println("File: " + fileName);
            }

            // Reset the key to continue monitoring
            if (!key.reset()) {
                System.out.println("Directory is no longer accessible.");
                break;
            }
        }

        watchService.close();
    }

    // Main method to test directory watching
    public static void main(String[] args) throws Exception {

        DirectoryWatch directoryWatch = new DirectoryWatch();

        String directoryPath = "testDirectory";

        // Create the directory if it does not exist
        new File(directoryPath).mkdirs();

        // Display the total number of entries
        System.out.println(
                "Total entries: " +
                        directoryWatch.countEntries(directoryPath)
        );

        // Start monitoring the directory
        directoryWatch.watchDirectory(directoryPath);
    }
}
