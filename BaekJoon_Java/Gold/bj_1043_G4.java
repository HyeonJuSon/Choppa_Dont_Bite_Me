package gold;
import java.io.*;
import java.util.*;

public class bj_1043_G4 {
	
	static int N,M,party[][];
	static boolean truth[], adj[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int t = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		truth = new boolean[N+1];
		adj = new boolean[N+1][N+1];
		for(int i=0;i<t;++i) truth[Integer.parseInt(st.nextToken())]=true;
		party = new int[M][]; 
		for(int i=0;i<M;++i) { // 입력구간
			st = new StringTokenizer(br.readLine()," ");
			int cnt = Integer.parseInt(st.nextToken());
			party[i] = new int[cnt];
			party[i][0]=Integer.parseInt(st.nextToken());
			for(int j=1;j<cnt;++j) {
				party[i][j]=Integer.parseInt(st.nextToken());
				int from = party[i][j-1];
				int to = party[i][j];
				adj[from][to]=adj[to][from] = true;
			}
		}
		for(int i=1;i<=N;++i) {
			if(truth[i]) dfs(i); // 진실을 알고있으면 나랑 연결된 애들한테 알려준다.
		}
		int cnt =0;
		for(int i=0;i<M;++i) {
			if(!truth[party[i][0]])cnt++;
		}
		System.out.println(cnt);
	}
		
	static void dfs(int n) {
		for(int i=1;i<=N;++i) {
			if(adj[n][i] && !truth[i]) { //연결되어있고,진실을 모르면
				truth[i]=true;//진실을 알게해주고
				dfs(i);//진실을 알게된 애랑 연결된 애들도 다 알게해준다.
			}
		}
	}
	
}
