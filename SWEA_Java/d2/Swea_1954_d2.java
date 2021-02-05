package com.hwalgo02;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1954_달팽이숫자_구미_4_손현주 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_hw_1954.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];// N*N
			int change = 1;
			int x = 0, y = -1;
			int cnt = 1;

			while (true) {
				for (int i = 0; i < N; ++i) {
					y += change;
					snail[x][y] = cnt++;
				}
				--N;
				for (int i = 0; i < N; ++i) {
					x += change;
					snail[x][y] = cnt++;
				}
				change *= -1;
				if (N == 0)
					break;
			}
			System.out.println("#" + tc);
			for (int i = 0; i < snail.length; ++i) {
				for (int j = 0; j < snail.length; ++j) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
