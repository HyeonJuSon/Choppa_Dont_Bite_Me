import java.io.*;
import java.util.*;

public class Solution_1249_d4 {
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC;
		TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; ++t) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				String now = br.readLine();
				for (int j = 0; j < N; ++j) {
					map[i][j] = now.charAt(j) - '0';
				}
			}

			PriorityQueue<Node> bfs = new PriorityQueue<>();
			boolean[][] isVisited = new boolean[N][N];
			isVisited[0][0] = true;
			bfs.add(new Node(0, 0, map[0][0]));
			int answer = Integer.MAX_VALUE;
			while (!bfs.isEmpty()) {
				Node cur = bfs.poll();
				if (cur.x == N - 1 && cur.y == N - 1) {
					answer = Math.min(answer, cur.cnt);
					continue;
				}

				for (int d = 0; d < 4; ++d) {
					int nx = cur.x + dir[0][d];
					int ny = cur.y + dir[1][d];
					if (isBoundary(nx, ny) && !isVisited[nx][ny]) {
						isVisited[nx][ny]=true;
						bfs.add(new Node(nx,ny,cur.cnt+map[nx][ny]));
					}
				}
			}
			
			System.out.println("#"+t+" "+answer);

		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	static class Node implements Comparable<Node> {
		int x, y;
		int cnt;
		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}

}
