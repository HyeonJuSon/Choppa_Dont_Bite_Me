package bj;

import java.io.*;
import java.util.*;

public class bj_13300_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt = 0; // 방 개수
		int[][] classes = new int[7][2];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			classes[grade][sex]++;
		}

		for (int i = 1; i < 7; ++i) {
			for (int j = 0; j < 2; ++j) {
				if (classes[i][j] != 0) {
					cnt += classes[i][j] / k;
					if (classes[i][j] % k != 0)
						cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
