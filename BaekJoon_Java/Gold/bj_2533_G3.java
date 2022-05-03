package gold;

import java.io.*;
import java.util.*;

public class bj_2533_G3 {

	static int N;
	static ArrayList<Integer>[] map;
	static int[][] dp;
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][2];
		map = new ArrayList[N];
		isVisited = new boolean[N];
		for (int i = 0; i < N; ++i) {
			map[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = null;
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			map[from].add(to);
			map[to].add(from);
		}

		dfs(0);
		System.out.println(Math.min(dp[0][0], dp[0][1]));
	}

	static void dfs(int idx) {
		isVisited[idx] = true;
		dp[idx][0] = 0; // 얼리어답터가 아닌 경우
		dp[idx][1] = 1; // 얼리어답터인경우

		for (int child : map[idx]) {
			if (isVisited[child])
				continue;
			dfs(child);
			dp[idx][0] += dp[child][1];// 자식이 무조건 얼리어답터여야함
			dp[idx][1] += Math.min(dp[child][0], dp[child][1]);// 둘중최소값

		}
	}

}
