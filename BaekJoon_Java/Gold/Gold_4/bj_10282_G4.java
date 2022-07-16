package gold;

import java.io.*;
import java.util.*;

public class bj_10282_G4 {

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()) - 1;
			ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
			for (int i = 0; i < n; ++i)
				adj.add(new ArrayList<Node>());
			for (int i = 0; i < d; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				adj.get(end).add(new Node(start, weight));
			}
			int[] dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[c] = 0;
			boolean[] isVisited = new boolean[n];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(c, 0));
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				if (isVisited[now.end])
					continue;
				isVisited[now.end] = true;
				for (Node next : adj.get(now.end)) {
					if (isVisited[next.end])
						continue;
					if (dist[next.end] > dist[now.end] + next.weight) {
						dist[next.end] = dist[now.end] + next.weight;
						pq.add(new Node(next.end, dist[next.end]));
					}
				}
			}
			int cnt = 0;
			long last = 0;
			for (int i = 0; i < n; ++i) {
				if (dist[i] != Integer.MAX_VALUE) {
					++cnt;
					last = Math.max(last, dist[i]);
				}
			}
			System.out.println(cnt + " " + last);
		}
	}

}
