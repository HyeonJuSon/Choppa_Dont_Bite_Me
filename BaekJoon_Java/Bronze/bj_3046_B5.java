package bronze;

import java.util.Scanner;

public class bj_3046_B5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R1 = sc.nextInt();
		int S = sc.nextInt();
		int R2 = (2*S) - R1;
		System.out.println(R2);
	}
}
