package bronze;

import java.util.Scanner;

public class bj_4101_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		while(true) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a==0&&b==0) break;
			System.out.println(a>b?"Yes":"No");
		}
	
	}

}
