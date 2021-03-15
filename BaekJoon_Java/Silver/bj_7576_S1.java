package bj.silver;

import java.io.*;
import java.util.*;

public class bj_7576_S1 {
	static int N, M, map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	static int max = 0;

	static void bfs() {
		Queue<int[]> bfsQueue = new LinkedList<>();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 1) bfsQueue.offer(new int[] {i,j});
			}
		}

		while (!bfsQueue.isEmpty()) {
			int[] Pos = bfsQueue.poll();

			for (int d = 0; d < 4; ++d) {
				int nx = Pos[0] + dx[d];
				int ny = Pos[1] + dy[d];
				if (isAvailable(nx, ny)) {
					map[nx][ny] = map[Pos[0]][Pos[1]] + 1; // 초 추가해주고
					bfsQueue.offer(new int[] { nx, ny });
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					System.out.println("-1");
					return;
				}
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max-1);		
	}

	static boolean isAvailable(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) return false;
		if (map[x][y] != 0) return false;
		return true;
	}
}
