package gold;

import java.io.*;
import java.util.*;

public class bj_23288_G3 {

	static int N, M, K, map[][], nowDirection;
	static final int East = 0, West = 1, South = 2, North = 3;
	static int[][] dice = { { 0, 2, 0 }, { 4, 1, 3 }, { 0, 5, 0 }, { 0, 6, 0 } };
	static int maxCnt = 0, maxSum = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nowDirection = East;
		int answer = 0;
		// K번 이동한다.
		for (int k = 0; k < K; ++k) {
			moveDice(0, 0); // 0,0에서 출발
			answer = maxSum*dice[1][1];
		}
		System.out.println(answer);
	}

	// 주사위 이동 메소드
	static int[][] dir = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } };// 동,서,남,북

	static class Node {
		int x, y, d;
		int cnt;
		int sum;

		Node(int x, int y, int d, int cnt, int sum) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
			this.sum = sum;
		}
	}

	static void moveDice(int x, int y) {

		boolean[][] isVisited = new boolean[N][M];
		isVisited[x][y] = true;
		Queue<Node> bfs = new LinkedList<>();
		bfs.offer(new Node(x, y, nowDirection, 0, 0));

		while (!bfs.isEmpty()) {
			Node current = bfs.poll();
			if (maxCnt < current.cnt) {
				maxCnt = current.cnt;
				maxSum = Math.max(maxSum, current.sum);
			}
			int nx = x + dir[0][current.d];
			int ny = y + dir[1][current.d];
			if (!isBoundary(nx, ny)) {
				reverseDirection(current.d);
				nx = x + dir[0][current.d];
				ny = y + dir[1][current.d];
			}
			if (!isVisited[nx][ny]) {
				// 주사위 돌리고
				rotateDice(current.d);
				// 방문체크하고
				isVisited[nx][ny] = true;
				// bfsQ에 담는다
				bfs.offer(new Node(nx, ny, changeDirection(current.d, map[nx][ny]), current.cnt + 1,
						current.sum + map[nx][ny]));
			}
		}
	}

	static int changeDirection(int direction, int B) {
		int A = dice[1][1];
		int newDirection = direction;
		if (A > B) { // 시계방향90도
			newDirection += 2;
			if (direction == South || direction == North)
				newDirection %= 4;
		} else if (A < B) { // 반시계방향90도
			newDirection -= 2;
			if (direction == East || direction == West)
				newDirection *= -1;
		}
		return newDirection;
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	static void reverseDirection(int direction) {
		if (direction <= West)
			direction = Math.abs(direction - 1);
		else
			direction = Math.abs(direction - 5);
	}

	static void rotateDice(int direction) {
		switch (direction) {
		case East:
			rotateEast();
			break;
		case West:
			rotateWest();
			break;
		case South:
			rotateSouth();
			break;
		case North:
			rotateNorth();
			break;
		}
	}

	static void rotateEast() {
		int[][] tmp = new int[4][3];
		tmp[0][1] = dice[0][1];
		tmp[2][1] = dice[2][1];
		for (int j = 0; j < 2; ++j)
			tmp[1][j + 1] = dice[1][j];
		tmp[1][0] = dice[3][1];
		tmp[3][1] = dice[1][2];
		dice = tmp;
	}

	static void rotateWest() {
		int[][] tmp = new int[4][3];
		tmp[0][1] = dice[0][1];
		tmp[2][1] = dice[2][1];
		for (int j = 1; j < 3; ++j)
			tmp[1][j - 1] = dice[1][j];
		tmp[1][2] = dice[3][1];
		tmp[3][1] = dice[1][0];
		dice = tmp;
	}

	static void rotateSouth() {
		int[][] tmp = new int[4][3];
		// 전개도 왼, 우 는 똑같음
		for (int i = 0; i < 4; ++i) {
			tmp[i][0] = dice[i][0];
			tmp[i][2] = dice[i][2];
		}
		// 중앙은 한칸씩 위로간다.
		for (int i = 1; i < 4; ++i) {
			tmp[i][1] = dice[i][1];
		}
		tmp[3][1] = dice[0][1];
		dice = tmp; // 갱신
	}

	static void rotateNorth() {
		int[][] tmp = new int[4][3];
		// 전개도 왼, 우 는 똑같음
		for (int i = 0; i < 4; ++i) {
			tmp[i][0] = dice[i][0];
			tmp[i][2] = dice[i][2];
		}
		// 중앙은 한칸씩 아래로 간다
		for (int i = 0; i < 3; ++i) {
			tmp[i + 1][1] = dice[i][1];
		}
		tmp[0][1] = dice[3][1];
		dice = tmp;
	}

}
