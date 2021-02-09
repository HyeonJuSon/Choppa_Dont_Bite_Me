package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1일차Flatten_구미_4_손현주 {
	public static void main(String[] args) throws Exception {
		// IO
		System.setIn(new FileInputStream("res/Input_bj_1일차Flatten.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// test case
		final int T = 10;
		// dump count
		int dump = 0;
		// boxes array
		int[] boxes = new int[100];
		// looping
		for (int tc = 1; tc <= T; ++tc) {
			dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			// input box value
			for (int x = 0; x < 100; x++) {
				boxes[x] = Integer.parseInt(st.nextToken());
			}
			// dumping
			Arrays.sort(boxes);
			for(int i=0;i<dump;++i) {
				boxes[0]++;
				boxes[99]--;
				Arrays.sort(boxes);
			}
//			while (true) {
//				// 정렬
//				Arrays.sort(boxes);
//				// 덤프끝
//				if(dump==0) break;
//				// 덤프 중 평탄화 끝나는 지 체크
//				if(boxes[99]-boxes[0] <=1)
//					break;
//				// 덤핑  
//				boxes[0]++; //제일 낮음
//				boxes[99]--; // 제일 높음
//				// 덤프카운트 감소
//				dump--;
//			}
			System.out.println("#"+tc+" "+ (boxes[99]-boxes[0]));
		}
	}
}
