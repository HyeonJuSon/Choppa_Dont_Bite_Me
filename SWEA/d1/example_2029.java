package com.practice.algo.d1;

import java.util.Scanner;

public class example_2029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a, b;

		for (int i = 0; i < T; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println("#"+(i+1)+" "+a/b +" "+a%b);
		}
		
		sc.close();
	}

}
