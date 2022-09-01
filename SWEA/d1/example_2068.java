package com.practice.algo.d1;

import java.util.Scanner;

public class example_2068 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int Max = 0;
		int val = 0;

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				val = sc.nextInt();
				if (Max < val)
					Max = val;
			}
			System.out.println("#"+(i+1)+" "+Max);
			Max = 0;
		}
		sc.close();
	}

}
