package bj;

import java.util.*;

public class bj_2346 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) arr[i] = sc.nextInt();
		int idx = 0, findCnt = 0;
		while (true) {
			int moveCnt = arr[idx];
			arr[idx] = 1001;
			sb.append(idx + 1).append(" ");
			if(++findCnt == N) break;
			int nowMove = 0;
			if (moveCnt > 0) {
				while (nowMove != moveCnt) {
					++idx;
					if (idx >= N) idx -= N;
					if (arr[idx] != 1001) nowMove++;
				}
			} else {
				while (nowMove != moveCnt) {
					--idx;
					if (idx < 0) idx += N;
					if (arr[idx] != 1001) nowMove--;
				}
			}
		}
		sc.close();
		System.out.println(sb);
	}

}
