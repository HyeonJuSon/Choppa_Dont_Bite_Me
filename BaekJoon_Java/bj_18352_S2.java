package gold;

import java.io.*;
import java.util.*;

public class bj_18352_S2 {
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

	static int[] dist;
	static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int INF = 300001;
		dist = new int[N];
		Arrays.fill(dist, INF);
		for (int i = 0; i < N; ++i)
			adj.add(new ArrayList<>());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adj.get(from).add(new Node(to, 1));
		}
		dijkstra(X - 1);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; ++i) {
			if (dist[i] == K)
				pq.add(i + 1);
		}
		if (pq.isEmpty())
			System.out.println(-1);
		else {
			while (!pq.isEmpty())
				System.out.println(pq.poll());
		}
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dist[now.end] < now.weight)
				continue;

			for (Node next : adj.get(now.end)) {
				int cost = dist[now.end] + next.weight;

				if (cost < dist[next.end]) {
					dist[next.end] = cost;
					pq.offer(new Node(next.end, cost));
				}
			}
		}
	}
}
