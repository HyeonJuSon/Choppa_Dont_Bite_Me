import java.io.*;
import java.util.*;

public class BJ_2096_G5 {

	static class Block {
		int val;
		int max;
		int min;

		Block(int val) {
			this.val = val;
			this.max = val;
			this.min = Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 3;
		Block[][] map = new Block[N][M];

		StringTokenizer st = null;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = new Block(Integer.parseInt(st.nextToken()));
				if (i == 0)
					map[i][j].min = map[i][j].val;
			}
		}
		int[][] dir = { { 1, 1, 1 }, { -1, 0, 1 } };
		for (int i = 0; i < N - 1; ++i) {
			for (int j = 0; j < M; ++j) {
				for (int d = 0; d < 3; ++d) {
					int nx = i + dir[0][d];
					int ny = j + dir[1][d];
					if (!isBoundary(nx, ny, N, M))
						continue;
					if (map[nx][ny].max < map[nx][ny].val + map[i][j].max) {
						map[nx][ny].max = map[nx][ny].val + map[i][j].max;
					}
					if (map[nx][ny].min > map[nx][ny].val + map[i][j].min) {
						map[nx][ny].min = map[nx][ny].val + map[i][j].min;
					}
				}
			}
		}
		int max = 0, min = Integer.MAX_VALUE;
		for (int j = 0; j < M; ++j) {
			max = Math.max(max, map[N - 1][j].max);
			min = Math.min(min, map[N - 1][j].min);
		}
		System.out.println(max + " " + min);

	}

	static boolean isBoundary(int x, int y, int N, int M) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
