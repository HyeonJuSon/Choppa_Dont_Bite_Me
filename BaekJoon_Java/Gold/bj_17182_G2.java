import java.io.*;
import java.util.*;

public class bj_17182_G2 {
	static int[][] map;
	static int N, answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		boolean[] isVisited = new boolean[N];
		isVisited[K] = true;
		dfs(isVisited, K, 0,0);
		System.out.println(answer);
	}

	static void dfs(boolean[] isVisited, int start, int sum, int depth) {

		if(depth == N-1) {
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=0;i<N;++i) {
			if(isVisited[i])continue;
			isVisited[i] = true;
			dfs(isVisited, i, sum + map[start][i], depth+1);
			isVisited[i] = false;
		}
	}

}
