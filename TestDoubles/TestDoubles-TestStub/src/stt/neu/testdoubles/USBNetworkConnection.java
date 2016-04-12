package stt.neu.testdoubles;

import java.io.IOException;

/** 
 * This class would be used to hold the actual methods to connect to the 
 * device via USB. For this example, there is no real implementation 
 * because there is no USB device for us to connect to. However, in a 
 * real project, we would write the correct implementation that would 
 * link to the USB device and read the values as they are received. 
 * <p>
 * For the purposes of this demo, this will return "1" each time
 * the readData() method is called. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk) 
 * @version 1.0
 *
 */
public class USBNetworkConnection implements NetworkConnection {

	/** 
	 * Opens a connection. This would need some real code. For this 
	 * demo code, all connections are assumed to be open.  
	 */
	@Override
	public void open(String portID) throws IOException {
		// no operation for this class 
	}

	/** 
	 * Closes a connection. This would need some real code. 
	 * For this demo code, all connections are closed without error. 
	 */
	@Override
	public void close() {
		// no operation for this class 
	}
	
	/** 
	 * Reads a data value. For this demo code the value is always 1. 
	 * A real implementation would connect to the remote device over
	 * USB and read actual values. 
	 */
	@Override
	public String readData() throws IOException {
		return "1";
	}

}
