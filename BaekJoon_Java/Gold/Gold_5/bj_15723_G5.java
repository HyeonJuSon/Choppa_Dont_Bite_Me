package gold;

import java.io.*;
import java.util.*;

public class bj_15723_G5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 26;
		int[][] map = new int[max + 1][max + 1]; // max - 26
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = st.nextToken().charAt(0) - 97;
			st.nextToken();
			int to = st.nextToken().charAt(0) - 97;
			map[from][to] = 1;
		}
		for (int k = 0; k <= max; ++k) {
			for (int i = 0; i <= max; ++i) {
				for (int j = 0; j <= max; ++j) {
					if (map[i][k] == 1 && map[k][j] == 1)
						map[i][j] = 1;
				}
			}
		}
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = st.nextToken().charAt(0) - 97;
			st.nextToken();
			int to = st.nextToken().charAt(0) - 97;
			if (map[from][to] == 1)
				System.out.println("T");
			else
				System.out.println("F");
		}
	}

}
