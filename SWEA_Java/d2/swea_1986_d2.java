package com.algo.d2;

import java.util.*;

public class swea_1986_d2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= N; ++i) {
				if (i % 2 == 0) sum -= i;
				else sum += i;
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
		sc.close();
	}

}
