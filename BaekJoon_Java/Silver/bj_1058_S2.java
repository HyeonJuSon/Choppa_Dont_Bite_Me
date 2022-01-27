package silver;

import java.io.*;
import java.util.*;

public class bj_1058_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; ++i) {
			String val = br.readLine();
			for (int j = 0; j < N; ++j) {
				arr[i][j] = val.charAt(j) == 'Y' ? 1 : 987654321;
			}
		}
		int max = 0;
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (i == k || i == j || j == k)
						continue;
					arr[i][j] = Math.min(arr[i][j],arr[i][k] + arr[k][j]);
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			int val = 0;
			for (int j = 0; j < N; ++j) {
				if (i == j)
					continue;
				if (arr[i][j] <= 2)
					val++;
			}
			max = Math.max(max, val);
		}

		System.out.println(max);
	}

}
