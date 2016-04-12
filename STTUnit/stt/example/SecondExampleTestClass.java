package stt.example;

import uk.ac.aber.sttunit.AUTest;
import static uk.ac.aber.sttunit.AUAssert.*; 

public class SecondExampleTestClass {

	@AUTest 
	public void shouldHaveCorrectValue() { 
		assertEquals(10, 10); 
	}
	
}
