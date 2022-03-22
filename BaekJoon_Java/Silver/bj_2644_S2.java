package gold;

import java.io.*;
import java.util.*;

public class bj_2644_S2 {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static class Pair {
		int target, depth;

		Pair(int target, int depth) {
			this.target = target;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i)
			adj.add(new ArrayList<>());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken()) - 1;

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken()) - 1;
			int child = Integer.parseInt(st.nextToken()) - 1;
			adj.get(parent).add(child);
			adj.get(child).add(parent);
		}

		Queue<Pair> bfs = new LinkedList<>();
		bfs.add(new Pair(A,0));
		int answer = -1;
		boolean[][] isVisited = new boolean[N][N];
		
		while(!bfs.isEmpty()) {
			Pair now = bfs.poll();
			if(now.target==B) {
				answer = now.depth;
				break;
			}
			for(int child : adj.get(now.target)) {
				if(isVisited[now.target][child]) continue;
				isVisited[now.target][child]=true;
				bfs.add(new Pair(child,now.depth+1));
			}
		}
		System.out.println(answer);
	}

}
