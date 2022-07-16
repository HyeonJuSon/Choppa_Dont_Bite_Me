import java.io.*;
import java.util.*;

public class bj_20058_G4 {

	static int N, Q, map[][], copyMap[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (1 << N); // 2^N
		map = new int[N][N];
		copyMap = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Q; ++i) {
			process(Integer.parseInt(st.nextToken()));
		}
		System.out.println(getSum());
		System.out.println(getTotalIces());
	}

	static void process(int Len) {
		int L = (1 << Len);
		for (int i = 0; i < N; i += L) {
			for (int j = 0; j < N; j += L) {
				rotate(i, j, L);
			}
		}
		melt();
	}

	public static void rotate(int x, int y, int L) {
		for (int i = 0; i < L; ++i) {
			for (int j = 0; j < L; ++j) {
				copyMap[i][j] = map[x + L - 1 - j][y + i];
			}
		}
		for (int i = 0; i < L; ++i) {
			for (int j = 0; j < L; ++j) {
				map[x + i][y + j] = copyMap[i][j];
			}
		}
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static void melt() {
		Queue<int[]> melts = new LinkedList<>();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 0)
					continue;
				int cnt = 0;
				for (int d = 0; d < 4; ++d) {
					int nx = i + dir[0][d];
					int ny = j + dir[1][d];
					if (isBoundary(nx, ny) && map[nx][ny] > 0) {
						++cnt;
					}
				}
				if (cnt < 3)
					melts.offer(new int[] { i, j });
			}
		}
		while (!melts.isEmpty()) {
			int[] current = melts.poll();
			--map[current[0]][current[1]];
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static int getSum() {
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	static int getTotalIces() {
		int cnt = 0;
		boolean[][] isVisited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!isVisited[i][j] && map[i][j] > 0) {
					cnt = Math.max(cnt, dfs(i, j, isVisited));
				}
			}
		}
		return cnt;
	}

	static int dfs(int i, int j, boolean[][] isVisited) {
		isVisited[i][j] = true;
		int cnt = 1;
		for (int d = 0; d < 4; ++d) {
			int nx = i + dir[0][d];
			int ny = j + dir[1][d];
			if (isBoundary(nx, ny) && !isVisited[nx][ny] && map[nx][ny] > 0) {
				cnt += dfs(nx, ny,isVisited);
			}
		}
		return cnt;
	}
}
