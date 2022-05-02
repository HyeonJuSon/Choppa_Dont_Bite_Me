import java.io.*;
import java.util.*;
public class bj_12865_G5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		int[][] dp = new int[N+1][W+1];
		for(int i=1;i<=N;++i) {
			st = new StringTokenizer(br.readLine(), " ");
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1 ; i<=N; ++i) {
			for(int w=1; w<=W; ++w) {
				if(weights[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w-weights[i]] + profits[i], dp[i-1][w]);
				}else dp[i][w] = dp[i-1][w];
			}
		}
		System.out.println(dp[N][W]);
	}

