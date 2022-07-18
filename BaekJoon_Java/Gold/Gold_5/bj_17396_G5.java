package gold;
import java.io.*;
import java.util.*;
public class bj_17396_G5 {

	static class Node implements Comparable<Node>{
		int end;
        long weight;

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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ward = new int[N];
		long[] dist = new long[N];
		// 와드 값을 입력 받는다.
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) ward[i] = Integer.parseInt(st.nextToken());
		ward[N-1]=0;
		// dist 배열을 초기화한다.
		final long INF = Long.MAX_VALUE;
		Arrays.fill(dist, INF);
		// 인접 리스트를 생성한다.
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < N; ++i) adj.add(new ArrayList<>());
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			adj.get(start).add(new Node(end,val)); // 양방향임.
			adj.get(end).add(new Node(start,val));
		}
		// 다익스트라
		boolean[] isVisited = new boolean[N]; // 각 노드별 방문 처리 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0)); // 0번 노드에서 시작, 초기비용 0
		dist[0]=0; // 비용 초기화
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int end = now.end;
			if(isVisited[end] || ward[end]==1) continue;
			isVisited[end] = true;
			// 연결되어 있는 Node check
			for(Node n : adj.get(end)) {
				if(isVisited[n.end] || ward[n.end]==1) continue;
				if(dist[n.end]> dist[end] + n.weight) {
					dist[n.end] = dist[end] + n.weight;
					pq.add(new Node(n.end, dist[n.end]));
				}
			}
		}
		
		System.out.println(dist[N-1]==INF ? -1:dist[N-1]);
	}

}

