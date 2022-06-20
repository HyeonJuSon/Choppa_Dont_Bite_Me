package bronze;

import java.util.Scanner;

public class bj_7567_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int sum = 10;
		char now = input.charAt(0);
		for (int i = 1; i < input.length(); ++i) {
			if(now!=input.charAt(i)) {
				sum+=10;
			}else {
				sum+=5;
			}
			now = input.charAt(i);
		}
		System.out.println(sum);
		sc.close();
	}

}
