package gold;

import java.io.*;
import java.util.*;

public class bj_10159_G3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] up = new int[N][N];
		int[][] down = new int[N][N];

		for (int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			up[from][to] = down[to][from] = 1;
		}

		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (up[i][k] == 1 && up[k][j] == 1)
						up[i][j] = 1;
					if (down[i][k] == 1 && down[k][j] == 1)
						down[i][j] = 1;
				}
			}
		}
		for(int i=0;i<N;++i) {
			int cnt = 0;
			for(int j=0;j<N;++j) {
				if(i==j) continue;
				if(up[i][j]!=1&&down[i][j]!=1) ++cnt;
			}
			System.out.println(cnt);
		}
	}

}
