import java.io.*;
import java.util.*;

public class bj_2887_G1 {

	static class Pos {
		int idx;
		int x, y, z;
		public Pos(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge implements Comparable<Edge> {
		int start, end, val;
		public Edge(int start, int end, int val) {
			super();
			this.start = start;
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.val, o.val);
		}
	}

	static int N;
	static int[] parents;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Pos[] planet = new Pos[N];
		parents = new int[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			planet[i] = new Pos(i,i(st.nextToken()), i(st.nextToken()), i(st.nextToken()));
		}
		// x 
		Comparator<Pos> cmp = (o1, o2) -> Integer.compare(o1.x, o2.x);
		Arrays.sort(planet,cmp);
		for(int i=1;i<N;++i) pq.offer(new Edge(planet[i-1].idx, planet[i].idx,getDist(planet[i-1].x,planet[i].x)));
		// y
		cmp = (o1, o2) -> Integer.compare(o1.y, o2.y);
		Arrays.sort(planet,cmp);
		for(int i=1;i<N;++i) pq.offer(new Edge(planet[i-1].idx, planet[i].idx,getDist(planet[i-1].y,planet[i].y)));
		// z
		cmp = (o1, o2) -> Integer.compare(o1.z, o2.z);
		Arrays.sort(planet,cmp);
		for(int i=1;i<N;++i) pq.offer(new Edge(planet[i-1].idx, planet[i].idx,getDist(planet[i-1].z,planet[i].z)));
		
		
//		for (int i = 0; i < N - 1; ++i) {
//			for (int j = i + 1; j < N; ++j) {
//				pq.offer(new Edge(i,j,getDist(planet[i],planet[j])));
//			}
//		}
		// make
		for(int i=0;i<N;++i) parents[i] =i;
		// kruskal
		int size = pq.size();
		long ans = 0;
		for(int i=0;i<size;++i) {
			Edge current = pq.poll();
			if(union(current.start, current.end)) {
				ans += current.val;
			};
		}
		System.out.println(ans);
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB) return false;
		else {
			parents[rootA] = b;
			return true;
		}
	}
	// x, y , z 좌표 차 중에 제일 작은 값이 비용
	static int getDist(int a, int b) {
		return Math.abs(a-b);
	}
	static int i(String s) { return Integer.parseInt(s);}
}
