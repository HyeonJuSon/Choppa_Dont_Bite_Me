package com.practice.algo.d1;

import java.util.Scanner;

import javax.print.StreamPrintService;

public class example_2056 {

	public static void main(String[] args) {
		/* Input */
		Scanner sc = new Scanner(System.in);
		// testcase
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int val = sc.nextInt();
			// year
			int year = val / 10000;
			val %= 10000;
			// month
			int mon = val / 100;
			val %= 100;
			// day
			int day = val;
			// flag
			boolean flag = true;
			// 1. Check month
			if (mon > 12 || mon < 1)
				flag = false;
			// 2. Check Days
			if (day < 1)
				flag = false;
			else {
				switch (mon) {
				case 2:
					if (day > 28)
						flag = false;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (day > 30)
						flag = false;
					break;
				default:
					if (day > 31)
						flag = false;
					break;
				}
			}
			// 3. Check flag
			if (flag) {
				System.out.printf("#%d %04d/%02d/%02d",tc, year, mon, day);
			} else
				System.out.printf("#%d -1",tc);
			System.out.println();
		}
		sc.close();
	}
}
