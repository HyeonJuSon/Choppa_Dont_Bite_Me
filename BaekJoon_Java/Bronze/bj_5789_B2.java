package bronze;

import java.io.*;

public class bj_5789_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			String input = br.readLine();
			int targetIdx = input.length()/2;
			System.out.println(input.charAt(targetIdx-1) == input.charAt(targetIdx) ? "Do-it":"Do-it-Not");
		}
	}

}
