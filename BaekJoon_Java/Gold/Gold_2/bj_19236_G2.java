package gold;

import java.io.*;
import java.util.*;

public class bj_19236_G2 {

	static int N = 4; // 4*4 행렬
	static int[][] direction = { { -1, -1, 0, 1, 1, 1, 0, -1 }, { 0, -1, -1, -1, 0, 1, 1, 1 } };// ↑↖←↙↓↘→↗

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
		Fish shark; // 현재 상어 정보
		int sum; // 현재 상어가 먹은 물고기의 합
		Fish[][] map; // 현재 물고기의 정보
		TreeMap<Integer, int[]> fishPos; // 현재 물고기의 index 별 위치 정보

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
		Fish[][] map = new Fish[N][N]; // 물고기 정보를 저장할 맵
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
		// queue shark 및 map 현황을 담아줍니다.
		Queue<Info> bfs = new LinkedList<>();
		Fish srk = new Fish(map[0][0]);
		fishPos.remove(map[0][0].num);// 지워준다.
		map[0][0] = null;
		bfs.add(new Info(0, 0, srk.dir, srk.num, map, fishPos));

		while (!bfs.isEmpty()) {
			Info now = bfs.poll();
			Object[] k = now.fishPos.keySet().toArray();
			Arrays.sort(k);
			// 1. 물고기 이동
			for (Integer key : now.fishPos.keySet()) { // 물고기 번호 순서대로 물고기를 이동 시킨다.
				int[] pos = now.fishPos.get(key);
				Fish fish = now.map[pos[0]][pos[1]]; // 현재 물고기의 정보를 다 가져온다.
				int nx = pos[0] + direction[0][fish.dir];
				int ny = pos[1] + direction[1][fish.dir];
				boolean isPossible = true;
				if (!isBoundary(nx, ny) || (nx == now.shark.x && ny == now.shark.y)) {
					// 이동 가능할 때 까지 회전 시킨다.
					int cnt = 1; // 8이되면 어떤 방향으로도 이동이 불가함.
					int nDir = fish.dir;
					while (true) {
						nDir = (nDir + 1 + 8) % 8; // 45 반시계 회전 방향을 가져온다.
						int tx = fish.x + direction[0][nDir];
						int ty = fish.y + direction[1][nDir];
						if (isBoundary(tx, ty) && (tx != now.shark.x || ty != now.shark.y)) {
							fish.dir = nDir;// 물고기의 방향을 변경해준다.
							nx = tx;
							ny = ty;
							break;
						}
						if (++cnt >= 8) {
							isPossible = false;
							break; // 어떤 방향으로도 이동이 불가능하면 그만둔다.
						}
					}
				}
				// 회전했음에도 조건에 맞지 않으면 패스
				if (!isPossible)
					continue;
				// 이동하려는 위치가 빈칸이면
				if (now.map[nx][ny] == null) {
					// map 의 정보를 변경해주고
					now.map[nx][ny] = new Fish(fish.num, nx, ny, fish.dir);
					now.map[fish.x][fish.y] = null;
					// 위치 정보도 갱신해준다.
					now.fishPos.put(fish.num, new int[] { nx, ny });
				} else if (now.map[nx][ny] != null) {
					// 이동하려는 위치가 물고기이면
					Fish tmp = new Fish(now.map[nx][ny]);
					now.map[nx][ny] = new Fish(fish.num, nx, ny, fish.dir);
					now.fishPos.put(fish.num, new int[] { nx, ny });

					now.map[fish.x][fish.y] = new Fish(tmp.num, fish.x, fish.y,tmp.dir);
					now.fishPos.put(tmp.num, new int[] { fish.x, fish.y });
				}
			}
			// 2. 상어 이동
			Queue<int[]> movableList = getMovable(now.shark.x, now.shark.y, now.shark.dir, now.map);// 상어의 이동 가능한 위치를
																									// 받아온다.
			// 이동 가능한 위치가 없으면 갱신한다.
			if (movableList.isEmpty()) {
				answer = Math.max(answer, now.sum);
				continue;
			} else {
				// 해당 위치별 정보를 만들어서 큐에 넣어준다.
				while (!movableList.isEmpty()) {
					int[] pos = movableList.poll();
					Fish f = now.map[pos[0]][pos[1]];
					TreeMap<Integer, int[]> tmpPos = new TreeMap<>(now.fishPos);
					tmpPos.remove(f.num);
					Fish[][] tmpMap = new Fish[N][N]; // 새로운 맵을 생성한다.
					for (int i = 0; i < N; ++i) {
						for (int j = 0; j < N; ++j) {
							if (f.x == i && f.y == j) // 현재 물고기는 먹혔음 
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
