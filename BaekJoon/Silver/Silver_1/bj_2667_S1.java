package bj.silver;

import java.io.*;
import java.util.*;

public class bj_2667_S1 {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, map[][];
	static boolean[][] isVisited;
	static Queue<Pos> houses = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 맵의 가로,세로
		map = new int[N][N];// 맵배열
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < N; ++j) {
				map[i][j] = tmp.charAt(j) - '0';
				if (map[i][j] == 1)
					houses.offer(new Pos(i, j));
			}
		}
		int houseCnt = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		while (!houses.isEmpty()) {
			Pos current = houses.poll();
			if(isVisited[current.x][current.y]) continue; 
			cnt = 1;
			isVisited[current.x][current.y]=true;
			dfs(current, houseCnt++);
			q.offer(cnt);
		}
		System.out.println(houseCnt);
		while(!q.isEmpty()) System.out.println(q.poll());
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;
	static void dfs(Pos p, int houseCnt) {

		for (int d = 0; d < 4; ++d) {
			int nx = p.x + dx[d];
			int ny = p.y + dy[d];
			if(isAvailable(nx,ny)&&!isVisited[nx][ny]&&map[nx][ny]==1) {
				isVisited[nx][ny] = true;
				dfs(new Pos(nx,ny),houseCnt);
				cnt++;
			}
		}
	}

	static boolean isAvailable(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
