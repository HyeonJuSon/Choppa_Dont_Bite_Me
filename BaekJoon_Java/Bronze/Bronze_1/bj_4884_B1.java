package bj;

import java.util.*;

public class bj_4884 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		while (true) {
			// 입력 부분
			long G = sc.nextLong();
			long T = sc.nextLong();
			long A = sc.nextLong();
			long D = sc.nextLong();
			if (G == -1) break;

			long X = G * (T * (T - 1) / 2);// 전체 경기수
			long tonerCnt = G * A + D; // 토너먼트 진출 팀수
			// 2의n제곱꼴인지 검사
			long check = 1;
			while (tonerCnt > check) {
				X += check;
				check *= 2;
			}
			long Y = check - tonerCnt; // 추가 팀 수
			// 출력 정보 저장 =========================

			System.out.printf("%d*%d/%d+%d=%d+%d\n", G, A, T, D, X, Y);
		}
		sc.close();
	}
}
