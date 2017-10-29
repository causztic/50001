package week5.partc;

import junit.framework.*;
import junit.framework.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Created by yaojie on 29/10/17.
 */


public class TestMultiUnitCalculator extends TestCase{

    private MultiUnitCalculator calc = new MultiUnitCalculator();

    @org.junit.Test
    public void testBasicOperations(){
        assertEquals("Failed assertion for addition", "5.0", calc.evaluate("(1+4)"));
        assertEquals("Failed assertion for decimal addition", "6.2", calc.evaluate("(6+0.2)"));
        assertEquals("Failed assertion for negative numbers", "-3.0", calc.evaluate("(-4+1)"));
        assertEquals("Failed assertion for subtraction", "16.0", calc.evaluate("(25-9)"));
        assertEquals("Failed assertion for division", "4.0", calc.evaluate("(20 / 5)"));
        assertEquals("Failed assertion for multiplication", "42.0", calc.evaluate("(6*7)"));
    }

    private String[] invalidCases = { "(6*)", "(6++6)", "(6+7", "6+7)", "6(3)", "(3)6", "(+6)", "()" };

    // loop through the invalid cases and test them. All should raise a ParserException.
    @org.junit.Test(expected = Parser.ParserException.class)
    public void testInvalid(){
        testInvalid(0);
    }
    public void testInvalid(int index){
        try {
            calc.evaluate(invalidCases[index]);
            fail(String.format("Should raise error at %s", invalidCases[index]));
        } catch(Parser.ParserException pe){
            if (index+1 < invalidCases.length)
                testInvalid(index+1);
        }

    }


    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestMultiUnitCalculator.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
