
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Handles reading and analyzing employee payroll records from a file
public class PayrollFileReader {

    // Reads all payroll records from the given file
    public List<String> readPayrollFile(String filePath) throws IOException {

        List<String> records = new ArrayList<>();

        // Open the file and read its contents line by line
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        }

        return records;
    }

    // Counts the total number of payroll records
    public int countPayrollRecords(String filePath) throws IOException {

        int count = 0;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {

            // Increment count for every line in the file
            while (reader.readLine() != null) {
                count++;
            }
        }

        return count;
    }

    // Displays all payroll records
    public void displayPayrollRecords(String filePath) throws IOException {

        List<String> records = readPayrollFile(filePath);

        System.out.println("----- Employee Payroll Records -----");

        // Print each payroll record
        for (String record : records) {
            System.out.println(record);
        }

        System.out.println("Total Records: " + records.size());
    }

    // Main method to demonstrate payroll file reading
    public static void main(String[] args) throws IOException {

        PayrollFileReader reader = new PayrollFileReader();

        String filePath = "payroll.txt";

        // Read and display the payroll file
        reader.displayPayrollRecords(filePath);
    }
}
