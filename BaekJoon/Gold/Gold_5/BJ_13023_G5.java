package gold;

import java.io.*;
import java.util.*;

public class BJ_13023_G5 {

	static int N, cnt;
	static boolean[] isVisited;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		for (int i = 0; i < N; ++i) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}

		boolean success = false;
		for (int i = 0; i < N; ++i) { // start
			isVisited = new boolean[N];
			cnt = 0;
			dfs(i, 1);
			if (cnt == 5) {
				success = true;
				break;
			}
		}
		System.out.println(success ? 1 : 0);
	}

	static void dfs(int start, int c) {
		if (c == 5) {
			System.out.println(1);
			System.exit(0);
		}
		isVisited[start] = true;
		for (int next : adjList[start]) {
			if (!isVisited[next])
				dfs(next, c + 1);
		}
		isVisited[start] = false;
	}
}
