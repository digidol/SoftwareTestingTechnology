package uk.ac.aber.testdoubles.tests;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

import uk.ac.aber.testdoubles.DataProcessor;
import uk.ac.aber.testdoubles.LogLevel;
import uk.ac.aber.testdoubles.Logger;

/**
 * Some tests the interactions of the DataProcessor with the a Logger.
 * Mockito is used to provide a Mock Object implementation for the 
 * logger. 
 *  
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class TestDataProcessorLoggerBehaviour {

	@Test
	public void shouldCallDebugAndInfoLoggerDuringProcessing() {
		
		Logger mockedLogger = mock(Logger.class);
		
		DataProcessor processor = new DataProcessor(mockedLogger); 
	
	    processor.doSomeProcessing(10);
	    
	    verify(mockedLogger, times(2)).addMessage(eq(LogLevel.DEBUG), anyString());
	    verify(mockedLogger).addMessage(eq(LogLevel.INFO), anyString()); 
	    verify(mockedLogger).flushMessages();
	}
	
	@Test
	public void shouldCallAddMessageBeforeFlushMessages() {
		
		Logger mockedLogger = mock(Logger.class);
		
		DataProcessor processor = new DataProcessor(mockedLogger); 
	
	    processor.doSomeProcessing(10);
	    
	    InOrder inOrder = inOrder(mockedLogger); 
	    
	    inOrder.verify(mockedLogger).addMessage(eq(LogLevel.DEBUG), anyString());
	    inOrder.verify(mockedLogger).addMessage(eq(LogLevel.INFO), anyString());
	    inOrder.verify(mockedLogger).addMessage(eq(LogLevel.DEBUG), anyString());
	    inOrder.verify(mockedLogger).flushMessages();
	}

}
