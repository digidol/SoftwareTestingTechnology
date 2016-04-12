package stt.neu.testdoubles;

import java.io.IOException;

/** 
 * Represents a test stub, which is able to return a set of valid values. It does not 
 * raise any error conditions. The system will loop through a set of pre-configured 
 * values. When the end of the values is reached, the code will loop back to the 
 * start of the list.  
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 * @version 1.0 
 */
public class ResponderStubNetworkConnection implements NetworkConnection {

	/** 
	 * A set of data values. 
	 */
	private String[] values = new String[] 
			{ "55", "77", "77", "76", "73", "0", "55", "54", "52" };   
	
	/** 
	 * An index for which data value to return. 
	 */
	private int valueIndex = 0; 

	/** 
	 * Opens the connection. There is no implementation for this test stub. 
	 * All connections of this type are automatically open. 
	 */
	@Override
	public void open(String portID) throws IOException {
		// no operation needed for this test stub
	}

	/** 
	 * Closes the connection. There is no implementation for this test stub. 
	 * All connections of this type are automatically closed. 
	 */
	@Override
	public void close() {
		// no operation needed for this test stub
	}

	/** 
	 * Reads data. This should always return a value. The sequence is 
	 * 55, 77, 77, 76, 73, 0, 55, 54, 52. This sequence will loop.
	 *  
	 * @returns One of the specified values. 
	 */
	@Override
	public String readData() throws IOException {
		
		String value = values[valueIndex];
		
		valueIndex++; 
		if(valueIndex == values.length) { 
			valueIndex = 0; // reset back to the start of the sequence
		}
		
		return value; 
	}

}
