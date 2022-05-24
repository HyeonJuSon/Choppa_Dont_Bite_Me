package gold;

import java.io.*;
import java.util.*;

public class BJ_14002_G4 {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		binarySearch(N);

	}

	static void binarySearch(int N) {
		int[] dp = new int[N];
		int[] answer = new int[N];
		int max = 1;
		Arrays.fill(dp, 1);
		Arrays.fill(answer, -1);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					answer[i] = j;
				}
			}
		}
		int idx = 0;
		for (int i = 0; i < N; ++i) {
			if (dp[i] > max) {
				max = dp[i];
				idx = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (idx != -1) {
			sb.insert(0, arr[idx] + " ");
			idx = answer[idx];
		}
		System.out.println(max);
		System.out.println(sb);
	}
}
