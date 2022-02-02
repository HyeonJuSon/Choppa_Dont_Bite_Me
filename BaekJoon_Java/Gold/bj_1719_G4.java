package gold;

import java.io.*;
import java.util.*;

public class bj_1719_G4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dist = new int[N][N];
		int[][] answer = new int[N][N];
		final int INF = 987654321;
		for (int i = 0; i < N; ++i) {
			Arrays.fill(dist[i], INF);
			dist[i][i]=0;
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int val = Integer.parseInt(st.nextToken());
			dist[from][to] = dist[to][from] = val;
			answer[from][to] = to;
			answer[to][from] = from;
		}

		for (int k = N-1; k >=0 ; --k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						answer[i][j] = k;
					}
				}
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i==j)
					System.out.print("- ");
				else {
					int k = j;
					while(answer[i][k]!=k) {
						k = answer[i][k];
					}
					System.out.print(answer[i][k]+1 + " ");
				}
			}
			System.out.println();
		}
	}

}
