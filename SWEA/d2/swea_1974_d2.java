package com.algo.d2;

import java.io.*;
import java.util.*;

public class swea_1974_d2 {
	static int[][] sdoku; // 스도쿠 값을 담을 배열
	static final int N = 9; // 스도쿠의 길이
	static final int total = 45; // 1~9 더하면 45
	static final int[] di = {-1,-1,-1,0,0,0,1,1,1}; // 8방
	static final int[] dj = {-1, 0,1,-1,0,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Int(br.readLine()); // 테스트 케이스 수를 입력받는다.
		for (int tc = 1; tc <= T; ++tc) { // 테스트 케이스 수 만큼 반복한다.
			sdoku = new int[N][N]; // 스도쿠 배열 할당
			int col_sum = 0; // 열의 합(상에서 하로 우측으로 가면서 검사)
			int row_sum = 0; // 행의 합(좌에서 우로 내려가면서 검사)
			int map_sum = 0; // 각 블록의 합
			boolean isError = false; // 제대로 되어있는지 여부 검사
			for (int x = 0; x < N; ++x) { // 9*9 스도쿠 값을 입력받는다.
				sdoku[x] = new int[N]; // 각 행별 할당
				st = new StringTokenizer(br.readLine(), " "); // 토큰 입력
				for (int y = 0; y < N; ++y) {
					sdoku[x][y] = Int(st.nextToken());
					row_sum += sdoku[x][y]; // 행 검사를 위한 합
				}
				if (row_sum != total) { // 한줄당 합이 안나오면 잘못된 것.
					isError = true;
				}
				row_sum = 0;
			}
		
			// 열 검사도 추가로 해야 한다.
			if (!isError) {
				for (int y = 0; y < N; ++y) {
					for (int x = 0; x < N; ++x) {
						col_sum += sdoku[x][y];
					}
					if (col_sum != total) {
						isError = true;
						break;
					}
					col_sum = 0;
				}
			}
			
			if(!isError) {
				for(int m=1; m<N; m=m+3) {
					for(int n=1; n<N; n=n+3) {
						map_sum =0;
						for(int d= 0; d<9;d++) {
							int ni = m+di[d];
							int nj = m+dj[d];
							map_sum += sdoku[ni][nj];
						}
						if(map_sum != total) {
							isError=true;
							break;
						}
						
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(isError ? "0" : "1").append('\n');
		}
		System.out.println(sb);
	}

	// Int로 반환해준다
	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
