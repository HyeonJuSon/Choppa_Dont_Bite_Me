package bj.bronze;

import java.io.*;
import java.util.*;
public class bj_1009_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ans = 1;
			for(int i=0;i<b;++i) ans = (ans*a)%10;
			System.out.println(ans==0?10:ans);
		}
	}

}
