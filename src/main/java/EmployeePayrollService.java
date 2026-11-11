/*
      Class: EmployeePayrollService
      methods:  readEmployeePayroll
                printEmployeePayroll
 */
import java.util.Scanner;

public class EmployeePayrollService {

    public EmployeePayroll readEmployeePayroll(Scanner sc) {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        return new EmployeePayroll(id, name, salary);
    }

    public void printEmployeePayroll(EmployeePayroll employee) {
        System.out.println("\nEmployee Payroll Details");
        employee.displayPayroll();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeePayrollService service = new EmployeePayrollService();

        EmployeePayroll employee = service.readEmployeePayroll(sc);

        service.printEmployeePayroll(employee);

        sc.close();
    }
}
