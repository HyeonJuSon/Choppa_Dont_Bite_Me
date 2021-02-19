package com.sweaTestQuestion;

import java.util.*;
import java.io.*;

public class swea_4012 {
	static int[][] synergy; // 시너지 값 배열
	static int[] A; // 조합에서 뽑은애들을 넣어줄 배열
	static int[] B; // 선택 여부 배열
	static int N, min; // 재료의 개수, 두 음식의 최소 차이값

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Int(br.readLine()); // 테케를 입력받는다.
		for (int tc = 1; tc <= T; ++tc) { // 테케 수 만큼 반복한다.
			N = Int(br.readLine()); // 재료의 개수를 입력받는다.
			min = Integer.MAX_VALUE; // min값 초기화
			synergy = new int[N][N]; // 시너지 배열 할당.
			A = new int[N / 2]; // 선택값 넣을 배열 할당.
			B = new int[N / 2]; // 선택 여부 배열 할당.
			for (int i = 0; i < N; ++i) { // 시너지 값들을 입력받는다.
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					synergy[i][j] = Int(st.nextToken());
				}
			}
			search(0, 0); // 탐색을 시작한다.
			sb.append("#").append(tc).append(" ").append(min).append('\n');
		}
		System.out.println(sb);
	}

	static void calculate() {
		int sumA = 0, sumB = 0;
		for (int i = 0; i < N / 2; ++i) {
			for (int j = 0; j < N / 2; ++j) {
				if (i != j) {
					sumA += synergy[A[i]][A[j]];
					sumB += synergy[B[i]][B[j]];
				}
			}
		}
		// 다 더해졌으면 더한 값의 차를 구하고, min과 비교하여 넣어준다.
		min = Math.min(min, Math.abs(sumA - sumB));
	}

	static void partitioning() {
		int[] tmp = new int[N];
		for (int i = 0; i < N / 2; ++i) {
			tmp[A[i]] = -1;
		}
		int index = 0;
		for (int i = 0; i < N; ++i) {
			if (tmp[i] == -1)
				continue;
			else {
				B[index++] = i;
			}
		}

	}

	static void search(int cnt, int start) {
		if (cnt == N / 2) { // 기저 조건, N개중에 N/2뽑는다.
			partitioning(); // A/B그룹을 나누어준다.
			calculate(); // 계산해준다.
			return;
		}

		for (int i = start; i < N; ++i) {
			A[cnt] = i; // 뽑은 숫자를 배열에 넣어주고
			search(cnt + 1, i + 1); // 재탐색한다.
		}
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
