package com.algo.d2;

import java.util.*;

public class swea_1976_d2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			int h3 = h1 + h2, m3 = m1 + m2;
			while (m3 > 59) {
				m3 -= 60;
				h3++;
			}
			while (h3 > 12) {
				h3 -= 12;
			}
			System.out.printf("#%d %d %d\n", tc, h3, m3);
		}
	}

}
