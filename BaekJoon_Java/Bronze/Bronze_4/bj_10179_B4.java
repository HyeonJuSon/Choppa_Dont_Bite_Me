package bronze;

import java.util.Scanner;

public class bj_10179_B4 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;++i) {
			double val = sc.nextDouble();
			System.out.printf("$%.2f\n", val*0.8);
		}
	}

}
