
import java.io.*;

// Handles writing and reading payroll objects from a file
public class PayrollFileWriter {

    // Writes an EmployeePayroll object into a file
    public void writePayrollToFile(EmployeePayroll employee, String filePath) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath))) {

            // Serialize and store the employee object
            output.writeObject(employee);
        }
    }

    // Reads an EmployeePayroll object from a file
    public EmployeePayroll readPayrollFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {

            // Deserialize and return the employee object
            return (EmployeePayroll) input.readObject();
        }
    }

    // Checks whether the payroll file contains stored data
    public boolean verifyFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.length() > 0;
    }

    // Counts the stored payroll records in the file
    public int countPayrollRecords(String filePath) throws IOException, ClassNotFoundException {
        int count = 0;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {

            // Read serialized objects until the end of the file
            while (true) {
                input.readObject();
                count++;
            }

        } catch (EOFException e) {
            // End of file means all records have been counted
        }

        return count;
    }

    // Main method to demonstrate payroll file operations
    public static void main(String[] args) throws Exception {

        PayrollFileWriter writer = new PayrollFileWriter();
        EmployeePayroll employee = new EmployeePayroll(101, "Deepanwitha", 50000);
        String filePath = "payroll.dat";

        // Write the employee object into the file
        writer.writePayrollToFile(employee, filePath);

        // Verify that the file contains data
        System.out.println("File created: " + writer.verifyFile(filePath));

        // Read the employee object from the file
        EmployeePayroll result = writer.readPayrollFromFile(filePath);

        System.out.println("Employee ID: " + result.getId());
        System.out.println("Employee Name: " + result.getName());
        System.out.println("Employee Salary: " + result.getSalary());

        // Display the number of stored payroll records
        System.out.println("Total payroll records: " + writer.countPayrollRecords(filePath)
        );
    }
}
