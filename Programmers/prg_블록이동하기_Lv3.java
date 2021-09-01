import java.util.*;

public class prg_lv3_블록이동하기2 {

	static class Robot {
		int x, y;
		int dir;
		int sec;

		public Robot(int x, int y, int dir, int sec) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.sec = sec;
		}

	}

	static int R = 0, D = 1, L = 2, U = 3, dirCnt = 4;
	static int[][] dir = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } };// 우 하 좌 상
	static int map[][], N;

	static public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		map = board; // 복사해둔다.
		N = map.length; // 길이를 저장해둔다.
		Queue<Robot> q = new LinkedList<>(); // 로봇이 담길 큐
		boolean[][][] isVisited = new boolean[N][N][dirCnt]; // 방문 처리 배열 방향별 3차원
		q.offer(new Robot(0, 0, R, 0));// 첫 드론 위치를 넣어주고
		isVisited[0][0][R] = true; // 방문 처리해준다.

		while (!q.isEmpty()) { // 큐가 빌때 까지 반복해본다.
			Robot rb = q.poll();
			int[] tail = { rb.x + dir[0][rb.dir], rb.y + dir[1][rb.dir] }; // 꼬리 위치

			if (isGoalPos(rb.x, rb.y) || isGoalPos(tail[0], tail[1])) { // 머리나 꼬리중 도착하면 겜끝
				answer = Math.min(answer, rb.sec);
				break;
			}

			for (int d = 0; d < dirCnt; ++d) { // 4방향을 검사한다.
				int nheadx = rb.x + dir[0][d];
				int nheady = rb.y + dir[1][d];
				int ntailx = tail[0] + dir[0][d];
				int ntaily = tail[1] + dir[1][d];
				if (isBoundary(nheadx, nheady) && isBoundary(ntailx, ntaily) && !isVisited[nheadx][nheady][rb.dir]) {
					isVisited[nheadx][nheady][rb.dir] = true;
					q.offer(new Robot(nheadx, nheady, rb.dir, rb.sec + 1));
				}
			}

			for (int d = 1; d < dirCnt; d += 2) {
				int ndir = (rb.dir + d) % dirCnt; // 가로는 세로로 회전가능, 세로는 가로로 회전가능

				// 헤드 기준 회전
				if (isBoundary(rb.x + dir[0][ndir], rb.y + dir[1][ndir])
						&& isBoundary(tail[0] + dir[0][ndir], tail[1] + dir[1][ndir]) && !isVisited[rb.x][rb.y][ndir]) {
					isVisited[rb.x][rb.y][ndir] = true;
					q.offer(new Robot(rb.x, rb.y, ndir, rb.sec + 1));// 방향이 바뀐 헤드를 큐에 넣는다.
				}
				// 테일 기준 회전
				if (isBoundary(rb.x + dir[0][ndir], rb.y + dir[1][ndir])
						&& isBoundary(tail[0] + dir[0][ndir], tail[1] + dir[1][ndir])
						&& !isVisited[tail[0]][tail[1]][ndir]) {
					isVisited[tail[0]][tail[1]][ndir] = true;
					q.offer(new Robot(tail[0], tail[1], ndir, rb.sec + 1));// 방향이 바뀐 헤드를 큐에 넣는다.
				}
			}
		}
		return answer;
	}

	public static boolean isGoalPos(int x, int y) {
		if (x == N - 1 && y == N - 1)
			return true;
		return false;
	}

	public static boolean isBoundary(int x, int y) {
		if (0 > x || x >= N || 0 > y || y >= N)
			return false;
		else if (map[x][y] == 1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 },
				{ 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 } }));
	}

}
