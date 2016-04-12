package uk.ac.aber.testdoubles.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.ac.aber.testdoubles.ConsoleLogger;
import uk.ac.aber.testdoubles.LogLevel;

/**
 * Some tests the functionality of the ConsoleLogger class.
 *  
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
public class TestConsoleLogger {

	@Test
	public void shouldContainNoMessagesWhenCreated() {
		ConsoleLogger logger = new ConsoleLogger(); 
		assertEquals(0, logger.count());
	}
	
	@Test 
	public void shouldContainOneMessageInLogWhenOneMessageAdded() { 
		ConsoleLogger logger = new ConsoleLogger();
		logger.setLogLevel(LogLevel.DEBUG);
		logger.addMessage(LogLevel.DEBUG, "Example Message");
		assertEquals(1, logger.count());
	}
	
	@Test 
	public void shouldContaiTwoMessagesInLogWhenTwoMessagesAdded() { 
		ConsoleLogger logger = new ConsoleLogger();
		logger.setLogLevel(LogLevel.INFO);
		logger.addMessage(LogLevel.INFO, "Example Message");
		logger.addMessage(LogLevel.INFO, "Example Message");
		assertEquals(2, logger.count());
	}
	
	@Test 
	public void shouldContainNoMessageWhenErrorLevelSelectedButDebugSpecified() { 
		ConsoleLogger logger = new ConsoleLogger();
		logger.addMessage(LogLevel.DEBUG, "Example Message");
		assertEquals(0, logger.count());
	}

}
