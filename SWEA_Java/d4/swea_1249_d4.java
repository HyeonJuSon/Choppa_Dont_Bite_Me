package com.swea.d4;

import java.io.*;
import java.util.*;

public class swea_1249_d4 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			boolean[][] isVisited = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				char[] ch = in.readLine().toCharArray();
				for (int j = 0; j < N; ++j) {
					map[i][j] = ch[j] - '0';
				}
			}

			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { 0, 0 });
			isVisited[0][0] = true;
			dist[0][0] = 0;
			int min = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				if (min <= dist[now[0]][now[1]]) continue;
				if (now[0] == N - 1 && now[1] == N - 1) {
					min = Math.min(min, dist[N - 1][N - 1]);
				}

				for (int d = 0; d < 4; ++d) {
					int nx = now[0] + dx[d];
					int ny = now[1] + dy[d];
					if (isAvailable(nx, ny)) {
						if (!isVisited[nx][ny] || dist[nx][ny] > dist[now[0]][now[1]] + map[nx][ny]) {
							isVisited[nx][ny] = true;
							dist[nx][ny] = dist[now[0]][now[1]] + map[nx][ny];
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
			System.out.println("#"+tc+" "+min);
		}
	}

	static boolean isAvailable(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}

/*
 * [ 문제 요약 ] 1. S(0,0)에서 G(N-1,N-1)까지 간다. 2. 구멍 깊이가 1이면 드는 시간은 1이다. (비례한다) 3.
 * S->G에서 가장 짧은 경로에 대한 복구 시간을 구한다. 4. 이동은 상,하,좌,우로 한 칸씩 이동한다. 5. 맵에서 도로의 깊이가
 * 주어진다.
 */
