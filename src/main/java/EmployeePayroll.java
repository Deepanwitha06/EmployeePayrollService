/*
     EmployeePayRoll class with
         Atrributes: id,name,salary
         getters and displayPayRoll methods
 */
public class EmployeePayroll {

    private int id;
    private String name;
    private double salary;

    public EmployeePayroll(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void displayPayroll() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }
}
