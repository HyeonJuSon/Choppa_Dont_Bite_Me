package silver;

import java.io.*;
import java.util.*;

public class bj_16395_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[31][31];
		dp[1][1] = 1;
		dp[2][1] = dp[2][2] = 1;
		int end = 3;
		for (int i = 3; i <= N; ++i) {
			for (int j = 1; j <= end; ++j) {
				if (j == 1 || j == end)
					dp[i][j] = 1;// 양끝
				else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
			end++;
		}
		System.out.println(dp[N][K]);
	}

}
