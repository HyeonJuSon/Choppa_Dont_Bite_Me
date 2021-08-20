package bronze;

import java.util.Scanner;

public class bj_3059_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; ++i) {
			int[] alpha = new int[26];
			String input = sc.next();
			int sum =0;
			for(int j=0;j<input.length();++j) {
				++alpha[input.charAt(j)-'A'];
			}
			for(int j=0;j<26;++j) {
				if(alpha[j] ==0) 
					sum+= (int)(j+'A');
			}
			System.out.println(sum);
		}
		
	}
	
}
