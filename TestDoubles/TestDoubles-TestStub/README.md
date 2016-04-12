# Test Doubles - Test Stubs 
This code is an example implementation of the idea discussed in class for the application to read values from a device connected via USB. 

In the class, we talked about creating a test stub so that the PC application could be developed whilst we waited for the new hardware to be developed. When the hardware became availble, it would be connected via USB to the PC. 

This code has three main parts: 

1. **DataLogger** - This is a class that represents part of the PC code. It creates a network connection, using the Factory, which will then connect to something that will return values. To run the program - run this class. It contains the main method. 
   
2. The **NetworkConnection** is an interface. There are three implementations of the interface:
   
    * **ResponderStubNetworkConnection** - a Test Stub that focuses on returning 'valid' values. 
     
    * **SaboteurStubNetworkConnection** - a Test Stub that will throw some exceptions. Such a test double can be useful to force errors in the system and test if they are handled correctly. 
     
    * **USBNetworkConnection** - this is intended as the place for the real network code. We don't really have a USB device to connect, so there isn't any detailed code in this class. However, it represents the place where you would write the implementation that you would expect to use when you aren't actually testing.
     
3. **NetworkConnectionFactory** - this is used to create an instance of a NetworkConnection. Which type of NetworkConnection is controlled by data in the **TestStubSettings.properties** file. You can change the values in the properties file and then re-run the application to see how it changes which NetworkConnection is used.    

This example does not include any unit tests. Instead, the focus of the example is to consider how Test Stub code might be used. 

You could think about what testing you might like to perform on the code. Is it easy to test the different network connections? Is the DataLogger also easy to test at the moment? What makes it hard to test? 