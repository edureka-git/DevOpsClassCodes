package com.edurekademo.utilities;

public class PrepareTargetMethod {

	private static final String METHOD_GET_PREFIX = "get";
	/**
	 * preparing target name of getter method for given sort field
	 *
	 * @param name a {@link java.lang.String}
	 * @return methodName a {@link java.lang.String}
	 */
	public String prepareTargetMethod(String name) {
		StringBuffer fieldName = new StringBuffer(METHOD_GET_PREFIX);
		fieldName.append(name.substring(0, 1).toUpperCase()).append(name.substring(1));
		return fieldName.toString();
	}
}
