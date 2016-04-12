package stt.neu.testdoubles;

import java.io.IOException;

/** 
 * This class represents a simplified data logger that would read values 
 * from a network connection. This implementation is simplified so that 
 * it reads values and outputs them to the console. In a real application, 
 * we would want to think about how the values are used by the user 
 * interface and also stored to file. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 * @version 1.0
 */
public class DataLogger {

	/** The network connection object used to read data. */ 
	private NetworkConnection connection; 
	
	/** 
	 * Logs values from the connection. 
	 * <p>
	 * For this implementation, the code will read 10 values and 
	 * then exit the method. In a real implementation, the values 
	 * would be passed to user interface 
	 * 
	 * @param connection
	 */
	private void logValues() { 
		
		if(connection == null) { 
			return;
		}
		
	    for(int i = 0; i < 20; i++) { 
	    	try { 
	    	   String data = connection.readData();
	    	   System.out.println("Accessed value: " + data); 
	    	} 
	    	catch(IOException e) { 
	    		System.err.println("Error accessing the data.");
	    		return; 
	    	}
	    }
	}
	
	/** 
	 * Close the connection. 
	 */
	private void close() { 
		if(connection != null) { 
			connection.close();
		} 
	}
	
	/** 
	 * Initialises the class with a link to the network connection. 
	 *  
	 * @return True if the initialisation was successful. Otherwise, false. 
	 */
	public boolean initialise() { 
	
		NetworkConnectionFactory factory = new NetworkConnectionFactory(); 
		connection = factory.getConnection(); 
		if(connection == null) { 
			System.out.println("There was an error getting the connection.");
			System.out.println("The connection mode is: " + factory.getConnectionMode());
			return false; 
		}
		
		try {
			connection.open(factory.getConnectionPort());
			return true; 
		} catch (IOException e) {
			System.err.println("Unable to open connection.");
			connection = null; // reset the connection 
			return false; 
		}
	}
	
	/**
	 * Starts this example program. 
	 * 
	 * @param args The command line arguments. These are not used. 
	 */
	public static void main(String[] args) { 
		DataLogger logger = new DataLogger(); 
		if(logger.initialise()) { 
		   logger.logValues();
		   System.out.println("Closing the connection.");
		   logger.close(); 
		   System.out.println("Exiting.");
		}
	}
	
}
