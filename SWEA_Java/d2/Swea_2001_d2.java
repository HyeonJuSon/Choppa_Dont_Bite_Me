package com.hwalgo03;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2001_파리퇴치_구미_4_손현주 {

	static int[][] field;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Input_hw_2001.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			field = new int[N][N];
			// 입력받고
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					field[i][j] = sc.nextInt();
				}
			}
			boolean loop = true;
			int max = 0, eX = 0, eY = 0;
			while (loop) {
				int sum = 0;
				for (int i = eX; i < eX + M; ++i) {
					for (int j = eY; j < eY + M; ++j) {
						sum += field[i][j];
					}
				}
				max = Math.max(max, sum);
				eY++;
				if (!(eY + (M - 1) < N)) {
					eX++;
					eY = 0;
					if (!(eX + (M - 1) < N)) {
						loop = false;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
}
