package com.swea.d3;

import java.util.*;
import java.io.*;

public class Solution_5642_d3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int sum=0;
			for (int i = 0; i < N; ++i) {
				sum += arr[i];
				if(sum > max) max = sum;
				if(sum < 0) sum = 0;
			}
			System.out.printf("#%d %d",tc,max);
		}
	}

}
