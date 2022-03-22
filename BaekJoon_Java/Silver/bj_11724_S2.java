package gold;
import java.io.*;
import java.util.*;
public class bj_11724_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<N;++i) adj.add(new ArrayList<>());
		
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adj.get(from).add(to);
			adj.get(to).add(from);
		}
		
		boolean[] isVisited = new boolean[N];
		int answer = 0 ;
		for(int i=0;i<adj.size();++i) {
			if(isVisited[i]) continue; // 이미 방문했는데 또 찾을 필요는 없음.
			for(int now : adj.get(i)) {
				if(!isVisited[now]) {
					isVisited[now]=true;
					++answer;
					Queue<Integer> bfs = new LinkedList<>();
					bfs.add(now);
					while(!bfs.isEmpty()) {
						int current = bfs.poll();
						for(int next : adj.get(current)) {
							if(!isVisited[next]) {
								isVisited[next]=true;
								bfs.add(next);
							}
						}
					}
				}
			}
			if(!isVisited[i]) ++answer;
		}
		System.out.println(answer);
	}

}
