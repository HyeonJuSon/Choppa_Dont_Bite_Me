package com.algo.d2;

import java.io.*;
import java.util.*;

public class Solution_1959_d2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i)
				A[i] = stoi(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; ++i)
				B[i] = stoi(st.nextToken());

			boolean isB = Math.max(N, M) == M ? true : false;
			int max = 0;
			int start = 0;
			while (true) {
				int sum = 0;
				if (isB) {
					for (int i = 0; i < N; ++i) sum += B[i+start] * A[i];
					max = Math.max(sum, max);
					if (start + N >= M) break;
				} else {
					for (int i = 0; i < M; ++i) sum += A[i+start] * B[i];
					max = Math.max(sum, max);
					if (start + M >= N) break;
				}
				start++;
			}
			sb.append("#" + tc + " ").append(max).append('\n');
		}
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
