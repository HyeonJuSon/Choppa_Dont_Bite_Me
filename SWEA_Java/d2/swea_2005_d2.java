package com.algo.d2;

import java.util.*;

public class swea_2005_d2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(sc.nextLine());
			int[][] pascal = new int[N][N];
			int cnt = 1;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < cnt; ++j) {
					if (j == 0 || j == cnt - 1)
						pascal[i][j] = 1;
					else {
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
					}
				}
				cnt++;
			}
			System.out.println("#" + tc + " ");
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (pascal[i][j] != 0)
						System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
