package d4;

import java.io.*;
import java.util.*;

public class swea_1868_d4 {
	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, map[][];
	static boolean[][] isVisited;
	static int[][] dir = { { -1, -1, -1, 0, 0, 1, 1, 1 }, { -1, 0, 1, -1, 1, -1, 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea_1868_d4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = stoi(br.readLine());
			map = new int[N][N];
			isVisited = new boolean[N][N];
			Queue<Pos> mines = new LinkedList<>();
			for (int i = 0; i < N; ++i) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; ++j) {
					char val = tmp[j];
					map[i][j] = val == '*' ? -1 : 0; // ���� -1 ����� 0
					if (val == '*') mines.offer(new Pos(i, j));
				}
			}
			updateMineCnt(mines); // ���ڰ����� �������ش�.
			sb.append("#").append(tc).append(" ").append(getClickCnt()).append('\n');
		}
		System.out.println(sb);
	}

	private static int getClickCnt() { // ��� Ŭ���ؾ��ϴ��� �˻����ְ� ���� ��ȯ���ش�.
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 0 && !isVisited[i][j]) { // 0���� �� �Ͷ߸���
					fill(i, j);
					cnt++;
				}
			}
		}
		// ������ �Ͷ߸���
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(map[i][j] > 0 && !isVisited[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void fill(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		isVisited[x][y] = true;
		while (!q.isEmpty()) {
			Pos current = q.poll();
			for (int d = 0; d < 8; ++d) {
				int nx = current.x + dir[0][d];
				int ny = current.y + dir[1][d];
				if (isAvailable(nx, ny) && !isVisited[nx][ny] && map[nx][ny] >= 0) {
					isVisited[nx][ny] = true;
					if (map[nx][ny] == 0) { // 0�̸� �ٽ� Ž���ؾ��ϹǷ� ť�� �߰�
						q.offer(new Pos(nx, ny));
					}
				}
			}
		}
	}

	static void updateMineCnt(Queue<Pos> mines) {
		while (!mines.isEmpty()) {
			Pos current = mines.poll();
			for (int d = 0; d < 8; ++d) {
				int nx = current.x + dir[0][d];
				int ny = current.y + dir[1][d];
				if (isAvailable(nx, ny) && map[nx][ny] != -1) {
					++map[nx][ny]; // ������ �߰����ش�.
				}
			}
			isVisited[current.x][current.y] = true; // �湮ó�����ش�.
		}
	}

	static boolean isAvailable(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
