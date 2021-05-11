package bronze;

import java.util.Scanner;

public class bj_2441_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) System.out.print(j<i?" ":"*");
			System.out.println();
		}
		sc.close();
	}

}
