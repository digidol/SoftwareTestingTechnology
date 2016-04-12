/**
 * 
 */
package uk.ac.aber.sttunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention; 
import java.lang.annotation.RetentionPolicy; 
import java.lang.annotation.Target; 

/**
 * Annotation that is used to indicate if a method should 
 * be run as a test. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
public @interface AUTest {
	
}
