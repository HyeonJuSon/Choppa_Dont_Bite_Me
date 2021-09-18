package bronze;

import java.io.*;

public class bj_15813_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			sum += input.charAt(i)-64;
		}
		System.out.println(sum);
	}

}
