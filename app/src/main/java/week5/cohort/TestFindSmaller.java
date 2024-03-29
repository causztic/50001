package week5.cohort;

/**
 * Created by jit_biswas on 10/8/2017.
 */
import junit.framework.*;
import junit.framework.Test;

public class TestFindSmaller extends TestCase {

    // constructor
    public TestFindSmaller (String name) {
        super(name);
    }

    @org.junit.Test
    public void testFindingSmaller () {
        FindSmaller f = new FindSmaller();
        int[] a = {1,2,7,6,2};
        assertEquals("Failed Assertion for FindSmaller", 3, f.findSmaller(4,a));
        assertEquals("Failed Assertion for FindSmaller", 5, f.findSmaller(8,a));
        assertEquals("Failed Assertion for FindSmaller", 0, f.findSmaller(-1,a));
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestFindSmaller.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}

