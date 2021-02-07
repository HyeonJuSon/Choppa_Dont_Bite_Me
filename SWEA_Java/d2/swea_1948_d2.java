package com.algo.d2;

import java.io.*;
import java.util.*;

public class Solution_1948_d2 {
	static final int def = 31;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		int T = stoi(st.nextToken());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] before = new int[2];
			int[] after = new int[2];
			int calc = 0;
			before[0] = stoi(st.nextToken());
			before[1] = stoi(st.nextToken());
			after[0] = stoi(st.nextToken());
			after[1] = stoi(st.nextToken());
			if (after[0] == before[0]) {
				calc = after[1] - before[1] + 1;
			} else {
				calc += (before[0] == 2 ? 28 - before[1]
						: (before[0] == 4 || before[0] == 6 
						|| before[0] == 9 || before[0] == 11 ? 
								30 - before[1] : 31 - before[1]));
				for (int i = before[0]+1; i < after[0]; ++i) {
					calc += (i==2 ? 28 :(i==4||i==6||i==9||i==11 ? 30 : 31));
				}
				calc += after[1] + 1;
			}
			sb.append("#" + tc + " ").append(calc).append('\n');
		}
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
