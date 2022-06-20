package bronze;

import java.util.Scanner;

public class bj_2475_B5 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<5;++i) {
			int val = sc.nextInt();
			sum += (val * val);
		}
		System.out.println(sum%10);
	}

}
/*
컴퓨터 마다 6자리의 고유 번호
고유번호 처음 5자리는 00000-99999까지 수 중 하나
6번째 자리는 검증수(= 첫 5자리에 있는 5개 수를 가각 제곱한 합 %10)

*/