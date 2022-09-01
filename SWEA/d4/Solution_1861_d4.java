package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1861_d4{
	// 諛⑹쓣 留뚮뱺�떎.
	static int[][] Room;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int N;
	static LinkedList<int[]> Length = new LinkedList<int[]>(); // 諛� �닽�옄[0], 湲몄씠[1]
	static int cnt = 1;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d4_�젙�궗媛곹삎諛�.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// �뀒�뒪�듃 耳��씠�뒪 �닔瑜� �엯�젰諛쏅뒗�떎.
		int T = Int(br.readLine());
		// �뀒�뒪�듃 耳��씠�뒪 �닔 留뚰겮 �엯�젰諛쏅뒗�떎.
		for (int tc = 1; tc <= T; ++tc) {
			// 諛⑹쓽 �궗�씠利덈�� �엯�젰諛쏅뒗�떎.
			N = Int(br.readLine());
			Room = new int[N][N];
			// 媛� 諛⑹쓽 �닽�옄瑜� �엯�젰諛쏅뒗�떎.
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				Room[i] = new int[N];
				for (int j = 0; j < N; ++j) {
					Room[i][j] = Int(st.nextToken());
				}
			}
			// �깘諛⑺븳�떎.
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					cnt =1;
					Search(i,j);
					Length.offer(new int[] {Room[i][j],cnt});
				}
			}
			// �젙�젹�븳�떎.
			Collections.sort(Length, (o1,o2)-> {
				if(o2[1]==o1[1])
					return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o2[1], o1[1]);
			});
			// 異쒕젰�븳�떎.
			System.out.println("#"+tc+" "+Length.peek()[0]+" "+Length.peek()[1]);
			Length.clear();
		}

	}

	static void Search(int x, int y) {
		// 4諛� �깘�깋�쓣 �븳�떎.
		for (int d = 0; d < 4; ++d) {
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
