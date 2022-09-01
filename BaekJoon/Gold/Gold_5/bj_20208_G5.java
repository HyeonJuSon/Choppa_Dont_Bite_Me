import java.io.*;
import java.util.*;

public class bj_20208_G5 {
	static class Pos {
		int x, y, h;

		public Pos(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, H, map[][];
	static Pos startPos;
	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Int(st.nextToken());
		M = Int(st.nextToken());
		H = Int(st.nextToken());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Int(st.nextToken());
				if (map[i][j] == 1)
					startPos = new Pos(i, j, H);
			}
		}

		dfs(startPos.x, startPos.y, M, 0);
		System.out.println(max);
	}

	static int cnt = 0;
	static boolean isFirst = true;
	static int max = Integer.MIN_VALUE;

	static void dfs(int x, int y, int h, int cnt) {
		if (h == 0)
			return; // 체력이 없으면 그만

		if (x == startPos.x && y == startPos.y && !isFirst) {
			max = Math.min(max, cnt);
			return;
		}

		for (int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isAvailable(nx, ny) && !isVisited[nx][ny]) {
				if (isFirst)
					isFirst = false;
				isVisited[nx][ny] = true;
				if (map[nx][ny] == 2) {
					dfs(nx, ny, h - 1 + H, cnt + 1);
				} else
					dfs(nx, ny, h - 1, cnt);
				isVisited[nx][ny] = false;
			}
		}
	}

	static boolean isAvailable(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static void print(int[][] map) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
