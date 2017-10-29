package week5.cohort;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestSingleton extends TestCase {
    private Singleton s1 = null;
    private Singleton s2 = null;

    public TestSingleton(String name) {
        super(name);
    }
    public void testSuccessiveGetInstance() {
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        assertEquals(true, s1 == s2);
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestSingleton.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}