package bronze;
import java.io.*;
public class bj_9625_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[46][2];
		dp[0][0] = dp[1][1] = 1;
		dp[0][1] = dp[1][0] = 0;
		for(int i= 2; i<=N;++i) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		System.out.println(dp[N][0]+" "+dp[N][1]);
	}

}
