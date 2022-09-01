package silver;

import java.io.*;
import java.util.*;

public class bj_4963_S2 {

	static int X, Y, map[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			if (X == 0 && Y == 0)
				break; // 입력 종료
			map = new int[X][Y]; // map
			for(int i=0;i<X;++i) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<Y;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			process();
		}
		System.out.println(sb.toString());
	}

	static void process() {
		boolean[][] isVisited = new boolean[X][Y];
		int cnt = 0;
		for (int i = 0; i < X; ++i) {
			for (int j = 0; j < Y; ++j) {
				if(isVisited[i][j]) continue;
				if (map[i][j] == 1) { // 미방문
					cnt++;
					isVisited[i][j] = true;
					dfs(i, j,isVisited);
				}
			}
		}
		sb.append(cnt).append("\n");
	}

	static int[][] dir = { { -1, -1, -1, 0, 0, 1, 1, 1 }, { -1, 0, 1, -1, 1, -1, 0, 1 } };

	static void dfs(int x, int y, boolean[][] isVisited) {
		for (int d = 0; d < 8; ++d) {
			int nx = x + dir[0][d];
			int ny = y + dir[1][d];
			if(isBoundary(nx,ny)&&!isVisited[nx][ny]&&map[nx][ny]==1) {
				isVisited[nx][ny] = true;
				dfs(nx,ny,isVisited);
			}
		}
	}
	static boolean isBoundary(int x, int y) {
		return 0<=x && x<X&&0<=y && y<Y;
	}
}
