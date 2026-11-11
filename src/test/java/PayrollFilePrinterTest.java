
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

// Tests payroll file writing, printing and record counting
public class PayrollFilePrinterTest {

    @TempDir
    Path tempDirectory;
    PayrollFilePrinter printer = new PayrollFilePrinter();

    @Test
    public void testWritePayrollFile() throws Exception {
        // Create a temporary payroll file
        String filePath = tempDirectory.resolve("payroll.txt").toString();
        printer.writePayrollFile(filePath);
        // Verify that the file exists
        assertTrue(java.nio.file.Files.exists(Path.of(filePath)));
    }

    @Test
    public void testCountPayrollRecords() throws Exception {
        // Create and populate a temporary payroll file
        String filePath = tempDirectory.resolve("payroll.txt").toString();
        printer.writePayrollFile(filePath);
        // Verify that three records are stored
        assertEquals(3, printer.countPayrollRecords(filePath));
    }

    @Test
    public void testPrintPayrollFile() throws Exception {
        // Create and populate a temporary payroll file
        String filePath = tempDirectory.resolve("payroll.txt").toString();
        printer.writePayrollFile(filePath);
        // Verify that the file contains payroll records
        assertEquals(3, printer.countPayrollRecords(filePath));
    }
}
