package silver;
import java.io.*;
public class bj_14916_S5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[100001];
		dp[1]=-1;//2,5원만 가능하니까
		dp[2]=1;
		int N = Integer.parseInt(br.readLine());
		for(int i=3; i<=N;++i) {
			int min = Integer.MAX_VALUE;
			if(i>=2 && dp[i-2]!=-1 && dp[i-2]+1 < min) min = dp[i-2]+1;
			if(i>=5 && dp[i-5]!=-1 && dp[i-5]+1 < min) min = dp[i-5]+1;
			if(min == Integer.MAX_VALUE) dp[i]=-1;
			else dp[i] = min;
		}
		System.out.println(dp[N]);
	}

}
