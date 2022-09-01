package gold;
import java.io.*;
import java.util.*;

public class bj_1504_G4 {

	static class Node implements Comparable<Node>{
		int end, weight;
		Node(int end, int weight){
			this.end=end;
			this.weight=weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int N, INF =200000*1000;
	static ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 인접리스트
		for(int i=0;i<N;++i) adj.add(new ArrayList<Node>());
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int start= Integer.parseInt(st.nextToken())-1;
			int end= Integer.parseInt(st.nextToken())-1;
			int val= Integer.parseInt(st.nextToken());
			adj.get(start).add(new Node(end,val));
			adj.get(end).add(new Node(start,val));
		}
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		int res = 0, res2 = 0;
		res = dijkstra(0,start)+dijkstra(start,end)+dijkstra(end,N-1);
		res2 = dijkstra(0,end)+dijkstra(end,start)+dijkstra(start,N-1);
		System.out.println(res>=INF&&res2>=INF ? -1 : Math.min(res, res2));
	}

	static public int dijkstra(int start, int end) {
		int[] dist = new int[N];
		Arrays.fill(dist, INF);
		boolean[] isVisited = new boolean[N];
		PriorityQueue<Node> pq= new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] =0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(isVisited[now.end])continue;
			isVisited[now.end]= true;
			for(Node n : adj.get(now.end)) {
				if(isVisited[n.end])continue;
				if(dist[n.end]>dist[now.end]+n.weight) {
					dist[n.end] = dist[now.end]+n.weight;
					pq.add(new Node(n.end, dist[n.end]));
				}
			}
		}
		return dist[end];
	}
}
