package silver;

import java.io.*;
import java.util.*;

public class BJ_3187_S2 {

	static int R, C;
	static char map[][];
	static int sumV, sumK;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		sumV = sumK = 0;
		for (int i = 0; i < R; ++i) {
			String input = br.readLine();
			for (int j = 0; j < C; ++j) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='k') ++sumK;
				else if(map[i][j]=='v') ++sumV;
			}
		}

		boolean[][] isVisited = new boolean[R][C];
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (isVisited[i][j])
					continue;
				if (map[i][j] == '#')
					continue;
				isVisited[i][j] = true;
				bfs(i, j, isVisited);
			}
		}
		System.out.println(sumK+" "+sumV);
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static void bfs(int x, int y, boolean[][] isVisited) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		int cntV = 0, cntK = 0;
		if (map[x][y] == 'v')
			++cntV;
		else if (map[x][y] == 'k')
			++cntK;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; ++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];

				if (isBoundary(nx, ny) && !isVisited[nx][ny] && map[nx][ny] != '#') {
					isVisited[nx][ny] = true;
					if (map[nx][ny] == 'v')
						++cntV;
					else if (map[nx][ny] == 'k')
						++cntK;
					q.add(new int[] { nx, ny });
				}
			}
		}
		if(cntV != 0 && cntK!=0){
			if (cntV < cntK) { // 양이 더 많은 경우
				sumV -= cntV;
			} else { // 늑대가 더 많은 혹은 같은 경우
				sumK -= cntK;
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
}
