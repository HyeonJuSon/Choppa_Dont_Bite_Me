package bronze;

import java.util.Scanner;

public class bj_10992_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 1) {
			System.out.println("*");
		} else if (N == 2) {
			System.out.println(" * ");
			System.out.println("***");
		} else {
			// 첫행 출력
			int empty = N - 1;
			for (int i = 0; i < empty; ++i)
				System.out.print(" ");
			System.out.println("*");
			// 사이 행들 출력
			for (int x = 2; x < N; ++x) {
				empty = N-x;
				int front = empty;
				int rear = 2*N-2-empty;
				for(int y=0;y<2*N-1;++y) {
					if(y==front) System.out.print("*");
					else if(y==rear){
						System.out.print("*");
						break;
					}else System.out.print(" ");
				}
				System.out.println();
			}
			// 마지막행 출력
			for (int i = 0; i < N * 2 - 1; ++i)
				System.out.print("*");
		}
	}

}
