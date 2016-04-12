package uk.ac.aber.testdoubles;

/**
 * This class is a class with a method that we want to test both for 
 * the state change, i.e. check the result of the calculation, and
 * the interactions with the logger. We will use JUnit assert statements
 * to test the state and Mockito verify statements to test the 
 * interactions with the log. 
 * 
 * The state tests can be found in TestDataProcessor. The interaction 
 * tests can be found in TestDataProcessorLoggerBehaviour.
 * 
 * @author Neil Taylor (nst@aber.ac.uk) 
 */
public class DataProcessor {

	/** The logger to be used for storing log messages */
	private Logger logger = null; 
	
	/** 
	 * Creates a new instance of the processor and inserts the 
	 * logger that will be used. 
	 * 
	 * @param logger The logger. 
	 */
	public DataProcessor(Logger logger) { 
		this.logger = logger; 
	}
	
	/** 
	 * This method processes the given balance. If it is 100 or more, 
	 * it will be increased by 1000. For example, if the input is 101, 
	 * it will be returned as 1101. If the balance is below 100, it will
	 * be increased by 1. For example, an input of 70 will be returned
	 * as 71.  
	 * 
	 * This method will also send some messages to the logger.
	 *  
	 * @param balance The specified balance. 
	 * 
	 * @return The updated balance. 
	 */
	public int doSomeProcessing(int balance) { 
		
		logger.addMessage(LogLevel.DEBUG, "starting processing with data: " + balance);
		
		// some statements here that do some processing of the data
		if(balance >= 100) { 
		   logger.addMessage(LogLevel.INFO, "value is more than 100, so added 1000");
		
		   balance += 1000;
		}   
		else { 
			logger.addMessage(LogLevel.INFO, "value is less than 100, so added 1");
			balance++; 
		}
		
		logger.addMessage(LogLevel.DEBUG, "finished processing");
	    logger.flushMessages();
	    
	    return balance++;
	}
	
	
}
