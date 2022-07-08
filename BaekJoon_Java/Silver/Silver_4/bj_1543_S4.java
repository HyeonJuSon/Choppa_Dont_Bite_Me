package silver;

import java.io.*;
import java.util.*;

public class bj_1543_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String document = br.readLine();
		String target = br.readLine();
		int cnt = 0;
		int N = target.length();
		for (int i = 0; i < document.length(); ++i) {
			if(i+N > document.length()) break;
			String now = document.substring(i,i+target.length()); 
			if(target.equals(now)) {
				++cnt;
				i+=N-1;
			}
		}
		System.out.println(cnt);
	}

}
