
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Handles writing and printing payroll file contents
public class PayrollFilePrinter {

    // Writes payroll details into a text file
    public void writePayrollFile(String filePath) throws IOException {

        try (FileWriter writer = new FileWriter(filePath)) {

            // Write sample employee payroll records
            writer.write("Employee ID: 101, Name: Deepanwitha, Salary: 50000\n");
            writer.write("Employee ID: 102, Name: Navya, Salary: 60000\n");
            writer.write("Employee ID: 103, Name: Rahul, Salary: 45000\n");
        }
    }

    // Reads and prints each line from the payroll file
    public void printPayrollFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Payroll File Contents");

            // Read and print the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    // Counts the total number of records in the payroll file
    public int countPayrollRecords(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Count each line as one payroll record
            while (reader.readLine() != null) {
                count++;
            }
        }

        return count;
    }

    // Main method to demonstrate payroll file printing
    public static void main(String[] args) throws IOException {

        PayrollFilePrinter printer = new PayrollFilePrinter();
        String filePath = "payroll.txt";

        // Create and populate the payroll file
        printer.writePayrollFile(filePath);
        // Print all payroll records
        printer.printPayrollFile(filePath);

        // Display total payroll records
        System.out.println("Total Payroll Records: " + printer.countPayrollRecords(filePath));
    }
}
