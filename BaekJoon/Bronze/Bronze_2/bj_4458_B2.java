package bronze;

import java.io.*;

public class bj_4458_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			String input = br.readLine();
			String first = input.charAt(0)+"";
			System.out.println(first.toUpperCase()+input.substring(1));
		}
	}

}
