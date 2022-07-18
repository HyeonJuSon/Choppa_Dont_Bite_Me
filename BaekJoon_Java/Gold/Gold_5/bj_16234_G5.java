package gold;

import java.util.*;
import java.io.*;

public class bj_16234_G5 {

	static int N, L, R, map[][];
	static boolean isOver, isVisited[][];
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(process());
	}


	static int process() {
		int answer = 0;
		while (true) {
			isOver = true;
			isVisited = new boolean[N][N];
			// 인구이동
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (!isVisited[i][j]) bfs(i, j);
				}
			}
			if (isOver) break;
			++answer;
		}
		return answer;
	}

	static void bfs(int x, int y) {
		Queue<int[]> changes = new LinkedList<>(); // 연합인구수로 바뀔 수
		Queue<int[]> bfsQ = new LinkedList<>();
		bfsQ.add(new int[] { x, y });
		changes.add(new int[] { x, y });
		isVisited[x][y] = true;
		int cnt = 1, sum = map[x][y];

		while (!bfsQ.isEmpty()) {
			int[] now = bfsQ.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];
				if (isBoundary(nx, ny) && !isVisited[nx][ny] && isMovable(now, nx, ny)) {
					isVisited[nx][ny] = true;
					bfsQ.add(new int[] { nx, ny });
					changes.add(new int[] { nx, ny });
					++cnt;
					sum += map[nx][ny];
				}
			}
		}

		if (cnt > 1) {
			int val = sum / cnt;
			while (!changes.isEmpty())
				map[changes.peek()[0]][changes.poll()[1]] = val;
			isOver=false;
		}
	}

	static boolean isMovable(int[] now, int nx, int ny) {
		int dist = Math.abs(map[now[0]][now[1]] - map[nx][ny]);
		return L <= dist && dist <= R;
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
