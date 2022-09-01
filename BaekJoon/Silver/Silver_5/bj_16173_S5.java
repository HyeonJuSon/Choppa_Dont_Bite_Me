package silver;

import java.io.*;
import java.util.*;

public class bj_16173_S5 {

	static int[][] dir = { { 0, 1 }, { 1, 0 } };
	static int[][] map,check;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		process();
		System.out.println(check[N - 1][N - 1] > 0 ? "HaruHaru" : "Hing");
	}

	static void process() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][N];
		isVisited[0][0] = true;
		check[0][0]=1;
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 2; ++d) {
				int dist = map[now[0]][now[1]];
				int nx = now[0] + dir[0][d]*dist;
				int ny = now[1] + dir[1][d]*dist;
				if(isBoundary(nx,ny)&&!isVisited[nx][ny]) {
					isVisited[nx][ny]=true;
					++check[nx][ny];
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
