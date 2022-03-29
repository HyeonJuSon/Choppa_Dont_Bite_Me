package gold;

import java.io.*;
import java.util.*;

public class bj_4195_G2 {
	static int[] parent, level;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < TC; ++t) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F * 2];
			level = new int[F * 2];
			for (int i = 0; i < F * 2; ++i) {
				parent[i] = i;
				level[i] = 1;
			}
			int idx = 0;
			// 764ms
			HashMap<String, Integer> friends = new HashMap<>();
			// 988ms
			// Map<String, integer> friends = new HashMap<>();
			for (int f = 0; f < F; ++f) {
				st = new StringTokenizer(br.readLine(), " ");
				String from = st.nextToken();
				String to = st.nextToken();
				if (!friends.containsKey(from))
					friends.put(from, idx++);
				if (!friends.containsKey(to))
					friends.put(to, idx++);
				sb.append(union(friends.get(from), friends.get(to))).append('\n');
			}
		}
		System.out.println(sb.toString());
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
			level[a] += level[b];
			level[b] = 1;
		}
		return level[a];
	}

	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
}
