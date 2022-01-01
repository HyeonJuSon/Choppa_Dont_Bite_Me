package bronze;

import java.util.Scanner;

public class bj_10991_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; ++i) {
			int blankCnt = Math.abs(i-N);
			boolean isFirst = blankCnt > 0 ? true : false;
			boolean isToggle = false;
			int starCnt = 0;
			for (int j = 0; j < 2*N; ++j) {
				if (isFirst) {
					--blankCnt;
					System.out.print(" ");
				} else {
					if(isToggle) System.out.print(" ");
					else {
						System.out.print("*");
						++starCnt;
					}
					isToggle = !isToggle;
				}
				if(blankCnt == 0) {
					isFirst = false;
				}
				if(starCnt == i) break;
			}
			System.out.println();
		}
		sc.close();
	}

}
