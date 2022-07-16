package gold;

import java.io.*;
import java.util.*;

public class bj_1600_G4 {

	static class Monkey {
		int x, y;
		int dist;
		int kCount;

		public Monkey(int x, int y, int dist, int kCount) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.kCount = kCount;
		}

	}

	static int[][] basic = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
	static int[][] horse = { { -2, -2, -1, -1, 1, 1, 2, 2 }, { -1, 1, -2, 2, -2, 2, -1, 1 } };
	static int K, map[][], W, H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Monkey> q= new LinkedList<>();
		q.add(new Monkey(0,0,0,K));
		boolean[][][] isVisited = new boolean[K+1][H][W];
		isVisited[K][0][0]=true;
		boolean isPossible=false;
		while(!q.isEmpty()) {
			Monkey now = q.poll();
			if(now.x==H-1 && now.y==W-1) {
				System.out.println(now.dist);
				isPossible=true;
				break;
			}
			
			for(int d=0;d<4;++d) {
				int nx=now.x+basic[0][d];
				int ny = now.y+basic[1][d];
				if(isBoundary(nx,ny)&&!isVisited[now.kCount][nx][ny]&&map[nx][ny]!=1) {
					isVisited[now.kCount][nx][ny]=true;
					q.add(new Monkey(nx,ny,now.dist+1, now.kCount));
				}
			}
			
			if(now.kCount>0) {
				for(int d=0;d<8;++d) {
					int nx= now.x+horse[0][d];
					int ny = now.y+horse[1][d];
					if(isBoundary(nx,ny)&&!isVisited[now.kCount-1][nx][ny]&&map[nx][ny]!=1) {
						isVisited[now.kCount-1][nx][ny]=true;
						q.add(new Monkey(nx,ny,now.dist+1, now.kCount-1));
					}
				}
			}
		}
		if(!isPossible) System.out.println(-1);
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}
