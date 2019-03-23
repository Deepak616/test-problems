package com.jp.test;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DemonetisationTokenTest {
	
	private long[] input;
	private long[] output;
	
	@Before
	public void getInputOutput() {
		TestUtils.Reader reader=new TestUtils.Reader("com/jp/testfiles/DemonetisationTestCases");
		int totalTc=reader.nextInt();
		input=new long[totalTc];
		output=new long[totalTc];
		for(int i=0;i<totalTc;i++) {
			input[i]=reader.nextLong();
		}
		for(int i=0;i<totalTc;i++) {
			output[i]=reader.nextLong();
		}
	}
	
	@Test
	public void testGetMaximumCurrency() {
		for(int i=0;i<input.length;i++){
			long result=DemonetisationToken.getMaximumCurrency(input[i]);
			Assert.assertEquals("Test case "+i+" did not match expected result",output[i],result);
		}
	}

}
