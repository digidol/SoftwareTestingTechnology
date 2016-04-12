package stt.neu.testdoubles;

import java.io.IOException;

/** 
 * This class represents one that is designed to test situations where errors are 
 * thrown from the network connection. In particular, it simulates the following errors: 
 * 
 *  <ul>
 *     <li>
 *     If the connection is opened for COM1, an exception will be thrown. 
 *     In this situation, later attempts to read from the readData() method will 
 *     also throw an exception.
 *     </li>
 *     <li>
 *     When reading data, there will be an IOException after the 10th data read. 
 *     This is for the purpose of this example. A real project would need to 
 *     decide what invalid values it wanted to test. 
 *     </li>
 *  </ul>
 *  
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
public class SaboteurStubNetworkConnection implements NetworkConnection {

	/** 
	 * Used to determine if the class is initialised or not. 
	 */
	private boolean initialised = false; 
	
	/** The set of data values */ 
	private String[] dataValues = new String[] 
			{ "30", "31", "33", "30", "35", "40", "41", "39", "39", "38" };
	
	/** Index for the values array */ 
	private int index = 0; 
	
	/** 
	 * Open the port with the given ID. This is intended to represent some of 
	 * the common ports on Windows, which usually involve COM1 and COM2. This 
	 * method is designed to throw an exception if the value COM1 is passed in.  
	 * 
	 * @param portID The Port ID. 
	 * 
	 * @throws IOException if an attempt is made to open COM1. 
	 */
	@Override
	public void open(String portID) throws IOException {
		if("COM1".equals(portID)) {
			initialised = false; 
			throw new IOException("COM1 Not Available");
		}
		
		initialised = true; 
	}

	/** 
	 * Closes the connection. There is no implementation for this test stub. 
	 */
	@Override
	public void close() {
		// no implementatin for this test stub 
	}

	/** 
	 * Reads data. A sequence of data is returned, but the 10th read will throw 
	 * an IOException. 
	 * 
	 * @return A string value. On the 10th read for this test stub, there will be an error. 
	 * @throws IOException 
	 */
	@Override
	public String readData() throws IOException {
		if(!initialised) { 
			throw new IOException("Network Connection is not initialised."); 
		}
	
		if(index < dataValues.length) { 
			String value = dataValues[index];
			index++; 
			return value; 
		}
		
		throw new IOException("Error reading data values"); 
	}

}
