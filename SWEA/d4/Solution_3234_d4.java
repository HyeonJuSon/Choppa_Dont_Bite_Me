package com.swea.d4;

import java.util.*;
import java.io.*;

public class swea_d4_3234 {
	static int N, totalCnt;
	static int[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Int(br.readLine());								//테케 입력
		for (int tc = 1; tc <= T; ++tc) {						//테케만큼 반복
			N = Int(br.readLine());								//개수 입력
			totalCnt = 0;										//전체 카운트 초기화
			input = new int[N];									//입력 배열 할당
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i) input[i] = Int(st.nextToken());
			permutation(0, new boolean[N], new int[N]);			//수열생성 호출
			sb.append("#").append(tc).append(" ").append(totalCnt).append('\n');
		}
		System.out.println(sb);									//출력
	}

	static void permutation(int cnt, boolean[] isSelected, int[] nums) {
		if (cnt == N) {											//다뽑았으면 계산
			calculate(0, nums, 0, 0);						
			return;
		}
		for (int i = 0; i < N; ++i) {							//수열 생성
			if (!isSelected[i]) {
				isSelected[i] = true;							
				nums[cnt] = input[i];
				permutation(cnt + 1, isSelected, nums);
				isSelected[i] = false;
			}
		}
	}
																//계산 메소드(부분집합)
	static void calculate(int cnt, int[] nums, int left, int right) {
		if (cnt == N) {											//다 뽑았으면
			++totalCnt;											//카운팅
			return;
		}
		if (left >= right + nums[cnt]) 							//left 값보다 크면 넣어준다.
			calculate(cnt + 1, nums, left, right + nums[cnt]);	//선택시 오른쪽 저울에
		calculate(cnt + 1, nums, left + nums[cnt], right);		//비 선택시 왼쪽 저울에
	}

	static int Int(String s) {									//Int변환 후 반환
		return Integer.parseInt(s);
	}
}
