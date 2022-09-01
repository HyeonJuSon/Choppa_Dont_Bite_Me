package silver;

import java.io.*;
import java.util.*;

public class bj_9095_S3_DP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[11]; // 10까지 들어옴
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<11;++i) dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; ++n) {
			int target = Integer.parseInt(br.readLine());
			System.out.println(dp[target]);
		}
	}
}
