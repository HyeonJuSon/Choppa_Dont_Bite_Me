package bronze;

import java.io.*;
import java.util.*;

public class BJ_25024_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			String[] answer = { "No", "No" };
			if (isTime(front, back))
				answer[0] = "Yes";
			if (isDate(front, back))
				answer[1] = "Yes";
			System.out.println(answer[0] + " " + answer[1]);
		}
	}

	static boolean isTime(int hour, int min) {
		return 0 <= hour && hour <=23 && 0 <= min && min <= 59;
	}

	static boolean isDate(int m, int d) {
		int[] date = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		return 0 < m && m <= 12 && 1 <= d && d <= date[m];
	}

}
