package bronze;

import java.io.*;
import java.util.*;

public class bj_14915_B2 {

	static String conv = "0123456789ABCDEF";

	static void Convert(int val, int n) {
		StringBuilder output = new StringBuilder();
		if (val == 0)
			System.out.println("0");
		else {
			while (val != 0) {
				output.append(conv.charAt(val % n));
				val /= n;
			}
			System.out.println(output.reverse().toString());
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Convert(m, n);
	}

}
