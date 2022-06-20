package bronze;

import java.util.Scanner;

public class bj_19944_B4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		System.out.println(M<=2?"NEWBIE!":(3<=M && M<=N ? "OLDBIE!":"TLE!"));
	}

}
