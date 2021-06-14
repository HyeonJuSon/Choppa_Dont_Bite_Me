import java.io.*;

public class bj_10026_G5 {

	static int[][] map;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Int(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < N; ++j) {
				char ch = s.charAt(j);
				map[i][j] = ch == 'R' ? 0 : (ch == 'G' ? 1 : 2);
			}
		}
		System.out.println(process());
	}

	static String process() {
		boolean[][] isVisited = new boolean[N][N];
		int cnt = 0,rcnt =0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!isVisited[i][j]) {
					isVisited[i][j] = true;
					dfs(false,map[i][j], i, j, isVisited);
					cnt++;
				}
			}
		}
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!isVisited[i][j]) {
					isVisited[i][j] = true;
					dfs(true,map[i][j], i, j, isVisited);
					rcnt++;
				}
			}
		}
		return cnt+" "+rcnt;
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static void dfs(boolean rgb, int val,int i, int j, boolean[][] isVisited) {
		
		
		for (int d = 0; d < 4; ++d) {
			int ni = i + dir[0][d];
			int nj = j + dir[1][d];
			if(isBoundary(ni,nj)&&!isVisited[ni][nj]) {
				if(!rgb && val==map[ni][nj]) {
					isVisited[ni][nj] = true;
					dfs(rgb,val,ni,nj,isVisited);
				}
				else if(rgb && (val==0&&map[ni][nj]==1 ||
								val==1 && map[ni][nj]==0||
								val==map[ni][nj])) {
					isVisited[ni][nj] = true;
					dfs(rgb,val,ni,nj,isVisited);
				}
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static public int Int(String s) {
		return Integer.parseInt(s);
	}
}
