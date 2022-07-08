package com.algo;

import java.util.*;

/*
 * >>>>  IDEA  <<<<
 * 1. 	N개의 재료 중에 최소 1개이상을 선택하여
 * 		신맛과 쓴맛의 차를 최소한으로 하는 재료를 뽑는다. => 조합 nCr (r>=1)
 * 2.   기존의 조합을 활용한다.
 */

public class Main_2961_도영이가만든맛있는음식_구미_4_손현주 {
	static int N; 						// 재료의 개수
	static int[][] list; 				// 재료 리스트
	static final int S = 0; 			// 신맛 -> list[][0]
	static final int B = 1;				// 쓴맛 -> list[][1]
	static int min=Integer.MAX_VALUE; 	// 신맛-쓴맛의 차를 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 				// 재료의 개수를 입력받는다.
		list = new int[N][2]; 			// 리스트를 할당
		for (int i = 0; i < N; ++i) { 	// 재료의 신맛,쓴맛 입력
			list[i][S] = sc.nextInt();
			list[i][B] = sc.nextInt();
		}
		search(0, 0, 1, 0); 			// 탐색 시작
		System.out.println(min); 		// 최소 차를 출력
		sc.close();
	}
	
	static void search(int cnt, int start, int mul, int sum) {
		if (cnt >= 1) min = Math.min(min, Math.abs(mul - sum));				// 재료가 1개이상이면 최소 차 비교&저장
		if (cnt == N) return;												// 카운트가 전체 재료 수가 되면 리턴
		for (int i = start; i < N; ++i) 									// 1,2,3 이면 1,2 / 1,3 / 2,3 
			search(cnt + 1, i + 1, mul * list[i][S], sum + list[i][B]);
	}
}
/*
4
1 7
2 6
3 8
4 9
*/