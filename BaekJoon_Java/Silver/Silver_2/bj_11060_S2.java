package gold;
import java.io.*;
import java.util.*;
public class bj_11060_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dp, INF);
		dp[0]=0;
		for(int i=0;i<N;++i) {
			int val = arr[i];
			for(int v=1;v<=val;++v) {
				if(i+v<N) {
					if(dp[i] != INF && dp[i+v] > dp[i]+1) {
						dp[i+v]=dp[i]+1;
					}
				}
			}
		}
		System.out.println(dp[N-1]==INF?-1:dp[N-1]);
	}

}
