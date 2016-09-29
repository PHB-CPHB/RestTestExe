/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author philliphbrink
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int i1 = 2;
        int i2 = 3;
        Calculator instance = new Calculator();
        int expResult = 5;
        int result = instance.add(i1, i2);
        assertEquals(expResult, result);
    }

    /**
     * Test of sub method, of class Calculator.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        int i1 = 2;
        int i2 = 3;
        Calculator instance = new Calculator();
        int expResult = -1;
        int result = instance.sub(i1, i2);
        assertEquals(expResult, result);
    }

    /**
     * Test of mul method, of class Calculator.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        int i1 = 2;
        int i2 = 4;
        Calculator instance = new Calculator();
        int expResult = 8;
        int result = instance.mul(i1, i2);
        assertEquals(expResult, result);
    }

    /**
     * Test of div method, of class Calculator.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        int i1 = 10;
        int i2 = 2;
        Calculator instance = new Calculator();
        int expResult = 5;
        int result = instance.div(i1, i2);
        assertEquals(expResult, result);
    }
    
}
