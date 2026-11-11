import java.io.Serializable;

// Represents employee payroll details and supports object serialization
public class EmployeePayroll implements Serializable {

    // Unique version identifier for serialization
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double salary;

    // Initializes employee payroll details
    public EmployeePayroll(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Returns employee ID
    public int getId() {
        return id;
    }

    // Returns employee name
    public String getName() {
        return name;
    }

    // Returns employee salary
    public double getSalary() {
        return salary;
    }
}
