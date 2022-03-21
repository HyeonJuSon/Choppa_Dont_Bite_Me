package gold;
import java.io.*;
import java.util.*;
public class bj_11725_S2 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<N-1;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adj.get(from).add(to);
			adj.get(to).add(from);
		}
		
		bfs(0,new int[N], N);
		System.out.println(sb.toString());
	}

	static void bfs(int start, int[] parents, int N) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		parents[start]=1;
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int now : adj.get(p)) {
				if(parents[now]==0) {
					parents[now]=p+1;
					q.offer(now);
				}
			}
		}
		
		for(int i=1;i<N;++i) {
			sb.append(parents[i]).append('\n');
		}
	}
}
