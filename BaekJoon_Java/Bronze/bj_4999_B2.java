package bronze;

import java.util.Scanner;

public class bj_4999_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String me = sc.next();
		String target = sc.next();
		System.out.println(me.length() >= target.length() ? "go" :"no");
	}

}
