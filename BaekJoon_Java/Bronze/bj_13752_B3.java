package bronze;

import java.util.Scanner;

public class bj_13752_B3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0;i<N;++i) {
			int val = sc.nextInt();
			for(int j=0;j<val;++j) System.out.print("=");
			System.out.println();
		}
		sc.close();
	}

}
