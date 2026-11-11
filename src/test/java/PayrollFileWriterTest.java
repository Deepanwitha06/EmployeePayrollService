
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollFileWriterTest {

    // Temporary directory for storing test payroll files
    @TempDir
    Path tempDirectory;

    PayrollFileWriter writer = new PayrollFileWriter();

    @Test
    public void testWritePayrollToFile() throws Exception {

        // Create an employee payroll object
        EmployeePayroll employee =
                new EmployeePayroll(101, "Deepanwitha", 50000);

        File file = tempDirectory.resolve("payroll.dat").toFile();

        // Write the employee object into the file
        writer.writePayrollToFile(employee, file.getPath());

        // Verify that the file was created successfully
        assertTrue(writer.verifyFile(file.getPath()));
    }

    @Test
    public void testReadPayrollFromFile() throws Exception {

        // Create an employee payroll object
        EmployeePayroll employee = new EmployeePayroll(102, "Deepanwitha", 60000);

        File file = tempDirectory.resolve("payroll.dat").toFile();

        // Store the employee object
        writer.writePayrollToFile(employee, file.getPath());

        // Read the employee object from the file
        EmployeePayroll result = writer.readPayrollFromFile(file.getPath());

        // Verify the retrieved employee details
        assertEquals(102, result.getId());
        assertEquals("Deepanwitha", result.getName());
        assertEquals(60000.0, result.getSalary());
    }

    @Test
    public void testVerifyFile() throws Exception {

        // Create and store a payroll object
        EmployeePayroll employee = new EmployeePayroll(103, "Rahul", 45000);

        File file = tempDirectory.resolve("verify.dat").toFile();

        writer.writePayrollToFile(employee, file.getPath());

        // Verify that the file exists and contains data
        assertTrue(writer.verifyFile(file.getPath()));
    }

    @Test
    public void testCountPayrollRecords() throws Exception {

        // Create an employee payroll object
        EmployeePayroll employee = new EmployeePayroll(104, "Arun", 55000);

        File file = tempDirectory.resolve("count.dat").toFile();

        // Write one payroll record
        writer.writePayrollToFile(employee, file.getPath());

        // Verify the number of stored records
        assertEquals(1, writer.countPayrollRecords(file.getPath()));
    }
}
