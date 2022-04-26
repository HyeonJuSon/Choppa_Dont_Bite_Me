package silver;

import java.io.*;
import java.util.*;

public class bj_11123_S1 {
	static int[][] map;
	static int H, W;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; ++n) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; ++i) {
				String now = br.readLine();
				for (int j = 0; j < W; ++j) {
					if (now.charAt(j) == '#')
						map[i][j] = -1;
					else
						map[i][j] = -2;
				}
			}
			boolean[][] isVisited = new boolean[H][W];
			int idx = 0;
			for (int i = 0; i < H; ++i) {
				for (int j = 0; j < W; ++j) {
					if (map[i][j] == -1) {
						bfs(i, j, isVisited, idx++);
					}
				}
			}
			System.out.println(idx);
		}
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static void bfs(int x, int y, boolean[][] isVisited, int idx) {
		isVisited[x][y] = true;
		map[x][y] = idx;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];
				if (0 <= nx && nx < H && 0 <= ny && ny < W && !isVisited[nx][ny] && map[nx][ny] == -1) {
					isVisited[nx][ny] = true;
					map[nx][ny] = idx;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}
}
