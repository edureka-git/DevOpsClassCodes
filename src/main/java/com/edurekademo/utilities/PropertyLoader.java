package com.edurekademo.utilities;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Looks up a resource named 'name' in the classpath. The resource must map
 * to a file with .properties extention. The name is assumed to be absolute
 * and can use either "/" or "." for package segment separation with an
 * optional leading "/" and optional ".properties" suffix. Thus, the
 * following names refer to the same resource:
 *
 * @author Seshagiri Sriram
 * @version 1.0 
 * @param name classpath resource name [may not be null] 
 * @param loader classloader through which to load the resource [null 
 * is equivalent to the application loader]
 * @return resource converted to java.util.Properties [may be null if the 
 * resource was not found and THROW_ON_LOAD_FAILURE is false] 
 * @throws IllegalArgumentException if the resource was not found and
 * THROW_ON_LOAD_FAILURE is true 
 */

public class PropertyLoader 
{

	private static final boolean THROW_ON_LOAD_FAILURE = true; 
	private static final boolean LOAD_AS_RESOURCE_BUNDLE = false; 
	private static final String SUFFIX = ".properties";

	/**
	 * Logger enabled for the current class
	 */
	private static final Logger LOG =LoggerFactory.getLogger(PropertyLoader.class);

	/** 
	 * A convenience overload of {@link #loadProperties(String, ClassLoader)} 
	 * that uses the current thread's context classloader. 
	 */

	public static Properties loadProperties (final String name) { 
		return loadProperties (name, Thread.currentThread ().getContextClassLoader ()); 
	}

	@SuppressWarnings("rawtypes")
	public static Properties loadProperties (String names, ClassLoader loader) 
	{ 
		String name = null;
		ClassLoader loaders;
		if (names == null) throw new IllegalArgumentException ("null input: name"); 
		if (names.startsWith ("/")) name = names.substring (1); 
		if (names.endsWith (SUFFIX)) name = names.substring (0, names.length () - SUFFIX.length ()); 
		Properties result = null; 
		InputStream in = null; 
		try { 
			if (loader == null)
				loaders = ClassLoader.getSystemClassLoader (); 
			if (LOAD_AS_RESOURCE_BUNDLE) 
			{ 
				name = name.replace ('/', '.'); // Throws MissingResourceException on lookup failures: 
				final ResourceBundle rb = ResourceBundle.getBundle (name, Locale.getDefault (), loaders); 
				result = new Properties (); 
				for (Enumeration keys = rb.getKeys (); keys.hasMoreElements ();) 
				{ 
					final String key = (String) keys.nextElement (); 
					final String value = rb.getString (key); 
					result.put (key, value); 
				} 
			} 
			else { 
				name = name.replace ('.', '/'); 
				if (! name.endsWith (SUFFIX)) name = name.concat (SUFFIX); // Returns null on lookup failures: 
				if(loader!=null)
					in = loader.getResourceAsStream (name); 
				if (in != null) { 
					result = new Properties (); 
					result.load (in); // Can throw IOException 
				} 
			} 
		} 
		catch (Exception e) { 
			result = new Properties ();
			LoggerStackTraceUtil.printErrorMessage(e);
		} 
		finally { 
			if (in != null) 
				try 
			{ 
					in.close (); 
			} 
			catch (Throwable ignore) {} 
		} 
		if (THROW_ON_LOAD_FAILURE && (result == null)) 
		{ 
			// LOG exception... Do not re-throw this.. as I do not expect users to catch this exception :-) 
			//throw new IllegalArgumentException ("could not load [" + name + "]"+ " as " + (LOAD_AS_RESOURCE_BUNDLE ? "a resource bundle" : "a classloader resource"));
			result = new Properties ();
		} 
		return result;  
	}

}