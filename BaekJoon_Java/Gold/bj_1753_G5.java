package gold;

import java.io.*;
import java.util.*;

public class bj_1753_G5 {
	static class Node implements Comparable<Node> {
		int idx;
		int w;

		Node(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine()) - 1;
		int INF = 987654321;
		// distance 
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		// 인접 리스트
		ArrayList<Node>[] adj = new ArrayList[V];
		for (int i = 0; i < V; ++i)
			adj[i] = new ArrayList<>();

		dist[start] = 0;
		for(int i=0;i<E;++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, val));
		}
		
		// dijkstra
		PriorityQueue<Node> q= new PriorityQueue<>();
		q.add(new Node(start, 0));
		while(!q.isEmpty()) {
			Node current = q.poll();
			int idx = current.idx;
			int w = current.w;
			if(dist[idx] < w) continue;
			for(int i=0;i<adj[idx].size();++i) {
				int nidx = adj[idx].get(i).idx;
				int nw = adj[idx].get(i).w + w;
				if(dist[nidx] > nw) {
					dist[nidx] = nw;
					q.add(new Node(nidx, nw));
				}
			}
		}
		
		// print
		for(int i=0;i<V;++i) {
			if(dist[i]==INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

}
