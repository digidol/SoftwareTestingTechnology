package uk.ac.aber.testdoubles;

/** 
 * An interface that specifies a logger that can store 
 * messages. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public interface Logger {

	/** 
	 * This method defines the minimum level for 
	 * log messages. Messages will only be stored in the 
	 * log if the level specified in addMessage() is 
	 * equal to or higher than this level. 
	 * 
	 * A class that implements this interface should 
	 * define a default LogLevel. This method can then 
	 * be used to change that LogLevel. 
	 * 
	 * @param level The specified log level. 
	 */
	public void setLogLevel(LogLevel level); 
	
	/**
	 * This method adds the specified message to the log. 
	 * A level is provided. The message will only be logged
	 * if the current LogLevel is set to the specified level 
	 * or higher. 
	 * 
	 * @param level The specified log level. 
	 * @param message The message to be stored. 
	 */
	public void addMessage(LogLevel level, String message);
	
	/**
	 * Flush messages from memory to make sure that they 
	 * appear in the log. 
	 */
	public void flushMessages(); 
}
