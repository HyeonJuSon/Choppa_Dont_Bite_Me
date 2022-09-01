package bj;

import java.util.*;

public class bj_11653_S4 {
	// 2<= N <= 10000000
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// 입력 준비
		int N = sc.nextInt();					// 소인수분해할 숫자
		if (N != 1) {							// 1이면 출력안함(조건)
			for (int i = 2; i < 10000001; ++i) {// 2부터 나눠보기
				while(N%i == 0) {				// 나눌 수 있을 때 까지
					N /= i;						// 갱신
					System.out.println(i);		// 출력
				}	
				if(N == 0) break;				// 다 나눠졌으면 탈출
			}
		}
		sc.close();
	}

}
