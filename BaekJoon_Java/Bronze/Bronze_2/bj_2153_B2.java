package bronze;

import java.io.*;
import java.util.*;

public class bj_2153_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		for (int i = 0; i < str.length(); ++i) {
			char now = str.charAt(i);
			if ('a' <= now && now <= 'z') {
				sum += (now - 96);
			} else if ('A' <= now && now <= 'Z') {
				sum += (now-38);
			}
		}
		boolean isPrime=true;
		for(int i=2;i<sum;++i) {
			if(sum%i==0) {
				isPrime=false;
				break;
			}
		}
		System.out.println(isPrime ? "It is a prime word.":"It is not a prime word.");
	}

}
