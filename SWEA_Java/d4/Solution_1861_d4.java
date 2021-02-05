package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_구미_4_손현주 {
	// 방을 만든다.
	static int[][] Room;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int N;
	static LinkedList<int[]> Length = new LinkedList<int[]>(); // 방 숫자[0], 길이[1]
	static int cnt = 1;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d4_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 테스트 케이스 수를 입력받는다.
		int T = Int(br.readLine());
		// 테스트 케이스 수 만큼 입력받는다.
		for (int tc = 1; tc <= T; ++tc) {
			// 방의 사이즈를 입력받는다.
			N = Int(br.readLine());
			Room = new int[N][N];
			// 각 방의 숫자를 입력받는다.
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				Room[i] = new int[N];
				for (int j = 0; j < N; ++j) {
					Room[i][j] = Int(st.nextToken());
				}
			}
			// 탐방한다.
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					Search(i,j);
					Length.offer(new int[] {Room[i][j],cnt});
				}
			}
			// 정렬한다.
			Collections.sort(Length, (o1,o2)-> {
				if(o2[1]==o1[1])
					return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o2[1], o1[1]);
			});
			// 출력한다.
			System.out.println("#"+tc+" "+Length.peek()[0]+" "+Length.peek()[1]);
			Length.clear();
		}

	}

	static void Search(int x, int y) {
		// 4방 탐색을 한다.
		for (int d = 0; d < 4; ++d) {
			if(d==0) cnt =1;
			int ni = x + di[d];
			int nj = y + dj[d];
			if(isBoundary(ni,nj) && Room[ni][nj]-Room[x][y]==1) {
					Search(ni,nj);
					cnt++;
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		return false;
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
