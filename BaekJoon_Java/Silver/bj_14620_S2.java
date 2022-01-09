package silver;

import java.io.*;
import java.util.*;

public class bj_14620_S2 {

	static int N, value[][], min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		value = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				value[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		process();
		System.out.println(min);
	}

	static void process() {
		comb(0, new boolean[N * N], new int[3]);
	}

	static int[][] dir = { { 0, -1, 1, 0, 0 }, { 0, 0, 0, -1, 1 } };

	static void comb(int cnt, boolean[] isVisited, int[] input) {
		if (cnt == 3) {
			int val = 0; // 비용 계산
			boolean isPossible = true; // 겹침 계산
			int[][] map = new int[N][N]; // 맵에 맵핑
			root: for (int i = 0; i < 3; ++i) {
				int x = input[i] / N;
				int y = input[i] % N;
				if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
					isPossible = false;
					break root;
				}
				for (int d = 0; d < 5; ++d) {
					int nx = x + dir[0][d];
					int ny = y + dir[1][d];
					if (map[nx][ny] != 0) {
						isPossible = false;
						break root;
					}
					map[nx][ny]++;
					val += value[nx][ny];
				}
			}
			// 최소 비용 계산
			if (isPossible)
				min = Math.min(min, val);
			return;
		}
		for (int i = 0; i < N * N; ++i) { // 범위는 테두리 제외 안쪽
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			input[cnt] = i;
			comb(cnt + 1, isVisited, input);
			isVisited[i] = false;
		}
	}
}
