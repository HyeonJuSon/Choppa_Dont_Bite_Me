package silver;
import java.io.*;
import java.util.*;
public class bj_14248_S2 {
	
	static int[] dir = {-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) map[i] = Integer.parseInt(st.nextToken());
		int idx = Integer.parseInt(br.readLine())-1;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		boolean isVisited[] = new boolean[N];
		isVisited[idx]=true;
		int cnt =1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int d=0;d<2;++d) {
				int nidx = now + dir[d]*map[now];
				if(0<=nidx&&nidx<N && !isVisited[nidx]) {
					isVisited[nidx]=true;
					q.add(nidx);
					++cnt;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
