import java.io.*;
import java.util.*;

public class bj_20007_G4 {

	static class Edge implements Comparable<Edge> { // 각 집의 정보를 담을 클래스
		int no, dist;

		Edge(int no, int dist) {
			this.no = no;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) { // 거리가까운순
			return Integer.compare(this.dist, o.dist);
		}
	}

	static ArrayList<Edge>[] adjList;
	static int N, M, X, Y, INF = Integer.MAX_VALUE, dist[];

	public static void main(String[] args) throws Exception {
		// 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		dist = new int[N];
		adjList = new ArrayList[N];
		for (int i = 0; i < N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, dist));//인접리스트 
			adjList[to].add(new Edge(from, dist));
		}
		// 입력 끝 
		System.out.println(getDay()); // 몇일걸렸니?
	}

	static int getDay() {

		findShortest(); // 가까운 집을 찾고
		Arrays.sort(dist); // 오름차순 정렬
		if(dist[N-1] * 2 > X) return -1; // 방문못하면 바로 -1 반환
		
		// 가까운 집부터 방문 시작
		int idx = 0, day = 0;
		int tmp = 0;
		while(idx<N) {//N-1까지 
			while(idx < N && tmp + dist[idx] *2 <= X) { // 왕복가능하면
				tmp += dist[idx++]*2; //
			}
			tmp = 0;
			++day;
		}
		return day;
	}

	static void findShortest() {
		Arrays.fill(dist, INF);

		boolean[] isVisited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[Y] = 0; // 성현집 출발
		pq.add(new Edge(Y, 0));

		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			if (!isVisited[current.no]) {
				for (Edge e : adjList[current.no]) {
					int shortest = dist[current.no] + e.dist;
					if (!isVisited[e.no] && dist[e.no] > shortest) {
						dist[e.no] = shortest;
						pq.add(new Edge(e.no, dist[e.no]));
					}
				}

				isVisited[current.no] = true;
			}
		}
	}
}
