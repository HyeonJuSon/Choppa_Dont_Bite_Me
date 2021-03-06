import java.io.*;
import java.util.*;

public class bj_4386_G4 {

	static class Edge implements Comparable<Edge> { // 간선 클래스
		int start, end;
		double value;
		public Edge(int start, int end, double value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.value, o.value);
		}
	}

	static class Pos {//Position 클래스
		double x, y;
		public Pos(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static PriorityQueue<Edge> pq = new PriorityQueue<>(); //비용기준 오름차순
	static ArrayList<double[]> list = new ArrayList<>();
	static int[] parents ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Pos[] arr = new Pos[n];
		parents = new int[n+1];
		StringTokenizer st = null;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Pos(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		}
		// 별들 사이의 비용계산해서 큐에 넣어주기
		for(int i=0;i<n-1;++i) {
			for(int j=i+1; j<n;++j) {
				pq.offer(new Edge(i,j,getDist(arr[i],arr[j])));
			}
		}
		// make 
		for(int i=0;i<n;++i) parents[i] = i;
		// union
		int size = pq.size();
		double result = 0.0;
		for(int i=0;i<size;++i) {
			Edge current = pq.poll();
			int a = find(current.start);
			int b = find(current.end);
			if(a==b) continue; // 이미 연결되어있으면 ㄴㄴ
			union(current.start, current.end);
			result += current.value;
		}
		System.out.printf("%.2f",result);
	}
	//find
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	//union-연결
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA!=rootB) parents[rootA] = b;
		else return;
	}
	// 비용 계산 메소드
	static double getDist(Pos a, Pos b) {
		return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) +
				 		 Math.pow(Math.abs(a.y - b.y), 2));
	}
}
