package com.jp.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DemonetisationToken {
	
	//map to store the maximum value for calculated tokens which can be used for repeated subproblems
	private static Map<Long,Long> tokenCurrencyMap=new HashMap<Long,Long>();
	
	public static Long getMaximumCurrency(long n) {
		if(n<0) {
			return -1L;
		}
		//if subproblem for token values is solved get it from map otherwise solve the subproblem
		Long maxValue=tokenCurrencyMap.get(n);
		if(maxValue==null) {
			//for token of 0 and 1,maximum value will be same as token. so it can be used as base case
			if(n==0 || n==1) {
				tokenCurrencyMap.put(n,n);
				maxValue=n;
			}
			else {
				/*for tokens of other values, recursively call the same function for n/2,n/3 and n/4 tokens, sum them and 
				 * get maximum of sum and token value. 
				 */
				maxValue=Long.max(Long.max(getMaximumCurrency(n/2),n/2)+Long.max(getMaximumCurrency(n/3),n/3)+
						Long.max(getMaximumCurrency(n/4), n/4),n);
				tokenCurrencyMap.put(n,maxValue);
			}
		}
		return maxValue;
	}
	
	public static void main(String[] args) {
		//code to give input from console
		/*Scanner scn=new Scanner(System.in);
		int tc=scn.nextInt();
		while(tc-- > 0) {
			int n=scn.nextInt();
			System.out.println(getMaximumCurrency(n));
		}*/
		List<Long> testList=Arrays.asList(12L,2L,65536L,10000000L);
		for(Long n:testList) {
			System.out.println(getMaximumCurrency(n));
		}
	}
		
}
