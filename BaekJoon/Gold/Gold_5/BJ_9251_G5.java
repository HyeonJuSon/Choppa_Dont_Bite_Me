import java.util.*;
import java.io.*;

public class BJ_9251_G5 {

	static char[] A, B;
	static Integer[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		int N = A.length;
		int M = B.length;
		dp = new Integer[N + 1][M + 1];
		System.out.println(LCS(N-1,M-1));
	}
	
	static int LCS(int x, int y) {
		if(x==-1 || y==-1) return 0;
		
		if(dp[x][y]==null) {
			dp[x][y]=0;
			if(A[x]==B[y]) dp[x][y] = LCS(x-1,y-1)+1;
			else dp[x][y] = Math.max(LCS(x-1,y), LCS(x,y-1));
		}
		
		return dp[x][y];
	}

}
