package bj.silver;

import java.io.*;
import java.util.*;

public class bj_15652_S3 {
	static int N, M;
	static int[] input;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N + 1];

		permutation(1, 0);
		System.out.println(sb);
	}

	static void permutation(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; ++i) {
				sb.append(input[i]).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i <= N; ++i) {
			input[cnt] = i;
			permutation(i, cnt + 1);
		}
	}
}
