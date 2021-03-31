import java.io.*;
import java.util.*;

public class bj_1520_G4 {

	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int X, Y, map[][],dp[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		dp = new int[X+1][Y+1]; // dp로 푼다.
		for(int i=0;i<X+1;++i) Arrays.fill(dp[i], -1); 	// 경로로갈수없는 경우가 0일수 있어서 음수로 채움
		for (int i = 0; i < X; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < Y; ++j) map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dfs(0, 0));
	}

	static int dfs(int x, int y) {
		dp[x][y] = 0; // 경로왔으면 0으로 초기화
		for (int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(isAvailable(nx,ny)&&	map[x][y] > map[nx][ny]) {
				if(nx == X-1 && ny == Y-1) dp[x][y]++;
				if(dp[nx][ny] >=0) dp[x][y] += dp[nx][ny];
				else dp[x][y] += dfs(nx,ny);
			}
		}
		return dp[x][y];
	}

	static boolean isAvailable(int x, int y) {
		return x >= 0 && x < X && y >= 0 && y < Y;
	}
}
