package silver;

import java.io.*;
import java.util.*;

public class BJ_7562_S1 {

	static int[][] dir = { { -2, -2, -1, -1, 1, 1, 2, 2 }, { -1, 1, -2, 2, -2, 2, -1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] now = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			st = new StringTokenizer(br.readLine(), " ");
			int[] target = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			if(now[0]==target[0] && now[1]==target[1]) {
				System.out.println(0);
				continue;
			}
			Queue<Node> bfs = new LinkedList<>();
			bfs.add(new Node(now[0], now[1], 0));
			boolean[][] isVisited = new boolean[N][N];
			isVisited[now[0]][now[1]] = true;
			while (!bfs.isEmpty()) {
				Node cur = bfs.poll();
				if (cur.x == target[0] && cur.y == target[1]) {
					System.out.println(cur.depth);
					break;
				}
				for (int d = 0; d < 8; ++d) {
					int nx = cur.x + dir[0][d];
					int ny = cur.y + dir[1][d];
					if(isBoundary(nx,ny,N)&&!isVisited[nx][ny]) {
						isVisited[nx][ny]= true;
						bfs.add(new Node(nx,ny,cur.depth+1));
					}
				}
			}
		}
	}

	static boolean isBoundary(int x, int y, int N) {
		return 0<=x && x<N && 0<=y && y<N ;
	}
	static class Node {
		int x, y;
		int depth;

		Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}
