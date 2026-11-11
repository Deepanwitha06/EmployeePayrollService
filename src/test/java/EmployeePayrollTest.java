import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeePayrollTest {

    @Test
    public void testEmployeePayrollCreation() {

        EmployeePayroll employee =
                new EmployeePayroll(101, "Deepanwitha", 50000);

        assertEquals(101, employee.getId());
        assertEquals("Deepanwitha", employee.getName());
        assertEquals(50000.0, employee.getSalary());
    }

    @Test
    public void testReadEmployeePayroll() {

        String input = "101\nDeepanwitha\n50000\n";

        Scanner sc = new Scanner(input);

        EmployeePayrollService service =
                new EmployeePayrollService();

        EmployeePayroll employee =
                service.readEmployeePayroll(sc);

        assertEquals(101, employee.getId());
        assertEquals("Deepanwitha", employee.getName());
        assertEquals(50000.0, employee.getSalary());

        sc.close();
    }
}
