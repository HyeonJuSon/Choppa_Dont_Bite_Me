package bj.silver;

import java.io.*;
import java.util.*;

public class bj_15656_S3 {
	static int N, M;
	static int[] input;
	static int[] numbers;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		numbers = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);// 오름차순으로해야해서.
		permutation(0);
		System.out.println(sb);
	}

	static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; ++i) sb.append(numbers[i]).append(" ");
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; ++i) {
			numbers[cnt] = input[i];
			permutation(cnt + 1);
		}
	}

}
