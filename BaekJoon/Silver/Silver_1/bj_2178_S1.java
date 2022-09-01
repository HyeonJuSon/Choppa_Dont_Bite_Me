import java.io.*;
import java.util.*;

public class bj_2178 {

	static int N, M, map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) { // 맵에 떄려박기
			String input = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		System.out.println(process());
	}
	
	static int dir [][] = {{-1,1,0,0},{0,0,-1,1}};
	static int process() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		boolean isVisited[][] = new boolean[N][M];
		isVisited[0][0] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for(int d=0;d<4;++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];
				if(isBoundary(nx, ny) && map[nx][ny]==1) {
					isVisited[nx][ny]=true;
					q.offer(new int[] {nx,ny});
					map[nx][ny]= map[now[0]][now[1]]+1;
				}
			}
		}
		return map[N-1][M-1];
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
