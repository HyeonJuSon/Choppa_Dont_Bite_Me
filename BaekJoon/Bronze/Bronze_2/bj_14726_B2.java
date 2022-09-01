package bronze;

import java.io.*;

public class bj_14726_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			char[] arr = br.readLine().toCharArray();
			int sum = 0;
			for (int a = arr.length-2; a >=0; a -= 2) {
				int val = 2 * (arr[a] - '0');
				if (val >= 10)
					val = val / 10 + val % 10;
				arr[a] = (char) (val + '0');
			}
			for (int a = 0; a < arr.length; ++a)
				sum += (arr[a] - '0');
			System.out.println(sum % 10 == 0 ? "T" : "F");
		}
	}

}
