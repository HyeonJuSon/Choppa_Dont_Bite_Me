package com.hwalgo01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1244{

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_bj_1244.txt"));
		// 입력받을 준비를 한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스위치 개수를 받아들인다.
		int T = Integer.parseInt(br.readLine());
		// 스위치 개수만큼 배열을 생성한다.
		boolean[] switches = new boolean[T + 1];// 0 - dummy
		// 스위치 상태를 배열에 저장한다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int tc = 1; tc <= T; tc++) {
			switches[tc] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
		}
		// 학생 수를 입력받는다. 남 1 여 2
		int cnt = Integer.parseInt(br.readLine());
		for (int s = 1; s <= cnt; s++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());// 성별
			int key = Integer.parseInt(st.nextToken());// 키값

			switch (sex) {
			case 1: // 남자면 자기 수의 배수만 플립
				for (int val = key; val <= T; val++) {
					switches[val] = val % key == 0 ? !switches[val] : switches[val];
				}
				break;
			case 2: // 여자면 최대구간 플립(맨끝이거나, 양쪽 좌우대칭아니면 자기자신 플립)
				int L = key - 1;
				int R = key + 1;

				while (true) {
					if (L < 1 || R > T)
						break;
					if (switches[L] != switches[R]) {
						break;
					}
					L--;
					R++;
				}
				L++;
				R--;
				while (L <= R) {
					switches[L] = !switches[L];
					L++;
				}
				break;
			}
		}
		for (int i = 1; i <= T; i++) {
			System.out.print(switches[i] ? "1 " : "0 ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

}
