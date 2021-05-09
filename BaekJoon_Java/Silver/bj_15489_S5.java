package silver;
import java.io.*;
import java.util.*;
public class bj_15489_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] dp = new int[31][31];
		dp[1][1] = dp[2][1] = dp[2][2] = 1;
		for (int i = 3; i < 31; ++i) {
			for (int j = 1; j <= i; ++j) {
				if (j == 1 || j == i) dp[i][j] = 1;// 양끝
				else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}
		
		int sum =0;
		int size = 1;
		for(int i=R;i<R+W;++i) {
			for(int j=C;j< C+size;++j) {
				sum+=dp[i][j];
			}
			size++;
		}
		System.out.println(sum);
	}

}
