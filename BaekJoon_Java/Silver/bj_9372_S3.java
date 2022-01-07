package silver;

import java.io.*;
import java.util.*;

public class bj_9372_S3 {

	static boolean[] Country;
	static int N, M, arr[][], answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			Country = new boolean[N];
			arr = new int[N][N];
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				arr[from][to] = arr[to][from] = 1;
			}
			bfs();
			System.out.println(answer);
		}

	}

	static void bfs() {
		Queue<Integer> countries = new LinkedList<>();
		countries.offer(0);
		boolean[] isVisited = new boolean[N];
		isVisited[0] = true;
		while (!countries.isEmpty()) {
			int now = countries.poll();
			for (int i = 0; i < N; ++i) {
				if (arr[now][i] == 1 && !isVisited[i]) {
					++answer;
					isVisited[i] = true;
					countries.offer(i);
				}
			}
		}
	}

}