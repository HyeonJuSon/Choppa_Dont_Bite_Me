package silver;

import java.io.*;
import java.util.*;

public class bj_16926_S2 {

	static int N, M, R, map[][];
	static int[][] dir = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } };// 우 하 좌 상

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rotation();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void rotation() {
		int groupCnt = Math.min(N, M) / 2;
		for (int r = 0; r < R; ++r) {
			for (int g = 0; g < groupCnt; ++g) {
				int[] pos = { g, g }; // group의 시작 위치는 (0,0) -> (1,1) -> (2,2) ...
				int startVal = map[pos[0]][pos[0]]; // 시작 위치의 값을 보관
				for (int d = 0; d < 4; ++d) {
					int nx = pos[0] + dir[0][d];
					int ny = pos[1] + dir[1][d];
					if (isBoundary(nx, ny, g)) {
						map[pos[0]][pos[1]] = map[nx][ny];
						pos[0] = nx;
						pos[1] = ny;
						--d;
					}
				}
				map[g + 1][g] = startVal;
			}
		}
	}

	static boolean isBoundary(int x, int y, int startPos) {
		return startPos <= x && x < N - startPos && startPos <= y && y < M - startPos;
	}
}
