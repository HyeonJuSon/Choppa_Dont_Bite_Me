package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class bj_12813_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		String[] output = new String[5];
		Arrays.fill(output, "");
		int Len = A.length();
		// A&B
		for (int i = 0; i < Len; ++i) {
			char a = A.charAt(i);
			char b = B.charAt(i);
			output[0] += a == '1' && b == '1' ? "1" : "0";
			output[1] += a == '1' || b == '1' ? "1" : "0";
			output[2] += a != b ? "1" : "0";
			output[3] += a == '1' ? "0" : "1";
			output[4] += b == '1' ? "0" : "1";
		}

		for(int i=0;i<5;++i) System.out.println(output[i]);
	}

}
