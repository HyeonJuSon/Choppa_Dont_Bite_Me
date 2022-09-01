package gold;

import java.io.*;
import java.util.*;

public class bj_2660_G5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int INF = 987654321;
		for (int i = 0; i < N; ++i)
			for(int j=0;j<N;++j) {
				if(i!=j) arr[i][j]=INF;
			}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			if (from == -2 && to == -2)
				break;
			arr[from][to] = arr[to][from] = 1;
		}
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		int min = N;
		for (int i = 0; i < N; ++i) {
			int val = 0;
			for (int j = 0; j < N; ++j) {
				if (arr[i][j] != INF)
					val = Math.max(val, arr[i][j]);
			}
			min = Math.min(min, val);
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; ++i) {
			int val = 0;
			for (int j = 0; j < N; ++j) {
				if (arr[i][j] != INF)
					val = Math.max(val, arr[i][j]);
			}
			if (min == val)
				q.offer(i + 1);
		}
		System.out.println(min + " " + q.size());
		while (!q.isEmpty()) {
			System.out.print(q.poll() + " ");
		}
	}

}
