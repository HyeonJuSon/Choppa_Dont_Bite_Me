package bronze;

import java.util.Scanner;

public class bj_2857_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cnt =0;
		for(int i=1;i<=5;++i) {
			String input = sc.next();
			if(input.contains("FBI")) {
				++cnt;
				System.out.print(i+" ");
			}
		}
		if(cnt==0) System.out.println("HE GOT AWAY!");
	}

}
