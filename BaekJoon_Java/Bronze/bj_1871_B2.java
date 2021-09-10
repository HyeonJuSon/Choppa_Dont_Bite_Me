package bronze;

import java.io.*;
import java.util.*;

public class bj_1871_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "-");
			String front = st.nextToken();
			int back = Integer.parseInt(st.nextToken());
			int N = front.length() - 1;
			int sum = 0;
			for (int i = 0; i < front.length(); ++i) {
				int val = (front.charAt(i) - 65);
				sum +=  val * Math.pow(26, N--);
			}
			System.out.println(Math.abs(sum - back) <= 100 ? "nice" : "not nice");
		}
	}

}
