package com.practice.algo.d1;

import java.util.Scanner;

public class example_2058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 하나의 숫자를 입력받는다.
		int val = sc.nextInt();
		sc.close();
		// 1<=n <=9999
		int sum = 0;// 합계를 저장할 변수
		while (val > 0) {
			if (val >= 1000) {
				sum += val / 1000;
				val %= 1000;
			} else if (val >= 100) {
				sum += val / 100;
				val %= 100;
			} else if (val >= 10) {
				sum += val / 10;
				val %= 10;
			} else {
				sum += val;
				val = 0;
			}
		}
		System.out.println(sum);
	}

}
