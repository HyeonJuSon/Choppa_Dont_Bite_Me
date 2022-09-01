package silver;

import java.io.*;
import java.util.*;

public class bj_2468_S1 {

	static int N, map[][], maxHeight, maxCnt = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		maxHeight = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);// 최대 높이를 미리 저장해둔다.
			}
		}
		process();
		System.out.println(maxCnt);
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static void process() {
		// 1.물높이보다 큰거만 영역을 찾는다.
		for (int h = 0; h < maxHeight; ++h) {
			int cnt = 0;
			boolean[][] isVisited = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (!isVisited[i][j] && map[i][j] > h) {
						isVisited[i][j] = true;
						cnt++;
						dfs(h,i,j,isVisited);
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
	}
	
	static void dfs(int h, int x, int y, boolean[][] isVisited) {
		for(int d= 0; d<4;++d) {
			int nx = x+dir[0][d];
			int ny= y+dir[1][d];
			if(isBoundary(nx,ny) && !isVisited[nx][ny] && map[nx][ny] > h) {
				isVisited[nx][ny] = true;
				dfs(h,nx,ny,isVisited);
			}
		}
	}
	
	static boolean isBoundary(int x, int y ) {
		return 0<=x && x<N && 0<=y && y<N;
	}
}
