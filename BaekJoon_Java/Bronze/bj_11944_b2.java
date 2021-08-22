package bronze;

import java.util.Scanner;

public class bj_11944_b2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String input = Integer.toString(N);
		String answer = "";
		for (int i = 0; i < N; ++i) {
			answer += input;
		}
		System.out.println(answer.length() > M ? answer.substring(0, M) : answer);
	}

}
