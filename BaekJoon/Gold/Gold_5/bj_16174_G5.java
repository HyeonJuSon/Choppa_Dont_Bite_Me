import java.io.*;
import java.util.*;

public class bj_16174_G5 {

	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isVisited[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		isVisited[0][0] = true;
		boolean isGoal =false;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			
			for(int d=0;d<2;++d) {
				int val = map[current[0]][current[1]];
				int nx= current[0] + dx[d] * val;
				int ny= current[1] + dy[d] * val;
				if(isAvailable(nx,ny) && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
			
			if(current[0] == N-1 && current[1] == N-1) {
				isGoal = true;
				q.clear();
			}
		}
		System.out.println(isGoal?"HaruHaru":"Hing");
	}

	static boolean isAvailable(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}

/*
 * 1. 범위 안에서만 움직인다. 
 * 2. 젤리는 0,0에서 시작한다 
 * 3. 이동 가능한 방향은 오른쪽과 아래뿐이다 
 * 4. 도착점은 N-1, * N-1이다. 
 * 5. 한번에 이동할 수 있는 칸의 수는 현재 밟고있는 칸에 쓰여진 수 
 * 6. 승리여부출력
 */