/**
 * 
 */
package org.imbibe.exception;

/**
 * @author nchinthakindi
 *
 */
public class ImbibeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public ImbibeException(String message)
	 {
	        super(message);
	 }

    public ImbibeException(String message, Throwable throwable) 
    {
        super(message, throwable);
    }

}
