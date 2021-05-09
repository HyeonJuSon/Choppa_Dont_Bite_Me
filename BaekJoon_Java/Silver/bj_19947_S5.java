package silver;
import java.io.*;
import java.util.*;
public class bj_19947_S5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine()," ");
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[] dp = new int[Y+1];
		dp[0]=H;
		for(int i= 1; i<=Y; ++i) {
			int max = Integer.MIN_VALUE;
			if(i>=1 && (int)(dp[i-1]*1.05) > max) max = (int)(dp[i-1]*1.05);
			if(i>=3 && (int)(dp[i-3]*1.2)>max) max = (int)(dp[i-3]*1.2);
			if(i>=5 && (int)(dp[i-5]*1.35)>max) max =(int)(dp[i-5]*1.35);
			dp[i] = max;
		}
		System.out.println(dp[Y]);
	}

}
