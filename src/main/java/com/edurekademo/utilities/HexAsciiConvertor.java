package com.edurekademo.utilities;

public class HexAsciiConvertor {
	/**
	 * Method to convert hexadecimal values into ascii
	 * method is return the ascii value
	 * @param hexValue
	 * @return outputAscii
	 */
	
	public static String convertHexToASCII(String hexValue)
	{
		StringBuilder outputAscii = new StringBuilder();
		String asciiValue = null;
		try{
		   if(hexValue!=null){
			    for (int i = 0; i < hexValue.length(); i += 2)
			    {
			        String str = hexValue.substring(i, i + 2);
			        outputAscii.append((char) Integer.parseInt(str, 16));
			    }
			    asciiValue = outputAscii.toString();
		   }
		}
		catch(Exception ex){
			LoggerStackTraceUtil.printErrorMessage(ex);
		}
	    return asciiValue;
	}
	
	/**
	 * Method to convert ascii values into hexadecimal
	 * method is returning the hexadecimal value
	 * @param asciiValue
	 * @return hex
	 */
	
	public static String convertAsciiToHex(String asciiValue)
	{
		String hexvalue = null;
		try {
			
			  if(asciiValue!=null)
			  {
			      char[] chars = asciiValue.toCharArray();
			      StringBuffer hex = new StringBuffer();
			      for (int i = 0; i < chars.length; i++)
			      {
			         hex.append(Integer.toHexString((int) chars[i]));
			      }
			      hexvalue= hex.toString();
			  }			  
		}
		catch (Exception e) {
			LoggerStackTraceUtil.printErrorMessage(e);
		}
		return hexvalue;
	}
}