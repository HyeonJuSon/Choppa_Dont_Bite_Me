package bronze;

import java.util.Scanner;

public class bj_11283_B5 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		char input = sc.next().charAt(0);
		int extra = (int)'힣'- 11172;
		System.out.println((int)input-extra);
	}

}
