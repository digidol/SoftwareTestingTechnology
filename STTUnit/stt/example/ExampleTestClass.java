package stt.example;

import uk.ac.aber.sttunit.AUTest; 
import static uk.ac.aber.sttunit.AUAssert.*; 

/** 
 * This class is a simple example of a set of test cases. 
 * Each test has the annotation, @AUTest, which is specified 
 * as part of the uk.ac.aber.sttunit code. If a method has 
 * this annotation, it will be picked up and executed as part
 * of the tests. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class ExampleTestClass {
	
	/** 
	 * Runs an assert that 1 is equal to 0. This should fail. 
	 */
	@AUTest 
	public void shouldRunSomeTest() { 
		assertEquals(1, 0); 
	}
	
	/**
	 * Runs an assert that 0 is equal to 0. This should pass. 
	 */
	@AUTest 
	public void shouldRunSomeTest2() { 
		assertEquals(0, 0); 
	}
	
	/** 
	 * Runs an assert that the value is null. This should pass. 
	 */
	@AUTest
	public void shouldContainANullValue() { 
		assertNull(null); 
	}
	
	/** 
	 * Runs an assert that a value is null, but the value is not null. 
	 * This should fail. 
	 */
	@AUTest
	public void shouldRevealValueThatIsNotNull() { 
		assertNull("Test value"); 
	}	
}
