
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryWatchTest {

    DirectoryWatch directoryWatch = new DirectoryWatch();

    // Temporary directory used for testing
    File testDirectory = new File("watchTestDirectory");

    @BeforeEach
    public void setUp() {
        // Create the directory before each test
        testDirectory.mkdirs();
    }

    @AfterEach
    public void tearDown() {
        // Delete all test files and subdirectories
        File[] files = testDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }

        testDirectory.delete();
    }

    @Test
    public void testCountEntriesInEmptyDirectory() {
        // An empty directory should contain zero entries
        assertEquals(0,
                directoryWatch.countEntries(testDirectory.getPath()));
    }

    @Test
    public void testCountFiles() throws Exception {
        // Create two files inside the directory
        new File(testDirectory, "one.txt").createNewFile();
        new File(testDirectory, "two.txt").createNewFile();

        // Verify that both files are counted
        assertEquals(2,
                directoryWatch.countEntries(testDirectory.getPath()));
    }

    @Test
    public void testCountFilesAndSubdirectories() throws Exception {
        // Create one file and one subdirectory
        new File(testDirectory, "sample.txt").createNewFile();
        new File(testDirectory, "subfolder").mkdir();

        // Verify that both entries are counted
        assertEquals(2,
                directoryWatch.countEntries(testDirectory.getPath()));
    }

    @Test
    public void testInvalidDirectoryPath() {
        // An invalid directory should return zero
        assertEquals(0,
                directoryWatch.countEntries("invalidTestDirectory"));
    }

    @Test
    public void testDirectoryExists() {
        // Verify that the test directory was created
        assertTrue(testDirectory.exists());
        assertTrue(testDirectory.isDirectory());
    }
}
