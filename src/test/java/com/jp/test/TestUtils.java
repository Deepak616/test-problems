package com.jp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class TestUtils {
	
	static class Reader{
		
		private BufferedReader reader=null;
		private StringTokenizer str=null;
		
		public Reader(String resourceFile) {
			InputStream is=TestUtils.class.getClassLoader().getResourceAsStream(resourceFile);
			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
		    reader = new BufferedReader(streamReader);
		}
		
		public String read() {
			try {
			if(str==null || !str.hasMoreElements()) {
				str=new StringTokenizer(reader.readLine());
			}
			return str.nextToken();
			}
			catch(IOException e) {
				return null;
			}
		}
		
		public long nextLong() {
			return Long.parseLong(read());
		}
		
		public int nextInt() {
			return Integer.parseInt(read());
		}
	}

}
