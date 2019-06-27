package com.edurekademo.utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * An utility class that is used to split an string into an array list and providing mechanism to 
 * build a HashMap value based on a variable number of arguements. 
 * @author Seshagiri Sriram
 * @version 1.0 
 *
 */
public class StringUtilities {
	/**
	 * The string separator for splitting a string into a list
	 */
	private final static String COMMA_SEPARATOR = ","; 
	/**
	 * The String separator for splitting a parameter value. 
	 * Parameters are expected to be in form: "parametername=value"
	 */
	private final static String PARAM_SEPARATOR = "=";
	/**
	 * The String separator for splitting a parameter value into appropriate type. 
	 * Required for HQL Queries, never for Native SQL queries
	 * Parameters are expected to be in form: "parametername=value:type (int, string, float, double)"
	 */
	private final static String TYPE_SEPARATOR = ";";
	/**
	 * The String separator for splitting a date parameter value into appropriate format. 
	 */
	private final static String DATEFORMAT_SEPARATOR = "@";
	
	/**
	 * The method to be invoked to convert a given String value to a specific Object type
	 */
	private final static String CONVERTOR_METHOD_NAME = "valueOf" ;
	
	/**
	 * The String to represent the type "DATE"
	 */
	private final static String DATE_TYPE = "date" ;
	
	/**
	 * Default Date format to which the date will be formatted
	 */
	
	private final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss" ;
	/**
	 * Variable to represent the type "STRING"
	 */
	private final static String STRING_TYPE ="string";
	/**
	 * Logger enabled for the current class
	 */
	private static final Logger LOG =LoggerFactory.getLogger(StringUtilities.class);

	/** Primitive type name -> class map. */
	private static final HashMap<String,Class<?>> PRIMITIVE_NAME_TYPE_MAP = new HashMap<String,Class<?>>();

    /** Setup the primitives map. */
	static {
		PRIMITIVE_NAME_TYPE_MAP.put("boolean", Boolean.class);
		PRIMITIVE_NAME_TYPE_MAP.put("int", Integer.class);
		PRIMITIVE_NAME_TYPE_MAP.put("long", Long.class);
		PRIMITIVE_NAME_TYPE_MAP.put("float", Float.class);
		PRIMITIVE_NAME_TYPE_MAP.put("double", Double.class);
	}

	/**
	 * given a comma separated string and type, returns an ArrayList of specific types 
	 * @param strParamValueList The string (assumed to be comma separated). Usually meant for use in creating 
	 *                          parameter values for passing in IN Clauses
	 * @param type The type of the Arraylist passed
	 * @return ArrayList if passed value is not null or empty, null otherwise
	 */
	public static List<Object> convertStringToList(String strParamValueList,String type){
		if (strParamValueList==null||strParamValueList.trim().isEmpty())  return null; 
		ArrayList<Object> list = new ArrayList<Object>(); 
	    String arr[] = strParamValueList.trim().split(COMMA_SEPARATOR); 
	    for(String tmpString: arr){
	    	list.add(convert(tmpString,type)); 
	    }
		return list; 
	}
	
	/**
	 * given a variable list of String parameters, forms a hash map 
	 * @param strParamValueList Variable list of arguments each of format: key=kevalue;type.
	 *                          For the type date,you can even pass the dateformat value as key=keyvalue@dateformat;type.
	 *                          If dateformat is not passed default format yyyy-MM-dd HH:mm:ss will be taken.
	 * @return HashMap  if no arguments are passed, returns an empty list, else populated hashmap
	 * support only int, string, boolean, float, double, long, date
	 */
	public static HashMap<String, Object> createParameterList(String... strParamValueList){
		HashMap<String, Object> hMap = new HashMap<String, Object>(); 
		for(String strArg: strParamValueList){
			String type = null;
			if(strArg.contains(TYPE_SEPARATOR)){
				type = strArg.split(TYPE_SEPARATOR)[1]; 
				strArg = strArg.split(TYPE_SEPARATOR)[0];
			}
			if (strArg.contains(PARAM_SEPARATOR)){
				String arr[]  = strArg.split(PARAM_SEPARATOR); 
				if (arr[1].contains(COMMA_SEPARATOR)){
					hMap.put(arr[0], convertStringToList(arr[1],type)); 
				}
				else {
					hMap.put(arr[0], convert(arr[1],type)); 
				}
			}
		}
		return hMap; 
	}
	
	/**
	 * Converts the given String value to the intended type of Object
	 * @param value The String value to be converted
	 * @param type The type to which the value needs to be converted
	 * @return Object Returns values as such if type or value is empty or null,else returns the converted Object
	 */
	private static Object convert(String value, String types) {

		Class<?> finalClass = null ;
		//If value or type passed is null or empty or string return back value as such
		if ((value == null) || value.isEmpty() || types == null || types.isEmpty() || types.equalsIgnoreCase(STRING_TYPE))  return value;

		String type = types.toLowerCase();
		
		if (type.equals(DATE_TYPE)) return convertStringToDate(value);	
		
		//Based on the passed type load the wrapper class. 
		//If the given type not permitted returns values as such
		if(PRIMITIVE_NAME_TYPE_MAP.containsKey(type))
			finalClass = PRIMITIVE_NAME_TYPE_MAP.get(type);
				
		try {
			//Invoking the valueOf method of the Wrapper Class dynamically using reflection
			if(finalClass!=null){
				Method method = finalClass.getMethod(CONVERTOR_METHOD_NAME, String.class);
				int mods = method.getModifiers();
				if (Modifier.isStatic(mods) && Modifier.isPublic(mods)) {
					return method.invoke(null, value);
				}
			}			
		}
		catch (NoSuchMethodException e) {
			LoggerStackTraceUtil.printErrorMessage(e);
		}
		catch (IllegalAccessException e) {
			// this won't happen 
			LoggerStackTraceUtil.printErrorMessage(e);
		}
		catch (InvocationTargetException e) {
			// when this happens, the string cannot be converted to the intended type
			// we are ignoring it here - the original string will be returned
			LoggerStackTraceUtil.printErrorMessage(e);
		}

		return value;
	}

	/**
	 * Convert the given date value in string to date object
	 * @param dateString The date to be formatted
	 * @return Object Returns the corresponding Date object
	 */
	private static Object convertStringToDate(String dateString) {
		String dateFormat = null;
		Object finalDate = null;
		String dateStringVal=null;
		//If the incoming date string contains the format as well parse using the given format, else parse using default
		dateFormat = (dateString.contains(DATEFORMAT_SEPARATOR)) ? dateString.split(DATEFORMAT_SEPARATOR)[1] : DATE_FORMAT ;
		dateStringVal = (dateString.contains(DATEFORMAT_SEPARATOR)) ? dateString.split(DATEFORMAT_SEPARATOR)[0] : dateString ;
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		
		try{
			finalDate = dateFormatter.parse(dateStringVal);
		}catch(ParseException e){
			LoggerStackTraceUtil.printErrorMessage(e);
		}
		return finalDate;
	}
}
