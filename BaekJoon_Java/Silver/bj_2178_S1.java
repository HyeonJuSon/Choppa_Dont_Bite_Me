package bj.silver;

import java.io.*;
import java.util.*;

public class bj_2178_S1 {
	static int N, M;
	static int[][] map, dist;
	static boolean[][] isVisited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; ++j) {
				map[i][j] = tmp[j] - '0';
			}
		}
		isVisited[0][0] = true;
		bfs(0, 0);
		System.out.println(dist[N-1][M-1]+1);
	}

	static void bfs(int x, int y) {
		Queue<int[]> bfsQueue = new LinkedList<>();
		bfsQueue.add(new int[] {x,y});
		
		while(!bfsQueue.isEmpty()) {
			int[] Pos = bfsQueue.poll();
			
			for (int d = 0; d < 4; ++d) {
				int nx = Pos[0] + dx[d];
				int ny = Pos[1] + dy[d];
				if(isAvailable(nx, ny)) {
					isVisited[nx][ny] = true;
					bfsQueue.offer(new int[] {nx,ny});
					dist[nx][ny]= dist[Pos[0]][Pos[1]]+1;
					
				}
			}
		}
		
		
	}

	static boolean isAvailable(int x, int y) {
		if(x<0 || x>=N || y <0|| y>=M) return false;
		if(map[x][y] ==0 ) return false;
		if(isVisited[x][y]) return false;
		return true;
	}
	
}
