package silver;
import java.io.*;
import java.util.*;
public class bj_1325_S1 {
	
	static int[] parent, level;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;++i) adj.add(new ArrayList<>());
		
		for(int i=0;i<M;++i) {
			st= new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adj.get(to).add(from);
		}
		PriorityQueue<Integer> answer = new PriorityQueue<Integer>();
		int max = 0;
				
		for(int i=0;i<N;++i) {
			int cnt = 0;
			Queue<Integer> bfs = new LinkedList<>();
			boolean[] isVisited = new boolean[N];
			isVisited[i] = true;
			bfs.add(i);
			while(!bfs.isEmpty()) {
				int current = bfs.poll();
				for(Integer now : adj.get(current)) {
					if(!isVisited[now]) {
						isVisited[now]=true;
						bfs.add(now);
						++cnt;
					}
				}
			}
			if(max < cnt) {
				answer.clear();
				answer.add(i+1);
				max = cnt;
			}else if(max == cnt) {
				answer.add(i+1);
			}
		}
		while(!answer.isEmpty()) {
			System.out.print(answer.poll()+" ");
		}
	}

}
