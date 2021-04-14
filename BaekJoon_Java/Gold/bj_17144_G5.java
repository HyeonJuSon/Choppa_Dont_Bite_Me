package bj.gold;

import java.io.*;
import java.util.*;

public class bj_17144_G5 {
	static class Pos {
		int x, y, w;

		public Pos(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	static int R, C, T, map[][];
	static final int airCleaner = -1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Pos> ac;
	static ArrayList<Pos> dusts;
	static int[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력구간
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dusts = new ArrayList<>();
		ac = new ArrayList<>();
		check = new int[R][C];
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == airCleaner) {
					ac.add(new Pos(i, j,map[i][j])); // 공청기 위치를 담는다.
				}
				else if (map[i][j] > 0) {
					dusts.add(new Pos(i, j,map[i][j]));// 미세먼지위치를 담는다.
				}
			}
		}
		int ans = 0;
		// T초 동안 시행한다.
		for (int i = 0; i < T; ++i) {
			// 1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다
			moveDust();
			// 2. 공청기가 작동한다.
			actAirCleaner();
			// 3. dusts 리스트를 갱신한다.
			ans = updateDustsPosandSum();
		}
		System.out.println(ans);
	}
	
	private static int updateDustsPosandSum() {
		dusts = new ArrayList<>();
		int sum = 0;
		for(int i=0;i<R;++i) {
			for(int j=0;j<C;++j) {
				if(map[i][j] > 0) {
					dusts.add(new Pos(i,j,map[i][j]));
					sum += map[i][j];
					check[i][j] = 1;
				}
			}
		}
		return sum;
	}

	private static void actAirCleaner() {
		// upper ac[0]
		Pos upper = ac.get(0);
		// 0,0 -> upper.x - 1, upper.y 까지 내린다.
		for(int i= upper.x-1; i > 0 ; --i) map[i][0] = map[i-1][0];
		// 0,C-1 -> 0,0 까지
		for(int j=0; j<C-1; ++j) map[0][j]=map[0][j+1];
		// upper.x , C-1 -> 0,C-1까지
		for(int i=0;i<upper.x;++i) map[i][C-1] = map[i+1][C-1];
		// upper.x, upper.y -> upper.x, C-1 까지 
		for(int j=C-1;j > upper.y+1;--j) map[upper.x][j] = map[upper.x][j-1];
		map[upper.x][upper.y+1] = 0;

		// lower ac[1]
		Pos lower = ac.get(1);
		// lower.x+1,0 -> R-1,0
		for(int i=lower.x+1;i<R-1;++i) map[i][0]=map[i+1][0];
		// R-1,0 -> R-1,C-1 o
		for(int j=0; j<C-1;++j) map[R-1][j] = map[R-1][j+1];
		// R-1,C-1 -> lower.x +1, C-1 o
		for(int i=R-1; i>lower.x;--i) map[i][C-1] =map[i-1][C-1];
		// lower.x, C-1 -> lower.x, lower.y_1
		for(int j=C-1; j>lower.y+1; --j) map[lower.x][j]=map[lower.x][j-1];
		map[lower.x][lower.y+1] = 0;
	}

	private static void moveDust() {
		for (Pos dust : dusts) {
			int cnt = 0;
			int val = dust.w;
			int spread = val/5;
			for (int d = 0; d < 4; ++d) {
				int nx = dust.x + dx[d];
				int ny = dust.y + dy[d];
				if(isInArea(nx, ny) && map[nx][ny] != airCleaner) { // 영역안이고, 공청기아니면
					map[nx][ny] += spread; // 확산해주고
					cnt++; // 카운트
				}
			}
			map[dust.x][dust.y] -= (val/5) * cnt; 
		}
	}
	
	static boolean isOriDusts(int x, int y) {
		for(Pos dust : dusts) {
			if(x==dust.x && y == dust.y) return true; 
		}
		return false;
	}
	
	static boolean isInArea(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
}
