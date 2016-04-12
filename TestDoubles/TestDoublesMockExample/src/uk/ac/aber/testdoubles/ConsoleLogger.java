package uk.ac.aber.testdoubles;

import java.util.ArrayList;

/**
 * Example implementation of a Logger for the purposes of this example. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class ConsoleLogger implements Logger {

	/** 
	 * A local copy of recent messages. 
	 */
	private ArrayList<String> logMessages = new ArrayList<>(); 
	
	/** 
	 * The minimum level for this logger. Only messages that 
	 * have a log level equal to or higher than this level 
	 * will be output. 
	 */
	private LogLevel minimumLevel = LogLevel.ERROR; 
	
	/**
	 * Set the minimum log level. 
	 */
	public void setLogLevel(LogLevel level) { 
		this.minimumLevel = level; 
	}
	
	
	/** 
	 * Add the message to the log. 
	 * 
	 * @param level The log level for the message. 
	 * @param message The message to be stored. 
	 */
	public void addMessage(LogLevel level, String message) { 
		
		if(minimumLevel.compareTo(level) <= 0) { 
		   logMessages.add(createLogMessage(level, message)); 
		   System.out.println(createLogMessage(level, message));
		}   
	}
	
	/**
	 * Returns the number of log messages that are stored in  
	 * this logger. 
	 */
	public int count() { 
	   return logMessages.size(); 
	}
	
	/**
	 * Creates a message string that combines the level information 
	 * and the message. 
	 * 
	 * @param level The level used. 
	 * @param message
	 * @return
	 */
	private String createLogMessage(LogLevel level, String message) { 
		return level + " : " + message;   
	}
	
	/**
	 * This method is included here because it is required by the 
	 * Logger interface. However, for logging to System.out, we don't
	 * don't normally need to flush the messages. 
	 * 
	 * If this was a different type of logger, which logged information to 
	 * a file stream, then it could flush the file stream to make sure 
	 * the most recent information in memory is stored on disk. 
	 */
	public void flushMessages() { 
		System.out.flush(); 
	}
	
}
