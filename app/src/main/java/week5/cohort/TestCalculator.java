package week5.cohort;

/**
 * Created by jit_biswas on 10/8/2017.
 */
import junit.framework.*;
import junit.framework.Test;

public class TestCalculator extends TestCase {

    // constructor
    public TestCalculator () {}

    @org.junit.Test
    public void testFourOperations () {
        Calculator c = new Calculator();
        assertEquals("Failed Addition", 9, c.add(4,5));
        assertEquals("Failed Subtraction", 2, c.sub(5,3));
        assertEquals("Failed Multiplication", 42, c.mul(6,7));
        assertEquals("Failed Division", 1, c.divInt(6,4));
    }

    @org.junit.Test
    public void testDivideByZero () {
        Calculator c = new Calculator();
        try {
            c.divInt(6, 0);
            fail("Division By Zero has no error thrown.");
        } catch (IllegalArgumentException e) {
            // do nothing since exception has been correctly raised
        }
    }

    public static Test suite() {
        return new TestSuite(TestCalculator.class);
    }

    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}


