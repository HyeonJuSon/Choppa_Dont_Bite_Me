package gold;

import java.io.*;
import java.util.*;

public class bj_1613_G3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] fastest = new int[N + 1][N + 1];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int fast = Integer.parseInt(st.nextToken());
			int late = Integer.parseInt(st.nextToken());
			fastest[fast][late] = -1;
			fastest[late][fast] = 1;
		}
		for (int k = 1; k <= N; ++k) {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (fastest[i][j] != 0)
						continue;
					if (fastest[i][k] == 1 && fastest[k][j] == 1)
						fastest[i][j] = 1;
					if (fastest[i][k] == -1 && fastest[k][j] == -1)
						fastest[i][j] = -1;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int fast = Integer.parseInt(st.nextToken());
			int late = Integer.parseInt(st.nextToken());
			System.out.println(fastest[fast][late]);
		}

	}

}
