package gold;

import java.io.*;
import java.util.*;

public class bj_4179_G4 {
	static class JH {
		int x, y;
		int time;

		JH(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N, M, dir[][] = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
	static char[][] map;
	static Queue<int[]> fires = new LinkedList<>();
	static Queue<JH> jq = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		// input
		for (int i = 0; i < N; ++i) {
			String input = br.readLine();
			for (int j = 0; j < M; ++j) {
				char now = input.charAt(j);
				map[i][j] = now;
				if (now == 'J') {
					jq.offer(new JH(i, j, 0));
				} else if (now == 'F') {
					fires.offer(new int[] { i, j });
				}
			}
		}
		int answer = process();
		System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
	}

	static void FireSpread() {
		int len = fires.size();
		for (int i = 0; i < len; ++i) {
			int[] current = fires.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = current[0] + dir[0][d];
				int ny = current[1] + dir[1][d];
				if (!isBoundary(nx, ny)) continue;
				if (map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
				map[nx][ny] = 'F';
				fires.offer(new int[] { nx, ny });
			}
		}
	}

	static int process() {
		int answer = 0;
		boolean[][] isVisited = new boolean[N][M];
		isVisited[jq.peek().x][jq.peek().y] = true;
		map[jq.peek().x][jq.peek().y] = '.';
		while (true) {
			// fires
			FireSpread();
			// JH
			int len = jq.size();
			for (int i = 0; i < len; ++i) {
				JH current = jq.poll();
				
				// 더 탐색 해야하는 경우
				for (int d = 0; d < 4; ++d) {
					int nx = current.x + dir[0][d];
					int ny = current.y + dir[1][d];
					if(isOutside(nx,ny)) {
						System.out.println(current.time+1);
						System.exit(0);
					}
					if (isBoundary(nx, ny) && !isVisited[nx][ny] && map[nx][ny] == '.') {
						isVisited[nx][ny] = true;
						map[nx][ny] = 'J';
						jq.offer(new JH(nx, ny, current.time + 1));
					}
				}
			}
			if(jq.isEmpty())break;
		}
		return answer;
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
	static boolean isOutside(int x, int y) {
		return x == -1 || x == N || y == -1 || y == M;
	}
}
