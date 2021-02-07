package com.algo.d2;

import java.io.*;

public class Solution_1945_d2 {

	static int[] num = new int[] {2,3,5,7,11};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1945.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			int Val = stoi(br.readLine());
			int[] cnt = new int[5];
			while(true) {
				
				for(int i=0;i<num.length;++i) {
					if(Val % num[i] == 0) {
						cnt[i]++;
						Val /= num[i];
					}
				}
				
				if(Val ==0 || Val ==1) break;
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<cnt.length;++i) {
				sb.append(cnt[i]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
