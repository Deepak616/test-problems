package com.jp.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MatchingParanthesis {
	//map to get matching open paranthesis for closed one
	private static Map<Character,Character> paranthesisMap=new HashMap<Character,Character>();
	private static List<Character> openParanthesisList=Arrays.asList('(','{','[');
	private static List<Character> closedParanthesisList=Arrays.asList(')','}',']');
	static {
		paranthesisMap.put(')', '(');
		paranthesisMap.put(']', '[');
		paranthesisMap.put('}', '{');
	}
	
	public static boolean isParanthesisMatched(String str) {
		Stack<Character> stack=new Stack<Character>();
		//iterate through every character present in string
		for(int i=0;i<str.length();i++) {
			Character ch=str.charAt(i);
			int ascii=ch;
			//checking if the character is not 0-9 and a-z
			if(!((ascii>=48 && ascii<=57) || (ascii>=97 && ascii<=122))) {
				//if character is one of open paranthesis push it in stack
				if(openParanthesisList.contains(ch))
					stack.push(ch);
				//if character is one of closed paranthesis get matching open from map and check if the last pushed open paranthesis in stack
				//matches with it. If matches pop the last open paranthesis and continue else return false
				if(closedParanthesisList.contains(ch)) {
					Character matchingOpen=paranthesisMap.get(ch);
					if(stack.peek().equals(matchingOpen))
						stack.pop();
					else
						return false;
				}
			}
		}
		//to check if all the open paranthesis are closed
		return stack.isEmpty();
	}
	
	public static void main(String args[]) {
		//code to give input from console
		/*Scanner scn=new Scanner(System.in);
		int tc=scn.nextInt();
		while(tc-- > 0) {
			String str=scn.next();
			System.out.println(isParanthesisMatched(str.toLowerCase()));
		}*/
		List<String> testString=Arrays.asList("{ac[bb]}","[dklf(df(kl))d]{}","{[[[]]]}","{3234[fd","{df][d}");
		for(String str:testString) {
			System.out.println(isParanthesisMatched(str));
		}
	}

}
