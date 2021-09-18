package bronze;

import java.io.*;
import java.util.*;

public class bj_2506_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int before = arr[0];
		int score = 1;
		int sum = 0;
		sum += before;
		for (int i = 1; i < N; ++i) {
			if (arr[i] == 1) {
				if (before == 1) {
					sum += ++score;
				} else {
					before = 1;
					score = 1;
					sum += score;
				}
			} else {
				before = 0;
				score = 0;
			}
		}
		System.out.println(sum);
	}

}
