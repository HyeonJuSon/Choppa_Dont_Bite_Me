package bj;

import java.io.*;
import java.util.*;

public class bj_15683_G5 {
	static class CCTV {
		int number, x, y;

		public CCTV(int number, int x, int y) {
			this.number = number;
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, cctvCnt, min;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][][] cctvDir = { { { 0 } }, // 더미
			{ { 1 }, { 2 }, { 3 }, { 0 } }, // 1번
			{ { 1, 3 }, { 0, 2 } }, // 2번
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3번
			{ { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } }, // 4번
			{ { 0, 1, 2, 3 } },// 5번
	};
	static CCTV[] cctvList = new CCTV[8]; // 최대 8대

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		int remain = N * M;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5)
					cctvList[cctvCnt++] = new CCTV(map[i][j], i, j);
				else if (map[i][j] == 6)
					remain--;
			}
		}
		min = Integer.MAX_VALUE;

		search(0, remain - cctvCnt, map);
		System.out.println(min);
	}

	static void search(int idx, int remain, int[][] map) {
		// 모든 CCTV 감시 영역 확인이 끝났으면
		if (idx == cctvCnt) {
			// 사각지대 갱신
			min = Math.min(min, remain);
			return;
		}

		int[][] newMap = new int[N][M];//원본에다 수정하면 안되니까 새로만듬
		copy(newMap, map);

		// 각각의 CCTV를 확인
		CCTV c = cctvList[idx];

		// 해당 CCTV가 90도씩 회전하면서 감시
		for (int i = 0; i < cctvDir[c.number].length; ++i) {
			// 해당 CCTV가 감시할 수 있는 방향으로 감시
			int check = 0;
			for(int j = 0; j<cctvDir[c.number][i].length;++j) {
				int dir = cctvDir[c.number][i][j];
				check += observe(c.x, c.y, dir, newMap);
			}
			
			search(idx+1, remain - check, newMap);
			// 다른 방향으로 확인하기 위해 맵 상태를 되돌린다
			copy(newMap, map);
		}
	}
	
	private static int observe(int x, int y, int dir, int[][] map) {
		// 감시 영역 수
		int cnt =0;
		
		while(true) {
			x += dx[dir];
			y += dy[dir];
			
			// 범위를 벗어나거나 벽이 있으면
			if(x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 6) return cnt;
			if((1<=map[x][y] && map[x][y] <=5) || map[x][y] == -1) continue;
			map[x][y]=-1;//방문체크
			cnt++;
		}
	}
	
	private static void copy(int[][] newMap, int[][] map) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}
