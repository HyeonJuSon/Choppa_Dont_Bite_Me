package gold;

import java.io.*;
import java.util.*;

public class bj_3190_G5 {

	static class Order {
		int sec;
		String dir;

		Order(int sec, String dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}

	static int N, map[][];
	static final int blank = 0, wall = 1, apple = 2;
	static Queue<Order> orders = new LinkedList<>();
	static Deque<int[]> snakes = new LinkedList<>();
	static int[][] dir = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = stoi(br.readLine());
		map = new int[N][N];
		int appleCount = stoi(br.readLine());
		for (int i = 0; i < appleCount; ++i) {// apple 위치를 입력받는다.
			st = new StringTokenizer(br.readLine(), " ");
			map[stoi(st.nextToken()) - 1][stoi(st.nextToken()) - 1] = apple;
		}
		int orderCount = stoi(br.readLine());
		for (int i = 0; i < orderCount; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			orders.offer(new Order(stoi(st.nextToken()), st.nextToken()));
		}
		System.out.println(process());
	}

	static int process() {
		snakes.offer(new int[] { 0, 0 });// 뱀의 첫 위치.
		int time = 0;// 현재 시간
		int snakeDir = 0;// R 0 D 1 L 2 R 3
		boolean isGameOver = false;
		while (true) { // 게임이 끝날때까지.
			++time;
			int[] newHead = {snakes.getLast()[0] + dir[0][snakeDir], snakes.getLast()[1] + dir[1][snakeDir]};
			if (!isBoundary(newHead[0], newHead[1]) || isCrashBody(newHead)) {//새로이동할 위치가 벽이면 게임오버.
				isGameOver = true;
				break;
			}
			snakes.offer(newHead); // 괜찮으면 넣어준다.
			// 이동할 위치가 사과가 있는지 없는지 여부.
			if (isApple(snakes.getLast()[0], snakes.getLast()[1])) {
				map[snakes.getLast()[0]][snakes.getLast()[1]] = blank; // 사과를 비운다.
			} else { // 사과가 없으면 꼬리를 자른다.
				snakes.pollFirst();
			}
			
			// 회전
			if (!orders.isEmpty() && time == orders.peek().sec) { // 명령을 수행할 수 있는 초가 지났다면
				String newDir = orders.poll().dir; // 새로운 방향을 입력받는다.
				snakeDir = newDir.equals("D") ? snakeDir + 1 : snakeDir - 1;
				snakeDir = snakeDir < 0 ? 3 : (snakeDir > 3 ? 0 : snakeDir); // 값 보정
			}

			if (isGameOver) break;
		}

		return time;
	}

	static boolean isCrashBody(int[] head) {
		for(int[] now : snakes) {
			if(now[0] == head[0] && now[1]==head[1]) return true;
		}
		return false;
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static boolean isApple(int x, int y) {
		return map[x][y] == apple;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
