package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기_구미_4_손현주 {

	public static void main(String[] args) throws Exception {
		// IO
		System.setIn(new FileInputStream("res/Input_d3_농작물수확하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] ground;
		// 테스트 케이스를 입력받는다.
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스만큼 반복한다.
		for (int tc = 1; tc <= T; ++tc) {
			// 사이즈를 입력받는다.
			int N = Integer.parseInt(br.readLine());
			
			int m = (N-1)/2;
			
//			int sum =0;
//			for(int i=0; i<N; i++) {
//			int tmp = Math.abs(m-i);
//			char[] ch = sc.next().substring(tmp,N-tmp).toCharArray();
//			for(char c : ch) sum += c-'0';
//			
//			}
			
			ground = new int[N][N];
			// 각 농작물의 가치를 입력받는다.
			for (int i = 0; i < N; ++i) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; ++j) {
					ground[i][j] = ch[j] - '0';
				}
			}

			// 계산
			int sum = 0;
			boolean flag = false;
			int start = N / 2;
			int end = N / 2;
			for (int i = 0; i < N; ++i) {
				for (int j = start; j <= end; ++j) {
					sum += ground[i][j];
				}
				if (start == 0)
					flag = !flag;
				if (!flag) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			// 출력한다.
			System.out.println("#" + tc + " " + sum);
		}
	}

}
