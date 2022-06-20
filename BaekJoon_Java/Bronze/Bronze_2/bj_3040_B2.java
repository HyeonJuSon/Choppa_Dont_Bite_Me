package com.hwalgo09;

import java.util.*;
/*
 * fakeHobit개 중에서 realHobit을 뽑는다. 
 * 합만 알면 되니까 순서는 상관 없다. => 조합
 */
public class hwalgo09_구미_4_손현주 {
	static final int fakeHobit = 9;
	static final int realHobit = 7;
	static int[] hatNum;
	static int[] output;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hatNum = new int[fakeHobit];
		output = new int[realHobit];
		for (int i = 0; i < fakeHobit; ++i)
			hatNum[i] = sc.nextInt();
		// 찾기
		search(0, 0, 0);
		sc.close();
	}
	/*
	 * 기존의 조합 메소드에서 조금 수정한다.
	 * sum 이 100이고, cnt를 7개를 뽑았을 경우에 출력해주고 리턴한다.
	 */
	static void search(int cnt, int start, int sum) {
		if (cnt == realHobit && sum == 100) {
			for (int i : output) System.out.println(i);
			return;
		} else if (cnt == realHobit) return;
		for (int i = start; i < fakeHobit; i++) {
			output[cnt] = hatNum[i];
			search(cnt + 1, i + 1, sum + hatNum[i]);
		}
	}
}
