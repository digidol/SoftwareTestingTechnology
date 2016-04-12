package uk.ac.aber.sttunit;

/** 
 * This class represents a single result for a method. It stores the method name 
 * and, optionally, an exception if there was an error. If there is an exception, 
 * then the method result is a failure. If there is no exception, then the method 
 * is recorded as having passed. 
 *  
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
public class AUResult {

	/** 
	 * The name of the method that was executed. This represents the test 
	 * case that has the @AUTest annotation. 
	 */
	private String methodName; 
	
	/** 
	 * Details of the exception, if one is thrown during execution. 
	 */
	private Throwable exception; 
	
	/** 
	 * Creates an instance for the specified method name. The exception is 
	 * set to be null. This method should be used when the test case 
	 * executed successfully. 
	 * 
	 * @param methodName The name of the method that executed successfully. 
	 */
	public AUResult(String methodName) { 
		this(methodName, null); 
	}
	
	/** 
	 * Creates 
	 * @param methodName
	 * @param exception
	 */
	public AUResult(String methodName, Throwable exception) { 
		this.methodName = methodName; 
		this.exception = exception; 
	}
	
	@Override
	public String toString() { 
		return String.format("%s: %s() %s",  
				(exception == null) ? "Pass" : "Fail", 
				methodName,
				(exception == null) ? "" : exception.toString());
	}
}
