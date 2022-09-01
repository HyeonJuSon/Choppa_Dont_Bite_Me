package bj.silver;

import java.util.Scanner;

public class bj_1463_S3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];

		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= N; ++i) {
			int min = Integer.MAX_VALUE;
			if (i % 3 == 0 && dp[i / 3] + 1 < min)
				min = dp[i / 3] + 1;
			if (i % 2 == 0 && dp[i / 2] + 1 < min)
				min = dp[i / 2] + 1;
			if (dp[i - 1] + 1 < min)
				min = dp[i - 1] + 1;
			dp[i] = min;
		}
		System.out.println(dp[N]);
	}

}
