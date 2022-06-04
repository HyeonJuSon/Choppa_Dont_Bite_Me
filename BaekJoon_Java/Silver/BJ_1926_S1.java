package silver;

import java.io.*;
import java.util.*;

public class BJ_1926_S1 {

	static int N, M, map[][];
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
	static int max = 0, maxCnt = 0;
	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (!isVisited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					++maxCnt;
				}
			}
		}
		System.out.println(maxCnt);
		System.out.println(max);
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		int cnt = 1;
		isVisited[x][y] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];
				if (isBoundary(nx, ny) && !isVisited[nx][ny] && map[nx][ny] == 1) {
					isVisited[nx][ny] = true;
					q.add(new int[] { nx, ny });
					++cnt;
				}
			}
		}
		max = Math.max(max, cnt);
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
