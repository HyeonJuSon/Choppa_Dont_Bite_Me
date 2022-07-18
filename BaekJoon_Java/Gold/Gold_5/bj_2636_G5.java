package bj.gold;

/*
 * PROCESS
 * 1. 외부 공기 셋팅
 * 2. 녹일 치즈 찾기
 * 3. 녹일 치즈 개수 저장
 * 4. 치즈 녹이기
 * 5. 시간 증가(1시간씩)
 */

import java.util.*;
import java.io.*;

public class bj_2636_G5 {

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int X, Y, map[][];
	static Queue<Pos> meltCheeses = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		for (int i = 0; i < X; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < Y; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int hour = 0, cheeseCnt = 0;
		while (true) {
			// 1. 외부 공기를 세팅해준다.
			setAirCondition();
			// 2. 녹일 치즈를 찾는다.
			boolean[][] visitCheese = new boolean[X][Y];
			for (int i = 0; i < X; ++i) {
				for (int j = 0; j < Y; ++j) {
					if (map[i][j] == cheese && isMeltCheese(i, j)) {
						visitCheese[i][j] = true;
						bfs(i, j, visitCheese);
					}
				}
			}
			// 3. 녹일 치즈들의 개수 저장해두기 (개수도 출력해야하니까)
			if(meltCheeses.size() == 0) break; // 모두 녹였으면 그만둔다.
			cheeseCnt = meltCheeses.size();
			// 4. 실제로 치즈 녹여주기.
			while (!meltCheeses.isEmpty()) {
				Pos current = meltCheeses.poll();
				map[current.x][current.y] = air;
			}
			// 5. 한시간 흐르게 한다.
			hour++;
			
		}
		System.out.println(hour);
		System.out.println(cheeseCnt);
	}

	static final int air = -1, cheese = 1, melt = 2;

	// 1. 외부 공기 세팅
	static void setAirCondition() {
		boolean[][] visitAir = new boolean[X][Y];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0));
		visitAir[0][0] = true;
		map[0][0] = air;
		while (!q.isEmpty()) {
			Pos current = q.poll();

			for (int d = 0; d < 4; ++d) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				if (isAvailable(nx, ny) && !visitAir[nx][ny] && map[nx][ny] <= 0) {
					map[nx][ny] = air;
					visitAir[nx][ny] = true;
					q.offer(new Pos(nx, ny));
				}
			}
		}
	}

	// 2. 녹일 치즈 여부 확인
	static boolean isMeltCheese(int x, int y) {
		// 4방 탐색으로 주위에 -1이 하나라도 있으면 녹여야 하는 치즈
		for (int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (map[nx][ny] == air) return true;
		}
		return false;
	}

	// 3. 녹일 치즈들의 위치 찾기
	static void bfs(int x, int y, boolean[][] visitCheese) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y)); // 이 좌표값을 기준으로 주위에 녹일 치즈들을 찾는다.

		while (!q.isEmpty()) {
			Pos current = q.poll();
			// 새로 추가 된 위치가
			if (isMeltCheese(current.x, current.y)) {
				// 녹일 치즈들의 값을 바꿔준다
				map[current.x][current.y] = melt;
				// 녹일 치즈 위치들을 추가해준다.
				meltCheeses.offer(new Pos(current.x, current.y));
			}

			for (int d = 0; d < 4; ++d) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];

				if (isAvailable(nx, ny) && !visitCheese[nx][ny] && map[nx][ny] == cheese) {
					// 1.방문 체크
					visitCheese[nx][ny] = true;
					// 2.q에 추가
					q.offer(new Pos(nx, ny));
				}
			}
		}
	}

	// 배열의 범위를 넘어서지 않는지 검사
	static boolean isAvailable(int x, int y) {
		return x >= 0 && x < X && y >= 0 && y < Y;
	}
}
