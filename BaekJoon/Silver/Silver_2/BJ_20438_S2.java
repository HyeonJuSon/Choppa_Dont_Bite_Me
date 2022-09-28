import java.io.*;
import java.util.*;

public class BJ_20438_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] sleep = new boolean[N + 3];
		boolean[] number = new boolean[N + 3];
		// input sleep
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; ++i) {
			sleep[Integer.parseInt(st.nextToken())] = true;
		}
		// number input
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Q; ++i) {
			int val = Integer.parseInt(st.nextToken());
			if (sleep[val])
				continue;
			for (int v = 1; v * val <= N + 2; ++v) {
				if (!sleep[v * val])
					number[v * val] = true;
			}
		}
		// sum
		int[] sum = new int[N + 3];
		for (int i = 3; i < sum.length; ++i) {
			sum[i] = sum[i - 1] + ((!number[i]) ? 1 : 0);
		}
		// range input
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			System.out.println(sum[E]-sum[S-1]);
		}
	}

}
