package silver;

import java.io.*;
import java.util.*;

public class bj_2583_S1 {

	static int M, N, K;
	static int[][] map;
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}

	static int bfs(int x, int y, boolean[][] isVisited) {
		isVisited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];
				if (isBoundary(nx, ny) && map[nx][ny] == 0 && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true;
					++cnt;
					q.add(new int[] {nx,ny});
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		// 1. 맵에 사각형 크기만큼 마킹한다.
		for (int k = 0; k < K; ++k) {
			st = new StringTokenizer(br.readLine(), " ");
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			for (int i = sx; i < ex; ++i) {
				for (int j = sy; j < ey; ++j) {
					map[i][j] = 1;
				}
			}
		}
		// 2. 영역별 카운트.
		boolean[][] isVisited = new boolean[M][N];
		PriorityQueue<Integer> answer = new PriorityQueue<Integer>();
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				if (isVisited[i][j])
					continue;
				if (map[i][j] == 0) {
					answer.add(bfs(i, j, isVisited));
				}
			}
		}
		// 3. 영역별 카운트를 오름차순으로 출력
		System.out.println(answer.size());
		while(!answer.isEmpty()) {
			System.out.print(answer.poll()+" ");
		}
	}

}
