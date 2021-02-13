package com.algo.d2;

import java.util.*;

public class swea_1984_d2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; ++tc) {
			int[] arr = new int[10];
			int sum =0;
			for(int i=0; i<10;++i) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			Arrays.sort(arr);
			sum -= (arr[0]+arr[9]);
			double avg = sum / 8.0;
			System.out.printf("#%d %d\n",tc, Math.round(avg));
		}	
		sc.close();
	}

}
