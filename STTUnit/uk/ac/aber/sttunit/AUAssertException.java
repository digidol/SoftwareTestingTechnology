package uk.ac.aber.sttunit;

/**
 * Represents an exception that is thrown as part of this testing 
 * framework. The AUTestRunner will catch these exceptions and 
 * report the details of any failure. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
@SuppressWarnings("serial")
public class AUAssertException extends RuntimeException {

	/**
	 * Creates a new instance of the exception. 
	 * 
	 * @param message
	 */
	public AUAssertException(String message) { 
		super(message); 
	}
	
	/**
	 * Gets the line number where the exception was thrown, if there 
	 * stack trace information is available. 
	 * 
	 * @return If there is no stack trace information, the value -1 is returned. 
	 */
	public int getLineNumber() { 
		StackTraceElement[] elements = getStackTrace(); 
		if(elements == null || elements.length < 2) { 
			return -1; 
		}
		
		return elements[1].getLineNumber(); 
	}
	
	/**
	 * Returns a string representation of the message and line number. 
	 * 
	 * @returns A message of the format <code>&lt;message&gt; [line: &lt;lineNumber&gt;]</code>. 
	 */
	@Override
	public String toString() { 
		return getMessage() + " [line: " + getLineNumber() + "]";
	}
	
}
