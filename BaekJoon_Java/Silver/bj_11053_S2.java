package silver;

import java.io.*;
import java.util.*;

public class bj_11053_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0]= 1;
		for(int i=1;i<N;++i) {
			dp[i]=1;
			for(int j=0;j<i;++j) {
				if(arr[i] > arr[j] && dp[j]+1 > dp[i]) dp[i] = dp[j]+1;
			}
		}
		int max = 0;
		for(int i=0;i<N;++i) max = Math.max(max, dp[i]);
		System.out.println(max);
	}

}
