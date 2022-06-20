package bronze;

import java.util.Scanner;

public class bj_10768_B4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mon = sc.nextInt();
		int day = sc.nextInt();
		String answer = "";
		if(mon < 2) answer = "Before";
		else if(mon == 2) answer = day == 18 ? "Special":(day < 18 ?"Before":"After");
		else answer = "After";
		System.out.println(answer);
	}

}
