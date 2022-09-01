package gold;

import java.io.*;
import java.util.*;

public class bj_19236_G2 {

	static int N = 4; // 4*4 ���
	static int[][] direction = { { -1, -1, 0, 1, 1, 1, 0, -1 }, { 0, -1, -1, -1, 0, 1, 1, 1 } };// ��ء�ס�١��

	static class Fish {
		int num;
		int x, y;
		int dir;

		Fish(int num, int x, int y, int dir) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		Fish(Fish f) {
			this.num = f.num;
			this.x = f.x;
			this.y = f.y;
			this.dir = f.dir;
		}
	}

	static class Info {
		Fish shark; // ���� ��� ����
		int sum; // ���� �� ���� ������� ��
		Fish[][] map; // ���� ������� ����
		TreeMap<Integer, int[]> fishPos; // ���� ������� index �� ��ġ ����

		Info(int x, int y, int dir, int sum, Fish[][] map, TreeMap<Integer, int[]> fishPos) {
			shark = new Fish(-1, x, y, dir);
			this.sum = sum;
			this.map = new Fish[N][N];

			copy(map);
			this.fishPos = new TreeMap<>();
			copy(fishPos);
		}

		private void copy(Fish[][] map) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					this.map[i][j] = map[i][j];
				}
			}
		}

		private void copy(TreeMap<Integer, int[]> fishPos) {
			this.fishPos.clear();
			for (Integer key : fishPos.keySet()) {
				this.fishPos.put(key, fishPos.get(key));
			}
		}
	}

	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Fish[][] map = new Fish[N][N]; // ����� ������ ������ ��
		TreeMap<Integer, int[]> fishPos = new TreeMap<>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = new Fish(idx, i, j, dir);
				fishPos.put(idx, new int[] { i, j });
			}
		}
		// queue shark �� map ��Ȳ�� ����ݴϴ�.
		Queue<Info> bfs = new LinkedList<>();
		Fish srk = new Fish(map[0][0]);
		fishPos.remove(map[0][0].num);// �����ش�.
		map[0][0] = null;
		bfs.add(new Info(0, 0, srk.dir, srk.num, map, fishPos));

		while (!bfs.isEmpty()) {
			Info now = bfs.poll();
			Object[] k = now.fishPos.keySet().toArray();
			Arrays.sort(k);
			// 1. ����� �̵�
			for (Integer key : now.fishPos.keySet()) { // ����� ��ȣ ������� ����⸦ �̵� ��Ų��.
				int[] pos = now.fishPos.get(key);
				Fish fish = now.map[pos[0]][pos[1]]; // ���� ������� ������ �� �����´�.
				int nx = pos[0] + direction[0][fish.dir];
				int ny = pos[1] + direction[1][fish.dir];
				boolean isPossible = true;
				if (!isBoundary(nx, ny) || (nx == now.shark.x && ny == now.shark.y)) {
					// �̵� ������ �� ���� ȸ�� ��Ų��.
					int cnt = 1; // 8�̵Ǹ� � �������ε� �̵��� �Ұ���.
					int nDir = fish.dir;
					while (true) {
						nDir = (nDir + 1 + 8) % 8; // 45 �ݽð� ȸ�� ������ �����´�.
						int tx = fish.x + direction[0][nDir];
						int ty = fish.y + direction[1][nDir];
						if (isBoundary(tx, ty) && (tx != now.shark.x || ty != now.shark.y)) {
							fish.dir = nDir;// ������� ������ �������ش�.
							nx = tx;
							ny = ty;
							break;
						}
						if (++cnt >= 8) {
							isPossible = false;
							break; // � �������ε� �̵��� �Ұ����ϸ� �׸��д�.
						}
					}
				}
				// ȸ���������� ���ǿ� ���� ������ �н�
				if (!isPossible)
					continue;
				// �̵��Ϸ��� ��ġ�� ��ĭ�̸�
				if (now.map[nx][ny] == null) {
					// map �� ������ �������ְ�
					now.map[nx][ny] = new Fish(fish.num, nx, ny, fish.dir);
					now.map[fish.x][fish.y] = null;
					// ��ġ ������ �������ش�.
					now.fishPos.put(fish.num, new int[] { nx, ny });
				} else if (now.map[nx][ny] != null) {
					// �̵��Ϸ��� ��ġ�� ������̸�
					Fish tmp = new Fish(now.map[nx][ny]);
					now.map[nx][ny] = new Fish(fish.num, nx, ny, fish.dir);
					now.fishPos.put(fish.num, new int[] { nx, ny });

					now.map[fish.x][fish.y] = new Fish(tmp.num, fish.x, fish.y,tmp.dir);
					now.fishPos.put(tmp.num, new int[] { fish.x, fish.y });
				}
			}
			// 2. ��� �̵�
			Queue<int[]> movableList = getMovable(now.shark.x, now.shark.y, now.shark.dir, now.map);// ����� �̵� ������ ��ġ��
																									// �޾ƿ´�.
			// �̵� ������ ��ġ�� ������ �����Ѵ�.
			if (movableList.isEmpty()) {
				answer = Math.max(answer, now.sum);
				continue;
			} else {
				// �ش� ��ġ�� ������ ���� ť�� �־��ش�.
				while (!movableList.isEmpty()) {
					int[] pos = movableList.poll();
					Fish f = now.map[pos[0]][pos[1]];
					TreeMap<Integer, int[]> tmpPos = new TreeMap<>(now.fishPos);
					tmpPos.remove(f.num);
					Fish[][] tmpMap = new Fish[N][N]; // ���ο� ���� �����Ѵ�.
					for (int i = 0; i < N; ++i) {
						for (int j = 0; j < N; ++j) {
							if (f.x == i && f.y == j) // ���� ������ ������ 
								continue;
							if (now.map[i][j] == null)
								continue;
							tmpMap[i][j] = new Fish(now.map[i][j]);
						}
					}
					bfs.add(new Info(f.x, f.y, f.dir, now.sum + f.num, tmpMap, tmpPos));
				}
			}
		}
		System.out.println(answer);
	}

	static Queue<int[]> getMovable(int x, int y, int dir, Fish[][] map) {
		Queue<int[]> answer = new LinkedList<>();
		for (int i = 1; i <= N; ++i) {
			int nx = x + direction[0][dir] * i;
			int ny = y + direction[1][dir] * i;
			if (!isBoundary(nx, ny))
				continue;
			if (map[nx][ny] == null)
				continue;
			answer.add(new int[] { nx, ny });
		}
		return answer;
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
