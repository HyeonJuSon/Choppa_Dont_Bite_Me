package gold;
import java.io.*;
import java.util.*;
public class bj_1507_G3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] after = new int[N][N]; // 플로이드 와샬이 이미 되어있는 배열
		int[][] before = new int[N][N]; // 플로이드 와샬 이전의 배열 - 찾아야 하는 것
		int INF = 987654321;
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;++j) {
				after[i][j] = before[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0;k<N;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(i==j || i==k || j==k) continue;
					if(after[i][j] > after[i][k]+ after[k][j]) {
						System.out.println(-1);
						System.exit(0);
					}
					if(after[i][j] == after[i][k] + after[k][j])
						before[i][j]=INF;
				}
			}
		}
		boolean[][] isVisited = new boolean[N][N];
		int answer = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(before[i][j]==INF || i==j || isVisited[i][j]) continue;
				isVisited[i][j] = isVisited[j][i]= true;
				answer += before[i][j];
			}
		}
		System.out.println(answer);
	}

}
