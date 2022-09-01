package bronze;
import java.io.*;
public class bj_13301_B1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[81];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=N;++i) dp[i] = dp[i-1]+dp[i-2];
		System.out.println((dp[N]*2+dp[N-1])*2);
	}

}
