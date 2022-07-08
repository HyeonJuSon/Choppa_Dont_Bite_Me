package silver;

import java.io.*;
import java.util.*;

public class bj_1388_S4 {

	static int N, M, map[][];
	static int[][] dir = { { 0, 1 }, { 1, 0 } }; // 우,하
	static final int garo = 1, sero = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String input = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) == '-' ? garo : sero;
			}
		}
		boolean[][] isVisited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (!isVisited[i][j]) {
					++cnt;
					bfs(i, j, isVisited);
				}
			}
		}
		System.out.println(cnt);
	}

	static void bfs(int x, int y, boolean[][] isVisited) {
		Queue<int[]> q = new LinkedList<>();
		isVisited[x][y] = true;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int d = map[now[0]][now[1]] == garo ? 0 : 1;
			int nx = now[0] + dir[0][d];
			int ny = now[1] + dir[1][d];
			if(isBoundary(nx,ny) && map[nx][ny] == map[now[0]][now[1]]) {
				isVisited[nx][ny]=true;
				q.add(new int[] {nx,ny});
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
