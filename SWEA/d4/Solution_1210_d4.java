package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2일차Ladder1_구미_4_손현주 {
	static int[] di = {0,0,-1};
	static int[] dj = {-1,1,0}; // 좌우상
	public static void main(String[] args) throws Exception {
		// IO
		System.setIn(new FileInputStream("res/Input_d4_2일차Ladder1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 사다리를 저장할 배열
		int[][] Ladder = new int[100][100];
		// 테스트 케이스 10번
		for (int tc = 0; tc < 10; ++tc) {
			// 방문 체크 배열
			boolean[][] check = new boolean[100][100];
			// 테스트 케이스 번호 입력
			int T = Integer.parseInt(br.readLine());
			// 사다리 배열 입력
			for (int i = 0; i < 100; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; ++j) {
					Ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 저장 확인용
//			for(int[] a : Ladder) System.out.println(Arrays.toString(a));
			// 도착 지점 탐색
			int exitY = 0;
			int exitX = 99;
			for (int j = 0; j < 100; ++j) {
				if (Ladder[exitX][j] == 2) {
					exitY = j;
					break;
				}
			}
			// 경로 탐색
			int dir = 1;// 1 상 2 하(사용안됌) 3 좌 4 우 - default 상
			while (exitX >0) {
				
				check[exitX][exitY] = true;
//				for(int d=0; d<3; d++) {
//					int ni = exitX+di[d];
//					int nj=exitY+dj[d];
//					if(0<=ni&&ni<N && 0 <=nj&&nj<N && data[ni][nj]==1) {
//						Ladder[ni][nj]=Ladder[i][j]-1;
//					}
//				}
				dir = 1;
				// 좌측 검사
				if (exitY - 1 >= 0 ) {
					if (Ladder[exitX][exitY - 1] == 1 && check[exitX][exitY - 1] == false) {
						dir = 3;
					}
				}
				if(exitY+1 < 100) {
					// 우측검사
					if (Ladder[exitX][exitY + 1] == 1 && check[exitX][exitY + 1] == false) {
						dir = 4;
					}
				}
				switch (dir) {
				case 1:// 상
					if (check[exitX - 1][exitY] == false && (exitX - 1) >= 0)
						exitX--;
					break;
				case 3:// 좌
					if (check[exitX][exitY - 1] == false && (exitY - 1) >= 0)
						exitY--;
					break;
				case 4:// 우
					if (check[exitX][exitY + 1] == false && (exitY + 1) < 100)
						exitY++;
					break;
				}
			}
			System.out.println("#" + T + " " + exitY);
		}

	}

}
