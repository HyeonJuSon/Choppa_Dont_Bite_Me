package com.sweaTestQuestion;

import java.io.*;
import java.util.*;

public class swea_1953_test {
	static class Turnnel {// 터널 클래스를 만든다
		int x, y;// 위치
		int type;// 터널의타입

		public Turnnel(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static int[][][] dir = { // 터널 타입별 이동 방향.
			{ { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, // 1번 상하좌우
			{ { -1, 0 }, { 1, 0 }, { 0, 0 }, { 0, 0 } }, // 2번 상하
			{ { 0, 0 }, { 0, 0 }, { 0, -1 }, { 0, 1 } }, // 3번 좌우
			{ { -1, 0 }, { 0, 0 }, { 0, 0 }, { 0, 1 } }, // 4번 상우
			{ { 0, 0 }, { 1, 0 }, { 0, 0 }, { 0, 1 } }, // 5번 하우
			{ { 0, 0 }, { 1, 0 }, { 0, -1 }, { 0, 0 } }, // 6번 하좌
			{ { -1, 0 }, { 0, 0 }, { 0, -1 }, { 0, 0 } } // 7번 상,좌
	};

	static int N, M, X, Y, L, map[][];
	static final int checked = -1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_t_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());// 테케입력
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// 맵 세로크기
			M = Integer.parseInt(st.nextToken());// 맵 가로크기
			X = Integer.parseInt(st.nextToken());// 뚜껑 세로위치
			Y = Integer.parseInt(st.nextToken());// 뚜껑 가로위치
			L = Integer.parseInt(st.nextToken());// 경과시간
			map = new int[N][M];
			for (int i = 0; i < N; ++i) {// map 입력
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			move();// 이동
			sb.append("#").append(tc).append(" ").append(count()).append('\n');
		}
		System.out.println(sb);
	}

	static void move() {
		Queue<Turnnel> q = new LinkedList<>();
		q.offer(new Turnnel(X, Y, map[X][Y] - 1));
		Queue<Turnnel> next = new LinkedList<>();
		for (int t = 1; t <= L; ++t) {// 시간별로 수행
			if (!next.isEmpty()) {
				while (!next.isEmpty()) {
					q.offer(next.poll());
				}
			}
			while (!q.isEmpty()) {
				Turnnel now = q.poll();
				map[now.x][now.y]=checked; 
				for (int d = 0; d < 4; ++d) {
					int dx = dir[now.type][d][0];
					int dy = dir[now.type][d][1];
					int nx = now.x + dx;
					int ny = now.y + dy;
					if (isAvailable(nx, ny) && isLinked(dx,dy,nx,ny)) {
						next.offer(new Turnnel(nx, ny, map[nx][ny] - 1));// q에추가해주고
					}
				}
			}
		}
	}
	static boolean isLinked(int x, int y, int nx, int ny) {
		int type = map[nx][ny]-1;
		if(y==0) {
			 if(x==-1) {//상
				 if(type == 0 || type == 1 || type == 4 || type == 5) return true;
			 }else if(x==1) {//하
				 if(type == 0 || type == 1 || type == 3 || type == 6) return true;
			 }
		 }else if(x==0) {
			 if(y==-1) {//좌
				 if(type == 0 || type == 2 || type == 3 || type == 4) return true;
			 }else if(y==1) {//우
				 if(type == 0 || type == 2 || type == 5 || type == 6) return true;
			 }
		 }
		return false;
	}

	static boolean isAvailable(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	static int count() {// 남은 개수를 세는 함수
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == checked)
					cnt++;
			}
		}
		return cnt;
	}
}
