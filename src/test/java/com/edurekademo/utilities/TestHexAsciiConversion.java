package com.edurekademo.utilities;

import static org.junit.Assert.*;

import com.edurekademo.utilities.HexAsciiConvertor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestHexAsciiConversion {

	HexAsciiConvertor conversion=new HexAsciiConvertor();
	String Value="testing ascii convertion into hexadecimal";
	String hexvalue="74657374696e6720617363696920636f6e76657274696f6e20696e746f2068657861646563696d616c";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAsciiToHexValid() {
		String hexadecimalValue= conversion.convertAsciiToHex(Value);
		assertEquals(" ",hexadecimalValue, "74657374696e6720617363696920636f6e76657274696f6e20696e746f2068657861646563696d616c");
		System.out.println(hexadecimalValue);
	}
	
	@Test
	public void testAsciiToHexNull()
	{
		String hexvalueNull=conversion.convertHexToASCII(null);
		assertNull("Result should be null", hexvalueNull);
		
	}
	
	@Test
	
	public void testHexToAsciiValid()
	{
		String asciiValue=conversion.convertHexToASCII(hexvalue);
		
		assertEquals(" ",asciiValue,"testing ascii convertion into hexadecimal");
		System.out.println(asciiValue);
	}
	
	@Test

	public void testHextoAsciiNull()
	{
		String asciiValueNull=conversion.convertAsciiToHex(null);
		assertNull("Result should be null", asciiValueNull);
		
	}
	
}
