package gold;

import java.io.*;
import java.util.*;

public class bj_1922_G4 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) parents[y]=x;
	}
	static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	static int[] parents;
	static ArrayList<Edge> edges = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		// 정점 정보 입력
		StringTokenizer st = null;
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from,to,w));
		}
		// 부모 배열 형성
		parents = new int[N+1];
		for(int i=0;i<N+1;++i)parents[i]=i;
		// 오름차순 정렬
		Collections.sort(edges);
		// 계산
		int answer = 0;
		for(int i=0;i<edges.size();++i) {
			Edge e = edges.get(i);
			if(find(e.from) != find(e.to)) {
				answer += e.weight;
				union(e.from,e.to);
			}
		}
		// 출력
		System.out.println(answer);
	}

}
