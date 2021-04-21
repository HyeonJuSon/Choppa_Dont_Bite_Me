package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_91 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] dp = new long[11];
		dp[1]=a;
		dp[2]=a*m+d;
		for(int i=3;i<=n;++i) {
			dp[i]=dp[i-1]*m+d;
		}
		System.out.println(dp[n]);
	}
	
}
