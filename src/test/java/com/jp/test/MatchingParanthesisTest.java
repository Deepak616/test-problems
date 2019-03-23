package com.jp.test;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MatchingParanthesisTest {
	
	private String[] input;
	private String[] output;
	
	@Before
	public void getInputOutput() {
		TestUtils.Reader reader=new TestUtils.Reader("com/jp/testfiles/MatchingParanthesisTestsCases");
		int totalTc=reader.nextInt();
		input=new String[totalTc];
		output=new String[totalTc];
		for(int i=0;i<totalTc;i++) {
			input[i]=reader.read();
		}
		for(int i=0;i<totalTc;i++) {
			output[i]=reader.read();
		}
	}
	
	@Test
	public void testIsParanthesisMatched() {
		for(int i=0;i<input.length;i++){
			boolean result=MatchingParanthesis.isParanthesisMatched(input[i]);
			Assert.assertEquals("Test case "+i+" did not match expected result",output[i],String.valueOf(result));
		}
	}



}
