package bronze;

import java.util.Scanner;

public class bj_2576_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val = 0, sum = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < 7; ++i) {
			val = sc.nextInt();
			if (val % 2 != 0) {
				sum += val;
				min = Math.min(min, val);
			}
		}
		if (sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
