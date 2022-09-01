package bj.silver;
import java.io.*;
import java.util.*;

public class bj_1697_S1 {
	static int[] isVisited = new int[100001];
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		K = Integer.parseInt(st[1]);
		if(N==K) System.out.println(0);
		else Search(N);
	}

	static void Search(int idx) {
		Queue<Integer> bfs = new LinkedList<>();
		bfs.offer(idx);
		isVisited[idx] = 1;

		while (!bfs.isEmpty()) {
			int before = bfs.poll();
			for (int i = 0; i < 3; ++i) {
				int after=0;
				if (i == 0) after = before - 1;
				else if (i == 1) after = before + 1;
				else if (i == 2) after = before * 2;

				if (after == K) {
					System.out.println(isVisited[before]);
					return;
				}

				if (0 <= after && after < isVisited.length && isVisited[after] == 0) {
					bfs.offer(after);
					isVisited[after] = isVisited[before] + 1;
				}
			}
		}
	}
}
