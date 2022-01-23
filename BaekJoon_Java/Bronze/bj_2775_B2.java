package bronze;

import java.util.Scanner;

public class bj_2775_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;++t) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			// k-1층의 1호부터 N호까지 합
			int[][] apart = new int[15][15];
			for(int i=1;i<15;++i) {
				apart[0][i] = i;
			}
			// 1층부터 K층
			for(int i=1;i<=K;++i) {
				for(int j=1;j<=N;++j) {
					int sum =0;
					for(int k=1;k<=j;++k) {
						sum += apart[i-1][k];
					}
					apart[i][j]=sum;
				}
			}
			int answer =0;
			for(int j=1;j<=N;++j) answer += apart[K-1][j];
			System.out.println(answer);
		}
	}

}
