package com.edurekademo.utilities;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Class used to log the print stack trace items
public class LoggerStackTraceUtil {

	private static final Logger LOG =LoggerFactory.getLogger(LoggerStackTraceUtil.class);  
	private int maxCount=3; 

		/**
	 * @param th - The exception that was thrown and to be logged. 
	 * @return at very least the 1st error, if stacktrace is more than 1, then it also 
	 *         returns the immediate cause
	 *
	 * Note this function cannot be made static for thread safety..         
	 */
	public String getErrorMessage(Throwable th){ 
		if (th==null) return ""; 
		StringBuilder b = new StringBuilder(""); 
		String [] aryError = ExceptionUtils.getRootCauseStackTrace(th);
		b.append(aryError[0].trim()); 
		if (aryError.length >= 2){
			b.append(String.format("%nCause:%s",aryError[1].trim())); 
		}
		if (aryError.length >= maxCount){
			b.append(String.format("%nCause:%s",aryError[2].trim())); 
		}
		return b.toString(); 
	}

	// Static Logger function
	public static void printErrorMessage(Throwable th)
	{
		try{
			  // log the error caused by
			LOG.error("Error Cause: {}",th.getMessage());
			  // Conditional statement to check the length of the array
			 int count=0;
			 for(StackTraceElement stackTrace:th.getStackTrace()){
				 if(count<=25){
					 LOG.error("Error Class: {} and Line Number: {}",stackTrace.getClassName(),stackTrace.getLineNumber());
				 }else{
					 break;
				 }
				 count++;
			 }
		}
		catch(Exception e)
		{
			// log the exception error
			LoggerStackTraceUtil.printErrorMessage(e);
		}
      
	  
	}

}
