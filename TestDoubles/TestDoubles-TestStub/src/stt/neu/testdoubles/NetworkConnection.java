package stt.neu.testdoubles;

import java.io.IOException;

/**
 * Represents a network interface for connecting to a remote 
 * device to read data values. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 * @Version 1.0
 */
public interface NetworkConnection {

	/**
	 * Opens the connection for the given portID. The 
	 * portID is one of the ports on the machine, e.g. COM1 or COM2. 
	 *  
	 * @param portID The port id for the relevant network connection. 
	 *  
	 * @throws IOException If there is a problem opening the connection. 
	 */
	public void open(String portID) throws IOException; 
	
	/** 
	 * Closes the connection. 
	 */
	public void close(); 
		
	/** 
	 * Reads data from the network connection. For the purposes 
	 * of this example, a String is returned. For a real example 
	 * we might return a byte array with the raw data values.  
	 * 
	 * @return A string representing data read from the connection.
	 * 
	 * @throws IOException If there is a problem reading data. 
	 */
	public String readData() throws IOException; 
	
}
