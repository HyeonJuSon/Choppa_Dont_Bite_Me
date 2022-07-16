package gold;

import java.io.*;
import java.util.*;

public class bj_1956_G4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int INF = 987654321;
		for(int i=0;i<N;++i) Arrays.fill(map[i], INF);
		for(int i=0;i<T;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			map[from][to]=Math.min(map[from][to], val);
		}
		
		for(int k=0;k<N;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		int min = INF;
		for(int i=0;i<N;++i) {
			min = Math.min(map[i][i], min);
		}
		System.out.println(min == INF ? -1 : min);
	}

}
