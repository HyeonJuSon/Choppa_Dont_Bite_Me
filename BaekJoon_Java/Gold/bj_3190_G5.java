package gold;

import java.io.*;
import java.util.*;

public class bj_3190_G5 {

	static class Pos {
		int ox, oy;
		int nx, ny;

		Pos(int ox, int oy, int nx, int ny) {
			this.ox = ox;
			this.oy = oy;
			this.nx = nx;
			this.ny = ny;
		}
	}

	static class Order {
		int sec;
		char dir;

		public Order(int sec, char dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}

	static final int empty = 0, apple = 1;
	static int N, K, L, map[][];
	static char dir;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = apple;
		}
		L = Integer.parseInt(br.readLine());// 방향 회전 횟수
		Queue<Order> orders = new LinkedList<>();
		for (int i = 0; i < L; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			orders.offer(new Order(sec, dir));
		}
		ArrayList<Pos> snake = new ArrayList<>();
		snake.add(new Pos(0, 0, 0, 0));// 0,0에서 출발한다.
		int head = 0; // head
		int sec = 0;
		dir = 'R';
		boolean isGameOver = false;
		while (true) {
			if (!orders.isEmpty() && sec == orders.peek().sec) {
				dir = orders.poll().dir;
			}
			int hx = snake.get(head).nx;
			int hy = snake.get(head).ny;
			int beforeX, beforeY;
			switch (dir) {
			case 'U':
				if (isBoundary(hx - 1, hy)) { // 상
					if (map[hx - 1][hy] == apple) {// 사과가 있는지?
						++head; // 머리를 사과위치로옮겨주고
						snake.add(new Pos(hx,hy,hx - 1, hy));// 새로운 머리를 추가해준다.
					} else {
						snake.get(head).nx = snake.get(head).ox-1 ;
						
						for (int i = head - 1; i >= 0; --i) { // 전체 1칸이동
							snake.get(i).nx = snake.get(i+1).ox;//내부모의이전위치
							snake.get(i).ny = snake.get(i+1).oy;
						}
					}
				} else
					isGameOver = true;
				break;
			case 'D':
				if (isBoundary(hx + 1, hy)) { // 하
					if (map[hx + 1][hy] == apple) {// 사과가 있는지?
						++head;
						snake.add(new Pos(hx + 1, hy));
					} else {
						for (int i = 0; i < snake.size(); ++i) { // 전체 1칸이동
							++snake.get(i).x;
						}
					}
				} else
					isGameOver = true;
				break;
			case 'L':
				if (isBoundary(hx, hy - 1)) {// 좌
					if (map[hx][hy - 1] == apple) {// 사과가 있는지?
						++head;
						snake.add(new Pos(hx, hy - 1));
					} else {
						for (int i = 0; i < snake.size(); ++i) { // 전체 1칸이동
							--snake.get(i).y;
						}
					}
				} else
					isGameOver = true;
				break;
			case 'R':
				if (isBoundary(hx, hy + 1)) {// 우
					if (map[hx][hy + 1] == apple) {// 사과가 있는지?
						++head;
						snake.add(new Pos(hx, hy + 1));
					} else {
						for (int i = 0; i < snake.size(); ++i) { // 전체 1칸이동
							++snake.get(i).y;
						}
					}
				} else
					isGameOver = true;
				break;
			}
			if (isGameOver) {
				System.out.println(sec + 1);
				break;
			}
			++sec;
			// 방향별로 이동 위치에 사과가 있는지?
			// 있다면 사과위치를 head로해준다.
			// 없다면 사과위치로 이동한다.
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}
