package gold;

import java.io.*;
import java.util.*;

public class bj_17779_G4 {

	static int N, map[][];
	static Queue<int[]> dPair;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 가능한 d1, d2 쌍을 얻어온다.
		dPair = new LinkedList<>();
		comb(0, new int[2], 0);
		// 2. 해당하는 d1, d2에서 영역을 나눈다.
		int min = Integer.MAX_VALUE; // 정답
		while (!dPair.isEmpty()) {
			// 현재 d1, d2를 가져온다.
			int d1 = dPair.peek()[0];
			int d2 = dPair.poll()[1];
			// (x,y)를 1,1~N,N지 돌면서
			for (int x = 1; x <= N; ++x) {
				for (int y = 1; y <= N; ++y) {
					if (!(x < x + d1 + d2 && x + d1 + d2 <= N &&1<=y-d1&& y - d1 < y && y < y + d2 && y + d2 <= N))
						continue;
					// 영역을 나눈다.
					int[][] tmp = new int[N + 1][N + 1]; // 구역을 나눌 배열
					// 5번 구역을 나눈다.
					makeArea(tmp, x, y, d1, d2);
					// 3. 갱신한다.
					min = Math.min(min, getDist(tmp));
				}
			}
		}
		System.out.println(min);
	}

	static int getDist(int[][] tmp) {
		int[] cnt = new int[6];
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				int val = tmp[i][j];
				if(val==5||val==0) cnt[5] += map[i][j];
				else cnt[tmp[i][j]]+= map[i][j];
			}
		}
		Arrays.sort(cnt);
		return cnt[5] - cnt[1];
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static void makeArea(int[][] tmp, int x, int y, int d1, int d2) {
		// 5번 선거구
//		(x, y), (x+1, y-1), ..., (x+d1, y-d1)
		int rr = x, cc = y;
		while (true) {
			tmp[rr++][cc--] = 5;
			if (rr > x + d1 && cc < y - d1)
				break;
		}
//		(x, y), (x+1, y+1), ..., (x+d2, y+d2)
		rr = x;
		cc = y;
		while (true) {
			tmp[rr++][cc++] = 5;
			if (rr > x + d2&& cc > y + d2)
				break;
		}
//		(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		rr = x + d1;
		cc = y - d1;
		while (true) {
			tmp[rr++][cc++] = 5;
			if (rr > x + d1 + d2 && cc > y - d1 + d2)
				break;
		}
//		(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		rr = x + d2;
		cc = y + d2;
		while (true) {
			if (rr > x + d2 + d1 && cc < y + d2 - d1)
				break;
			tmp[rr++][cc--] = 5;
		}

		// 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
		for (int r = 1; r < x + d1; ++r) {
			for (int c = 1; c <= y; ++c) {
				if(tmp[r][c]==5) break;
				if (tmp[r][c] == 0)
					tmp[r][c] = 1;
			}
		}
		// 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
		for (int r = 1; r <= x + d2; ++r) {
			int targetC = 1;
			for(int c = 1; c<=N;++c) {
				if(tmp[r][c]==5) targetC=c;
			}
			for (int c = y + 1; c <= N; ++c) {
				if(c <= targetC) continue;
				if (tmp[r][c] == 0)
					tmp[r][c] = 2;
			}
		}
		// 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
		for (int r = x + d1; r <= N; ++r) {
			for (int c = 1; c < y - d1 + d2; ++c) {
				if(tmp[r][c]==5) break;
				if (tmp[r][c] == 0)
					tmp[r][c] = 3;
			}
		}
		// 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		for (int r = x + d2; r <= N; ++r) {
			int targetC = 1;
			for(int c = 1; c<=N;++c) {
				if(tmp[r][c]==5) targetC=c;
			}
			for (int c = y - d1 + d2; c <= N; ++c) {
				if(c <= targetC) continue;
				if (tmp[r][c] == 0)
					tmp[r][c] = 4;
			}
		}
	
	}

	static void comb(int cnt, int[] input, int sum) {
		if (cnt == 2) { // d1 과 d2를 뽑았으면
			dPair.add(new int[] { input[0], input[1] }); // 쌍을 넣어준다.
			return;
		}
		for (int i = 0; i <= N; ++i) {
			if (i + sum > N)
				continue;
			input[cnt] = i;
			comb(cnt + 1, input, sum + i);
		}
	}
}
