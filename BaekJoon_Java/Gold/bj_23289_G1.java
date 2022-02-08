package gold;

import java.io.*;
import java.util.*;

public class bj_23289_G1 {

	static int R, C, K, wallCnt;
	static int[][] map;
	static boolean[][][] wallMap;

	static class Hit {
		int x, y, dir;

		Hit(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static class Wind {
		int x, y, dir, degree;

		Wind(int x, int y, int dir, int degree) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.degree = degree;
		}
	}

	static ArrayList<Hit> hitter = new ArrayList<>();
	static ArrayList<int[]> checkZone = new ArrayList<>();
	static int[][][] spreadDir = { { { -1, 0, 1 }, { 1, 1, 1 } }, // 우
			{ { -1, 0, 1 }, { -1, -1, -1 } }, // 좌
			{ { -1, -1, -1 }, { -1, 0, 1 } }, // 상
			{ { 1, 1, 1 }, { -1, 0, 1 } } // 하
	}; // 온풍기가 퍼지는 방향
	static final int East = 0, West = 1, North = 2, South = 3;
	static int[][] dir = { { 0, 0, -1, 1 }, { 1, -1, 0, 0 } }; // 방향별 출발지점을 위한 것

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// R, C, K 저장
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 맵 저장
		map = new int[R][C]; // 온도 체크용 배열
		wallMap = new boolean[R][C][4]; // 벽 체크용 배열
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; ++j) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 0)
					map[i][j] = val;
				else if (val == 5)
					checkZone.add(new int[] { i, j }); // 조사해야할 위치 저장
				else
					hitter.add(new Hit(i, j, val - 1)); // 온풍기 위치 저장
			}
		}
		// 벽 위치 저장
		wallCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < wallCnt; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			if (t == 0) {
				wallMap[x][y][North] = true;
				wallMap[x - 1][y][South] = true;
			} else if (t == 1) {
				wallMap[x][y][East] = true;
				wallMap[x][y + 1][West] = true;
			}
		}
		
		// 온풍기 시작
		int chocolate = 0;
		while (true) {
			// 1. 온풍기 1회
			hitting();
			// 2. 온도조절
			generating();
			// 3. 바깥쪽 온도 1감소
			minusBoundary();
			// 4. 초콜릿
			++chocolate;
			// 4-1. 초콜릿이 101이상?
			if(chocolate > 100) break;
			// 5. 전체 공간 온도 K이상?
			if (isOver())
				break;
		}
		System.out.println(chocolate);
	}

	// 1. 온풍기 1회
	static void hitting() {
		for (int i = 0; i < hitter.size(); ++i) {
			int direction = hitter.get(i).dir; // 히터가 바람을 쏘는 방향
			// 방향별 출발점 체크
			int x = hitter.get(i).x + dir[0][direction];
			int y = hitter.get(i).y + dir[1][direction];
			boolean[][] isVisited = new boolean[R][C];
			isVisited[x][y] = true;
			Queue<Wind> q = new LinkedList<>();
			q.add(new Wind(x, y, direction, 5));
			map[x][y] += 5; // 시작 지점은 5
			while (!q.isEmpty()) {
				Wind now = q.poll();
				if(now.degree==0) continue;
				for (int d = 0; d < 3; ++d) {
					// 퍼져나갈 위치
					int nx = now.x + spreadDir[now.dir][0][d];
					int ny = now.y + spreadDir[now.dir][1][d];
					// 위치가 범위 안에 있는지
					if (!isBoundary(nx,ny))	continue;
					if(isVisited[nx][ny]) continue;
					// 퍼질 위치에 이동가능한지 (벽은없는지)
					if (isWall(now.x, now.y, nx, ny, now.dir, d)) continue;
					map[nx][ny] += now.degree-1;// 퍼뜨려주고(온풍기2대일수잇어서+처리)
					isVisited[nx][ny] = true;// 방문처리
					q.add(new Wind(nx, ny, now.dir,now.degree-1));// 큐에 추가
				}
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}

	static boolean isWall(int x, int y, int nx, int ny, int d, int idx) {
		if (idx == 0) { // 좌
			if (d == East) {
				if (wallMap[x][y][North] || wallMap[nx][ny][West])
					return true;
			} else if (d == West) {
				if (wallMap[x][y][North] || wallMap[nx][ny][East])
					return true;
			} else if (d == North) {
				if (wallMap[x][y][West] || wallMap[nx][ny][South])
					return true;
			} else {
				if (wallMap[x][y][West] || wallMap[nx][ny][North])
					return true;
			}
		} else if (idx == 1) { // 중간
			if (wallMap[x][y][d])
				return true;
		} else if (idx == 2) { // 우
			if (d == East) {
				if (wallMap[x][y][South] || wallMap[nx][ny][West])
					return true;
			} else if (d == West) {
				if (wallMap[x][y][South] || wallMap[nx][ny][East])
					return true;
			} else if (d == North) {
				if (wallMap[x][y][East] || wallMap[nx][ny][South])
					return true;
			} else {
				if (wallMap[x][y][East] || wallMap[nx][ny][North])
					return true;
			}
		}
		return false;
	}

	// 2. 온도 조절
	static void generating() {
		int[][] result = new int[R][C];
		boolean[][] isVisited =new boolean[R][C];
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
					int val = map[i][j];
					isVisited[i][j] = true;
					for (int d = 0; d < 4; ++d) {
						int nx = i + dir[0][d];
						int ny = j + dir[1][d];
						if (!isBoundary(nx,ny))	continue;
						if (wallMap[i][j][d]) continue;
						if(isVisited[nx][ny]) continue;
						int newVal = 0;
						if (val > map[nx][ny]) {
							newVal = (val-map[nx][ny])/4;
							result[i][j] -= newVal;
							result[nx][ny] += newVal;
						} else {
							newVal = (map[nx][ny]-val)/4;
							result[i][j] += newVal;
							result[nx][ny] -= newVal;
						}
					}
			}
		}
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
					map[i][j] += result[i][j];
			}
		}
	}

	// 3. 바깥쪽 온도 1감소
	static void minusBoundary() {
		boolean[][] isVisited = new boolean[R][C];
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (isVisited[i][j]||map[i][j]==0)
					continue;
				if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
					isVisited[i][j] = true;
					--map[i][j];
				}
			}
		}
	}

	// 5. 전체 공간 온도 K이상?
	static boolean isOver() {
		boolean answer = true;
		for (int[] now : checkZone) {
			if (map[now[0]][now[1]] < K) {
				answer = false; // 하나라도 아니면 바로 탈락
				break;
			}
		}
		return answer;
	}
}
