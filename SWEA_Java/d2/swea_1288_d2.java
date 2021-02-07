package com.algo.d2;

import java.util.*;

public class swea_1288_d2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; ++tc) {
			String N = sc.nextLine();
			int stoi = Integer.parseInt(N);
			int[] arr = new int[10];
			int k = 1;
			while (true) {
				int newN = stoi * k;
				N = Integer.toString(newN);
				// k*N
				for (int i = 0; i < N.length(); ++i)
					arr[ctoi(N.charAt(i))]++;

				// search
				int cnt = 0;
				for (int i = 0; i < 10; ++i) {
					if (arr[i] > 0)
						cnt++;
				}
				if (cnt >= 10)
					break;
				k++;
			}
			sb.append("#" + tc + " ").append(N).append('\n');
		}
		System.out.println(sb);
	}

	static int ctoi(char c) {
		return c - '0';
	}
}
