/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import packageToTest.IntegerManipulator;
import static org.junit.Assert.*;

/**
 *
 * @author w0091766
 */
public class IntegerManipulatorTest {

    IntegerManipulator m1;
    IntegerManipulator m2;

    public IntegerManipulatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("\nClass Setup");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("\nClass teardown");
    }

    @Before
    public void setUp() {
        System.out.println("\nsetUp");
        m1 = new IntegerManipulator(100);
        m2 = new IntegerManipulator(Integer.MAX_VALUE);
    }

    @After
    public void tearDown() {
        System.out.println("\nteardown");
    }

    /**
     * Test of ReturnSquaredInt method, of class IntegerManipulator.
     */
    @Test
    public void testReturnSquaredInt_01() {
        System.out.println("ReturnSquaredInt");
        IntegerManipulator instance = m1;
        int expResult = 10000; // 100*100 = 10000
        int result = instance.ReturnSquaredInt();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    /**
     * Test of ReturnSquaredInt method, of class IntegerManipulator.
     */
    @Test
    public void testReturnSquaredInt_02() {
        System.out.println("ReturnSquaredInt");
        IntegerManipulator instance = new IntegerManipulator(4);
        int expResult = 16; // 4*4 = 16
        int result = instance.ReturnSquaredInt();
        assertEquals(expResult, result);
    }

    /**
     * Test of ReturnIntPlusOne method, of class IntegerManipulator. This test shows 
     * exception is raised.
     */
    @Test
    public void testReturnIntPlusOne() {
        System.out.println("ReturnIntPlusOne");
        IntegerManipulator instance = m1;  //already max
        int  result = instance.ReturnIntPlusOne();
        int expResult = 101;
        
        assertEquals(expResult, result);
    }

    
    
    /**
     * Test of ReturnIntPlusOne method, of class IntegerManipulator. This test shows 
     * exception is raised.
     */
    @Test
    public void testReturnIntPlusOne_2() {
        System.out.println("ReturnIntPlusOne");
        IntegerManipulator instance = m2;  //already max
        int expResult = Integer.MAX_VALUE;
        
        int result = 0;
        try {
            result = instance.ReturnIntPlusOne();
        } catch (Exception e) { //catches error when i = 0
            System.out.print(" error=" + e);
            result = Integer.MAX_VALUE;
        } finally {
            System.out.println("Finally");
        }
        assertEquals(expResult, result);
    }

    
    /**
     * Test of ReturnLengthInt method, of class IntegerManipulator.
     */
    @Test
    public void testReturnLengthInt() {
        System.out.println("ReturnLengthInt");
        IntegerManipulator instance = m1;
        String expResult = "3";
        String result = instance.ReturnLengthInt();
        assertEquals(expResult, result);
    }
}
