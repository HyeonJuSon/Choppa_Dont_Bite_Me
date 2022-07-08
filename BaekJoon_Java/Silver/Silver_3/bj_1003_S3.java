package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1003_S3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] f = new int[41][2];
		f[0][1] = f[1][0] = 0;
		f[0][0] = f[1][1] = 1;
		for(int i=2;i<41;++i) {
			f[i][0]= f[i-1][0]+f[i-2][0];
			f[i][1]= f[i-1][1]+f[i-2][1];
		}
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			int target = Integer.parseInt(br.readLine());
			System.out.println(f[target][0]+" "+f[target][1]);
		}
	}

}
