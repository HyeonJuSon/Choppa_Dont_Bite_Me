package com.algo.d2;

import java.util.*;
public class swea_1926_d2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; ++i) {
			String tmp = String.valueOf(i);
			int idx = 0, cnt = 0;
			while (idx < tmp.length()) {
				switch (tmp.charAt(idx++)) {
				case '3':
				case '6':
				case '9':
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				for (int k = 0; k < cnt; ++k)
					System.out.print("-");
				System.out.print(" ");
			} else System.out.print(i+" ");
		}
		sc.close();
	}
}
