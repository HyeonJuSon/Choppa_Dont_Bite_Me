package com.sweaTestQuestion;

import java.io.*;
import java.util.*;

public class swea_1767 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int mexinox[][], N, max, min, totalCnt;
	static ArrayList<int[]> list; // 가장자리 제외 나머지애들

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; ++tc) {
			N = Integer.parseInt(br.readLine());
			mexinox = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0; // 검사해야할 총 코어 개수

			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					mexinox[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;// 가장자리
					if (mexinox[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			}
			
			go(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}

	// index : 부분집합에 고려할 코어 인덱스, cnt : 연결된 코어 개수
	private static void go(int index, int cnt) {
		if(cnt + (totalCnt -index) <max) return;
		if (index == totalCnt) {
			int res = getLength(); // 놓아진 전선의 길이 구하기
			if (max < cnt) {
				max = cnt; // 코어의 개수
				min = res; // 전선의 길이 합
			} else if (max == cnt) {
//				if(res < min) min = res;
				min = Math.min(min, res);
			}
			return;
		}

		// 코어 선택 전선 놓아보기(4방향)
		int[] current = list.get(index);
		int x = current[0]; // 0- 행
		int y = current[1]; // 1- 열
		for (int d = 0; d < 4; ++d) {
			if (isAvailable(x, y, d)) {
				// 전선 놓기 ( 끝까지 쭈욱)
				setLines(x, y, d, 2);
				// 다음 코어로 넘어가기
				go(index + 1, cnt + 1);
				// 놓았던 전선 되돌려놓기
				setLines(x, y, d, 0);
			}
		}
		// 코어 비선택
		go(index + 1, cnt);
	}

	// 전선의 길이 합을 구하는 메소드
	private static int getLength() {
		int lCnt = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(mexinox[i][j]==2) lCnt++;
			}
		}
		return lCnt;
	}

	// 전선을 끝까지 쭈욱 깔아주는 메소드
	private static void setLines(int x, int y, int d, int s) {
		int nx = x, ny = y;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break; // 끝까지 나아간다.(전원연결가능)
			mexinox[nx][ny] = s;
		}
	}

	// 끝까지 쭉 나아갈 수있는지 검사한다.
	private static boolean isAvailable(int x, int y, int d) {
		int nx = x, ny = y;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				break; // 끝까지 나아간다.(전원연결가능)
			}
			// 0 빈칸 , 1 코어, 2 전선
			if (mexinox[nx][ny] >= 1)
				return false; // 코어/전선은 더 나아갈수없다
		}
		return true;
	}

}
