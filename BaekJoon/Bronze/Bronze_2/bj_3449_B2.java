package bronze;

import java.io.*;

public class bj_3449_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; ++i) {
			String A = br.readLine();
			String B = br.readLine();
			int cnt =0;
			for(int j=0;j<A.length();++j) {
				if(A.charAt(j)!=B.charAt(j)) ++cnt;
			}
			sb.append("Hamming distance is ").append(cnt).append(".").append('\n');
		}
		System.out.println(sb.toString());
	}

}
