package bronze;

import java.io.*;
import java.util.*;

public class bj_9076_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for (int j = 0; j < 5; ++j) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			pq.poll();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			while (pq.size() > 1) {
				int val = pq.poll();
				max = Math.max(max, val);
				min = Math.min(min, val);
				sum += val;
			}
			System.out.println(max - min >= 4 ? "KIN" : sum);
		}
	}

}
