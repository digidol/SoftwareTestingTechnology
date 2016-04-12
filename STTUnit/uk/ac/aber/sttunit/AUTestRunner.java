package uk.ac.aber.sttunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import stt.example.ExampleTestClass;
import stt.example.SecondExampleTestClass;

/**
 * Main class that starts the test runner process. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class AUTestRunner {

	/** Holds a list of tests for each of the specified test cases */ 
	private Dictionary<Class<?>, ArrayList<AUResult>> results; 
	
	/** The total number of tests run */ 
	private int testCount; 
	
	/** The total number of tests that passed. */ 
	private int passedTests;
	
	/** The total number of tests that failed. */ 
	private int failedTests; 
	
	/** 
	 * Creates a new instance of the test runner. It initialises the 
	 * data fields ready to run a set of tests. 
	 */
	public AUTestRunner() { 
		this.results = new Hashtable<>();
		testCount = 0; 
		passedTests = 0; 
		failedTests = 0; 
	}
	
	/**
	 * Runs a set of test methods in the specified class. A test method 
	 * must have the @AUTest annotation for it to be treated as test 
	 * method. 
	 * 
	 * @param classToTest The class that should contain one or more test methods. 
	 */
	protected void runTestsForClass(Class<?> classToTest) { 
			
		try { 
			Object instance = classToTest.newInstance(); 
			
			ArrayList<AUResult> resultCollection = new ArrayList<AUResult>();
			
		    for(Method method : classToTest.getDeclaredMethods()) { 
			   if(method.isAnnotationPresent(AUTest.class)) { 
				   try { 
				      testCount++; 
				      method.invoke(instance, new Object[]{ });
				      passedTests++; 
				      resultCollection.add(new AUResult(method.getName()));
				   }
				   catch(InvocationTargetException ite) { 
					  resultCollection.add(new AUResult(method.getName(), ite.getCause()));
					  failedTests++;  
				   }
			   }
		   }
		    
		   results.put(classToTest, resultCollection);
		   
		}
		catch(InstantiationException ie) { 
			System.out.println("Unable to instantiate the class.");
		}
		catch(IllegalAccessException iae) { 
			System.out.println("Access error during object creation.");
		}
	}
	
	/** 
	 * Prints the results of the testing stage to the console. 
	 */
	private void outputResultsToConsole() { 
		System.out.println(getResultsAsString());
	}

	/**
	 * Creates a string that represents the results. 
	 */
	private String getResultsAsString() {
		StringBuilder builder = new StringBuilder(); 
		
		builder.append((String.format("Total: %d Passed: %d Failed: %d\n", testCount, passedTests, failedTests)));
		
		Enumeration<Class<?>> keyEnumerator = results.keys();
		while(keyEnumerator.hasMoreElements()) { 
			
			builder.append("\n");  
			
			Class<?> testClass = keyEnumerator.nextElement();
			builder.append("Class: " + testClass.getCanonicalName() + "\n");
			
			ArrayList<AUResult> resultList = results.get(testClass); 
			for(AUResult result : resultList) { 
				builder.append("\t" + result + "\n");
			}
		}
		return builder.toString(); 
	}
	
	/**
	 * Loops through a list of classes, running the tests on each class. 
	 * 
	 * @param classes The list of classes with tests cases. 
	 */
	public void runTestsForClasses(Class<?>[] classes) { 
		
		for(Class<?> testClass : classes) { 
			runTestsForClass(testClass); 
		}
		
		outputResultsToConsole(); 
	}
	
	/**
	 * Starts the program and runs a set of tests on the specified 
	 * test classes that are also included in this project. 
	 * 
	 * @param args The command line arguments are not used in this project. 
	 */
	public static void main(String[] args) {
		AUTestRunner runner = new AUTestRunner(); 
		runner.runTestsForClasses(new Class<?>[] { ExampleTestClass.class, SecondExampleTestClass.class });
	}

}
