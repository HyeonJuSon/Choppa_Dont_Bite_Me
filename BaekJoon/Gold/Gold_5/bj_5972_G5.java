package gold;

import java.io.*;
import java.util.*;

public class bj_5972_G5 {

	static class Node implements Comparable<Node> {
		int end;
		long weight; // 50000*50000 = 2500000000

		Node(int end, long weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<N;++i) adj.add(new ArrayList<>());
		long[] d = new long[N];
		Arrays.fill(d, Long.MAX_VALUE);
		d[0]=0;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			adj.get(from).add(new Node(to,val));
			adj.get(to).add(new Node(from,val));
		}
		// 다익스트라
		boolean[] isVisited= new boolean[N];
		PriorityQueue<Node> pq= new PriorityQueue<>();
		pq.add(new Node(0,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(isVisited[now.end]) continue;
			isVisited[now.end]=true;
			for(Node n : adj.get(now.end)) {
				if(isVisited[n.end]) continue;
				if(d[n.end]> d[now.end]+n.weight) {
					d[n.end] = d[now.end]+n.weight;
					pq.add(new Node(n.end, d[n.end]));
				}
			}
		}
		
		System.out.println(d[N-1]);
	}

}
