package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_89 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		dp[1]=a;
		dp[2]=a+d;
		for(int i=3;i<=n;++i) {
			dp[i]=dp[i-1]+d;
		}
		System.out.println(dp[n]);
	}
	
}