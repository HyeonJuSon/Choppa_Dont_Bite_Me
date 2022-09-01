package bronze;

import java.util.Scanner;

public class bj_17388_B4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int k = sc.nextInt();
		int h = sc.nextInt();
		if(s+k+h>=100) System.out.println("OK");
		else {
			int min = Math.min(s, Math.min(k, h));
			if(min==s) System.out.println("Soongsil");
			else if(min == k) System.out.println("Korea");
			else System.out.println("Hanyang");
		}
	}

}
