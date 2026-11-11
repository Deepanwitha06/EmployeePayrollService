
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Tests payroll file reading and record counting
public class PayrollFileReaderTest {

    @TempDir
    Path tempDirectory;

    PayrollFileReader reader = new PayrollFileReader();

    // Creates a sample payroll file for testing
    private Path createPayrollFile() throws Exception {

        Path file = tempDirectory.resolve("payroll.txt");

        Files.write(file, List.of(
                "Employee ID: 101, Name: Deepanwitha, Salary: 50000",
                "Employee ID: 102, Name: Navya, Salary: 60000",
                "Employee ID: 103, Name: Rahul, Salary: 45000"
        ));

        return file;
    }

    @Test
    public void testReadPayrollFile() throws Exception {

        // Read payroll records from the sample file
        Path file = createPayrollFile();

        List<String> records = reader.readPayrollFile(file.toString());

        // Verify all three records were read
        assertEquals(3, records.size());
        assertTrue(records.get(0).contains("Deepanwitha"));
    }

    @Test
    public void testCountPayrollRecords() throws Exception {

        // Create a sample payroll file
        Path file = createPayrollFile();

        // Verify the number of payroll records
        assertEquals(3, reader.countPayrollRecords(file.toString()));
    }

    @Test
    public void testDisplayPayrollRecords() throws Exception {

        // Create a sample payroll file
        Path file = createPayrollFile();

        // Capture and verify the records used for display
        List<String> records = reader.readPayrollFile(file.toString());

        assertNotNull(records);
        assertEquals(3, records.size());
    }

    @Test
    public void testReadEmptyPayrollFile() throws Exception {

        // Create an empty payroll file
        Path file = tempDirectory.resolve("empty.txt");
        Files.createFile(file);

        // Verify that an empty file returns no records
        assertTrue(reader.readPayrollFile(file.toString()).isEmpty());
        assertEquals(0, reader.countPayrollRecords(file.toString()));
    }
}
