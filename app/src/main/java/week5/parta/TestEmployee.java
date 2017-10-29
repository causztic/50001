package week5.parta;

import junit.framework.*;
import junit.framework.Test;

public class TestEmployee extends TestCase {
    // constructor
    public TestEmployee() {
    }

    // method to test the constructor of the Employee class
    @org.junit.Test
    public void testConstructor() {
        String employee_name = "John Doe";
        String employee_no = "1234567";

        // create a new employee
        Employee emp  = new Employee(employee_name, employee_no);

        // verify that the employee object is constructed properly
        // Enter your code here
        assertEquals("fail to construct object's employee name properly", emp.getEmpName(), employee_name);
        assertEquals("fail to construct object's employee number properly", emp.getEmpNumber(), employee_no);

        // test invalid inputs - null emp no and null emp name
        // Enter your code here
        try {
            new Employee(null, employee_no);
            new Employee(employee_name, null);
            new Employee(null, null);
            fail("Employee created with null parameters.");
        } catch (RuntimeException e){
            //
        }
    }

    // method to test the assigning and retrieval of salary components
    @org.junit.Test
    public void testAssignAndRetrieveSalaryComponents() {
        // create an employee
        Employee emp  = new Employee("James Watson", "2345678");

        // assign a few salary components to this employee
        emp.assignSalary("Basic", 2000);
        emp.assignSalary("Overtime", 500);
        emp.assignSalary("Medical", 350);

        // verify that the assignment is correct
        assertTrue("fail to assign Basic component", emp.getSalary("Basic") == 2000);
        assertTrue("fail to assign Medical component", emp.getSalary("Medical") == 350);

        // attempt to retrieve a salary component that does not exist
        try {
            emp.getSalary("Transportation");
            fail("fail to catch non-existent salary component ");
        } catch (RuntimeException e) { }
    }


    // method to test if the total pay is correct
    @org.junit.Test
    public void testCalculationOfTotalPay() {
        // create an employee
        Employee emp  = new Employee("John Doe", "1234567");

        // assign a few salary components to this employee
        emp.assignSalary("Basic", 2000);
        emp.assignSalary("Overtime", 500);
        emp.assignSalary("Medical", 350);

        // verify that the total pay calculation is correct
        assertTrue("fail to calculate total pay ", emp.getTotalPay() == 2850);

        // attempt to retrieve calculate total pay for an employee that has no salary components
        try {
            Employee emp2 = new Employee("Tommy Anderson", "3456789");

            emp2.getTotalPay();
            fail("fail to catch non-existent salary component ");
        } catch (RuntimeException e) { }
    }


    // method create a test suite
    public static Test suite() { return new TestSuite(TestEmployee.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
