
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class FileOperationsTest {

    FileOperations operations = new FileOperations();

    // Temporary directory used for testing file operations
    File testDirectory = new File("testFiles");

    @BeforeEach
    public void setUp() {
        // Create the test directory before each test
        testDirectory.mkdirs();
    }

    @AfterEach
    public void tearDown() {
        // Delete test files and directory after each test
        File[] files = testDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }

        testDirectory.delete();
    }

    @Test
    public void testCheckFileExists() throws Exception {
        // Create a sample file and verify that it exists
        File file = new File(testDirectory, "sample.txt");
        file.createNewFile();

        assertTrue(operations.checkFileExists(file.getPath()));
    }

    @Test
    public void testDeleteFile() throws Exception {
        // Create a file and verify that it can be deleted
        File file = new File(testDirectory, "delete.txt");
        file.createNewFile();

        assertTrue(operations.deleteFile(file.getPath()));
        assertFalse(file.exists());
    }

    @Test
    public void testCreateDirectory() {
        // Verify that a new directory can be created
        String path = "testFiles/newDirectory";

        assertTrue(operations.createDirectory(path));
        assertTrue(new File(path).exists());

        // Remove the created directory
        new File(path).delete();
    }

    @Test
    public void testCreateFile() throws Exception {
        // Verify that a new empty file can be created
        String path = "testFiles/newFile.txt";

        assertTrue(operations.createFile(path));
        assertTrue(new File(path).exists());
    }

    @Test
    public void testListFilesAndDirectories() throws Exception {
        // Create sample files and verify directory listing
        new File(testDirectory, "one.txt").createNewFile();
        new File(testDirectory, "two.txt").createNewFile();

        String[] files = operations.listFilesAndDirectories(testDirectory.getPath());

        assertNotNull(files);
        assertEquals(2, files.length);
    }

    @Test
    public void testListFilesByExtension() throws Exception {
        // Create files with different extensions
        new File(testDirectory, "one.txt").createNewFile();
        new File(testDirectory, "two.txt").createNewFile();
        new File(testDirectory, "three.pdf").createNewFile();

        String[] files = operations.listFilesByExtension(
                testDirectory.getPath(), ".txt");

        assertNotNull(files);
        assertEquals(2, files.length);
    }
}
