package gold;

import java.io.*;
import java.util.*;

public class bj_11404_G4 {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for(int j=0;j<N;++j) {
				map[i][j] = i==j ? 0 : INF;
			}
		}
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int val = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(map[from][to], val);
		}
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j]==987654321)
					System.out.print(0 + " ");
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
