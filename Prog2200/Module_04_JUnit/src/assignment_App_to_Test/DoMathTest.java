package assignment_App_to_Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoMathTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	/**
	 * Test using lambda and assertThrows to check for exceptions.
	 */
	@Test
	void testMultiply_01() {

		System.out.println("test testMultiply_01");
		DoMath m = new DoMath();
		m.setVar_1(0);
		m.setVar_2(0);

		// expect ArithmeticException, thrown with text as "Bong"
		Throwable exception = assertThrows(java.lang.ArithmeticException.class, () -> m.Multiply());
		assertEquals("Bong", exception.getMessage());

		/**
		 * Note the use of the Lambda operator "->", and the definition of the
		 * "assertThrows" method.
		 * 
		 * assertThrows takes 2 arguments: parameter 1 - The expected exception: I've
		 * coded up an exception to be raised when zeros are to be multiplied. Hence, I
		 * expect this exception, with the text. The exception is assigned to my
		 * variable "exception", and the text of the exception is checked in the next
		 * line using "assertEquals".
		 * 
		 * parameter 2 - an "executable", defined using a Lambda expression: The lambda
		 * expression is used to launch a thread that runs the multiply method. The
		 * returned value of the multiply method is ignored (never captured), as we are
		 * only interested in if the thread raised an exception....which is caught by
		 * assertThrows and assigned to the variable "exception".
		 * 
		 */

	}


	/**
	 * Test using "old school" check for exceptions.
	 */
	@Test
	void testMultiply_02() {

		System.out.println("test testMultiply_01");
		DoMath m = new DoMath();
		m.setVar_1(0);
		m.setVar_2(0);

		// flag to check exception was raised.
		boolean testAssert = false;
		
		try {
			m.Multiply();  // don't care what vaule is returned
		} catch (java.lang.ArithmeticException e) {
			// this was expected...
			testAssert = true;
			assertEquals("Bong", e.getMessage());  // change to Bang fails
		}

		// we expect to have handled the exception
		assertEquals(true, testAssert);

		/**
		 *  "old school" check for exceptions is to catch the exception, and 
		 *  set flags.
		 *  
		 *  The more code you use in your test, the more likely there's an 
		 *  error in your test...so lambdas are a slight improvement.
		 */

	}

	/**
	 * Test 2 positive integers.
	 */
	@Test
	void testMultiply_03() {

		System.out.println("test testMultiply_01");
		DoMath m = new DoMath();
		m.setVar_1(5);
		m.setVar_2(6);

		// expect ArithmeticException, thrown with "Bong"
		// () -> m.Multiply();

		int expResult = 30; //
		int result = m.Multiply();
		assertEquals(expResult, result);
	}

	/**
	 * Test 2 positive integers.
	 */
	@Test
	void testAdd_01() {
		System.out.println("test testAdd_01");
		DoMath m = new DoMath();
		m.setVar_1(5);
		m.setVar_2(6);

		int expResult = 11; //
		int result = m.Add();
		assertEquals(expResult, result);
	}

	/**
	 * Test 1 positive, 1 negative integer.
	 */
	@Test
	void testAdd_02() {
		System.out.println("test testAdd_02");
		DoMath m = new DoMath();
		m.setVar_1(1);
		m.setVar_2(-2);

		int expResult = -1; //
		int result = m.Add();
		assertEquals(expResult, result);
	}

}
