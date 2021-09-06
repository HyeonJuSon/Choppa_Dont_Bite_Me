package bronze;

import java.util.Scanner;

public class bj_2501_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0, val = 0;
		for(int i=1; i<=N; ++i) {
			if(N%i==0) {
				++cnt;
				val = i;
				if(cnt == K) {
					System.out.println(val);
					break;
				}
			}
		}
		if(cnt < K) System.out.println(0);
	}

}
