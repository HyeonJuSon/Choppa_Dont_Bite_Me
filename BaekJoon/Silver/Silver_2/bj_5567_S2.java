package silver;

import java.io.*;
import java.util.*;

public class bj_5567_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 동기의 수
		int M = Integer.parseInt(br.readLine()); // 리스트 길이
		// 상근이의 학번은 1이다.
		int[][] adj = new int[N][N];
		for (int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adj[from][to] = adj[to][from] = 1;
		}
		// bfs
		Queue<Friend> bfs = new LinkedList<>();
		bfs.add(new Friend(0, 0));
		boolean[][] isVisited = new boolean[N][N];
		boolean[] check = new boolean[N];
		check[0] = true;
		int cnt = 0;
		while (!bfs.isEmpty()) {
			Friend now = bfs.poll();
			if (now.depth >= 2)
				continue;

			for (int j = 0; j < N; ++j) {
				if (isVisited[now.idx][j])
					continue;
				if (adj[now.idx][j] == 1) {
					bfs.add(new Friend(j,now.depth+1));
					if(!check[j]) {
						++cnt;
						check[j]=true;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	static class Friend {
		int idx;
		int depth;

		public Friend(int idx, int depth) {
			this.idx = idx;
			this.depth = depth;
		}
	}
}
