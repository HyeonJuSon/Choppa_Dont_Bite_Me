package com.algo.d2;

import java.io.*;
import java.util.*;

public class Solution_1961_d2 {

	static int[][] base; 	// 원본 배열
	static int[][] after; 	// 임시 배열
	static String[][] show;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		// 1. 입력
		int T = Int(br.readLine()); 		// 테스트 케이스의 수
		for (int tc = 1; tc <= T; ++tc) { 	// 테스트 케이스를 반복
			N = Int(br.readLine()); 		// 배열의 사이즈 N
			base = new int[N][N]; 			// 원본 배열
			after = new int[N][N];			// 임시 배열
			show = new String[N][3]; 		// 90/180/270이 담길 배열
			// 2. 배열 값 셋팅 시작
			for (int i = 0; i < N; ++i) {
				base[i] = new int[N]; 		// 초기화 - 2차원 배열이라서 안하면 안된다.
				show[i] = new String[3];	// 초기화
				st = new StringTokenizer(br.readLine(), " "); // 토큰 설정
				for (int j = 0; j < N; ++j) {
					base[i][j] = Int(st.nextToken()); // 배열 값 셋팅
				}
			}
			// 3. 배열 90, 180, 270 셋팅
			int y = 0; 				// 돌릴 배열의 인덱스
			boolean isFirst= true;			// 처음아니라면 배열을 변경해주는 플래그
			for (int cnt = 0; cnt < 3; cnt++) {
				if(!isFirst) afterCopy();	// 바뀐 배열로 변경
				for (int j = 0; j < N; ++j) {
					String tmp = "";
					y=0;
					for (int i = N - 1; i >= 0; --i) {
						if(isFirst) isFirst = false;
						int val = base[i][j];
						after[j][y++] = val;
						tmp += val;
					}
					show[j][cnt] = tmp;
				}
			}
			sb.append("#").append(tc).append('\n');
			setShow();
		}
		System.out.println(sb);
	}
	// show 배열 셋팅 메소드
	static void setShow() {
		for(int i=0;i<N; ++i) {
			for(int j=0; j<3; ++j) {
				sb.append(show[i][j]).append(" ");
			}
			sb.append('\n');
		}
	}
	// 배열 카피 메소드
	static void afterCopy() {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				base[i][j]=after[i][j];
			}
		}
	}
	// Int형으로 파싱 후 반환 메소드
	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
