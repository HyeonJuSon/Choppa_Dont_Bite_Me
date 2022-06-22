package com.hwalgo08;

import java.io.*;
import java.util.*;

public class hwalgo08_구미_4_손현주 {

	static int[][] output;
	static int N, M;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/Input_08.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Int(st.nextToken());
		int M = Int(st.nextToken());
		int orderCnt = Int(st.nextToken());

		output = new int[N][M]; // 배열 입력
		for (int i = 0; i < N; ++i) { // 배열 값 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				output[i][j] = Int(st.nextToken());
			}
		}
		// 명령어 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < orderCnt; ++i) {
			int num = Int(st.nextToken());
			switch (num) {
			case 1:
				reverseUD();
				break;
			case 2:
				reverseLR();
				break;
			case 3:
				rotateR();
				break;
			case 4:
				rotateL();
				break;
			case 5:
				groupR();
				break;
			case 6:
				groupL();
				break;
			}
		}
		
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[0].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 1번연산
	static void reverseUD() {
		int[][] tmp = new int[output.length][output[0].length];
		int x = 0, y = 0;
		for (int i = output.length - 1; i >= 0; --i) {
			for (int j = 0; j < output[0].length; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
			y = 0;
		}
		output = tmp;
	}

	// 2번연산
	static void reverseLR() {
		int[][] tmp = new int[output.length][output[0].length];
		int x = 0, y = 0;
		for (int i = 0; i < output.length; ++i) {
			for (int j = output[0].length - 1; j >= 0; --j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
			y = 0;
		}
		output = tmp;
	}

	// 3번연산
	static void rotateR() {
		int[][] tmp = new int[output[0].length][output.length];
		int x = 0, y = 0;
		for (int j = 0; j < output[0].length; ++j) {
			for (int i = output.length - 1; i >= 0; --i) {
				tmp[x][y++] = output[i][j];
			}
			x++;
			y = 0;
		}
		output = tmp;
	}

	// 4번연산
	static void rotateL() {
		int[][] tmp = new int[output[0].length][output.length];
		int x = 0, y = 0;
		for (int j = output[0].length - 1; j >= 0; --j) {
			for (int i = 0; i < output.length; ++i) {
				tmp[x][y++] = output[i][j];
			}
			x++;
			y = 0;
		}
		output = tmp;
	}

	// 5번연산
	static void groupR() {
		int[][] tmp = new int[output.length][output[0].length];
		int x = 0, y = 0;
		// 4번 을 처음에 넣는다.(4->1)
		for (int i = output.length / 2; i < output.length; ++i) {
			for (int j = 0; j < output[0].length / 2; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
			y = 0;
		}
		// 1번을 두번째로 넣는다(1->2)
		x = 0;
		for (int i = 0; i < output.length / 2; ++i) {
			y = output[0].length / 2;
			for (int j = 0; j < output[0].length / 2; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
		}
		// 2번을 세번째로 넣는다 (2->3)
		x = output.length / 2;
		for (int i = 0; i < output.length / 2; ++i) {
			y = output[0].length / 2;
			for (int j = output[0].length / 2; j < output[0].length; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
		}
		// 3번을 네번째로 넣는다.
		x = output.length / 2;
		for (int i = output.length / 2; i < output.length; ++i) {
			y = 0;
			for (int j = output[0].length / 2; j < output[0].length; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
		}
		output = tmp;
	}

	static void groupL() {
		int[][] tmp = new int[output.length][output[0].length];
		int x = 0, y = 0;
		// 2번을 첫번째로 넣는다 (2->1)
		x = 0;
		for (int i = 0; i < output.length / 2; ++i) {
			y = 0;
			for (int j = output[0].length / 2; j < output[0].length; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
		}
		// 3번을 두번째로 넣는다.(3->2)
		x = 0;
		for (int i = output.length / 2; i < output.length; ++i) {
			y = output[0].length/2;
			for (int j = output[0].length / 2; j < output[0].length; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
		}
		// 4번 을 세번째에 넣는다.(4->3)
		x = output.length/2;
		for (int i = output.length / 2; i < output.length; ++i) {
			y= output[0].length/2;
			for (int j = 0; j < output[0].length / 2; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
		}
		// 1번을 네번째로 넣는다(1->4)
		x = output.length/2;
		for (int i = 0; i < output.length / 2; ++i) {
			y = 0;
			for (int j = 0; j < output[0].length / 2; ++j) {
				tmp[x][y++] = output[i][j];
			}
			x++;
		}
		output = tmp;
	}

	// Int형으로 파싱후 반환
	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
