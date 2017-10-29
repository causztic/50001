package week5.cohort;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by yaojie on 12/10/17.
 */

public class TestStock  extends TestCase {

    // constructor
    public TestStock () {}

    @org.junit.Test
    public void testObservables () {
        StockGrabber IBM = new StockGrabber();
        StockObserver scott = new StockObserver(IBM, "scott");
        StockObserver jim = new StockObserver(IBM, "jim");
        IBM.stockUpdate("IBM going up by $0.05");
        assertEquals("IBM going up by $0.05", scott.getLatestChange());
        assertEquals("IBM going up by $0.05", jim.getLatestChange());

        StockObserver jeremy = new StockObserver(IBM, "jeremy");
        IBM.stockUpdate("IBM going down by $0.03");
        assertEquals("IBM going down by $0.03", scott.getLatestChange());
        assertEquals("IBM going down by $0.03", jim.getLatestChange());
        assertEquals("IBM going down by $0.03", jeremy.getLatestChange());
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestStock.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}

