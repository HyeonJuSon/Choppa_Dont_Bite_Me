package bj;

import java.io.*;
import java.util.*;

public class bj_14889_S3 {
	static int N, R;// 4C2
	static int[][] input;
	static boolean[] isVisited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = N / 2; // N(=짝수)/2명으로 팀을 나눈다.
		input = new int[N][N];
		isVisited = new boolean[N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0, 0);
		System.out.println(min);
	}

	static void combination(int start, int idx, int cnt) {
		if (cnt == R) {
			int teamStart = 0, teamLink = 0;
			for (int i = 0; i < N - 1; ++i) {
				for (int j = i + 1; j < N; ++j) {
					if (isVisited[i] && isVisited[j])
						teamStart += input[i][j] + input[j][i];
					else if(!isVisited[i] && !isVisited[j])
						teamLink += input[i][j]+input[j][i];
				}
			}
			min = Math.min(min, Math.abs(teamStart- teamLink));
			return;
		}

		for (int i = start; i < N; ++i) {
			isVisited[i] = true;
			combination(i + 1, idx + 1, cnt + 1);
			isVisited[i] = false;
		}
	}
}
