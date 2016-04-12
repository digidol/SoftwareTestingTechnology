package uk.ac.aber.sttunit;

/**
 * This class contains a set of test methods that can be used to determine if 
 * the specified data values match some condition. This class only defines 
 * two methods at this time, but more can easily be added.  
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
public class AUAssert {

	public static void assertEquals(int expected, int actual) { 
		if(expected != actual) { 
			throw new AUAssertException(String.format("Values not equal. Expected <%d> but got <%d>", expected, actual));
		}
	}
	
	public static void assertNull(Object actual) { 
		if(actual != null) { 
			throw new AUAssertException(String.format("Expected null value. Actual value: <%s>", actual));
		}
	}
	
}
