package com.sweaTestQuestion;

import java.io.*;
import java.util.*;

public class swea_1949 {
	static int[][] map;
	static boolean[][] isVisited;
	static int max, N, K, maxLength;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxLength = 1;
			max = Integer.MIN_VALUE;
			map = new int[N][N];
			isVisited = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			// 높은 위치의 부터 시작했을 때 더이상 최대높이가 없을때까지 반복
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] == max) {
						isVisited[i][j] = true;
						search(i, j, max, 1, 0);
						isVisited[i][j] = false;
					}
				}
			}
			System.out.println("#" + tc + " " + maxLength);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void search(int x, int y, int h, int s, int cnt) {
		for (int d = 0; d < 4; ++d) {
			maxLength = Math.max(maxLength, s);
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isAvailable(nx, ny)) {
				if (map[nx][ny] < h) {
					isVisited[nx][ny] = true;
					search(nx, ny, map[nx][ny], s + 1, cnt);
					isVisited[nx][ny] = false;
				} else {
					if (cnt == 0) {// 안깎았으면-=>딱 한번만 깎을 수 있따.
						if (h > map[nx][ny] - K) { // 깎았을때 h가 더 커지면
							isVisited[nx][ny] = true;
							search(nx, ny, h - 1, s + 1, cnt + 1); // 높이를 1만깎아줌
							isVisited[nx][ny] = false;
						}
					}
				}
			}
		}
	}

	static boolean isAvailable(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		if (isVisited[x][y])
			return false;
		return true;
	}
}