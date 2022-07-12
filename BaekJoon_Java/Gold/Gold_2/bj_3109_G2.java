package com.algo;

import java.util.*;

public class bj_3109 {
	static int R, C;
	static int[][] arr;
	static final int wall = 1;
	static final int[] dx = { -1, 0, 1 };
	static final int[] dy = { 1, 1, 1 };
	static int ans = 0;
	static boolean isFind =false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		arr = new int[R][C];
		for (int i = 0; i < R; ++i) {
			String tmp = sc.nextLine();
			for (int j = 0; j < C; ++j) {
				if (tmp.charAt(j) == 'x')
					arr[i][j] = wall;
			}
		}
		for(int i=0; i<R; ++i) {
			isFind =false;
			arr[i][0] = 2;
			search(i, 0);
		}
		System.out.println(ans);
		sc.close();
	}

	static boolean isAvailable(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C)
			return false;
		if (arr[x][y] != 0)
			return false;
		return true;
	}

	static void search(int x, int y) {

		if (y == C-1) {
			isFind=true;
			ans++;
			return;
		}

		for (int d = 0; d < 3; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(isAvailable(nx,ny) && !isFind) {
				arr[nx][ny] = 2;
				search(nx, ny);
			}
		}
	}
}
