package gold;

import java.io.*;
import java.util.*;

public class bj_14719_G5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < M; ++j) {
			int val = Integer.parseInt(st.nextToken());
			int i = N - 1;
			while (val-- > 0) {
				map[i--][j] = 1;
			}
		}
		int answer = 0;
		for (int i = N - 1; i >= 0; --i) {
			int start = -1, cnt = 0;
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					if (start != -1) {
						++cnt;
					}
				} else {
					if (start == -1) {
						start = j;
					} else {
						if (cnt == 0) {
							start = j;
						} else {
							answer += cnt;
							cnt = 0;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
