
import java.io.*;
import java.util.*;

public class bj_20058_G4 {

	static int N, Q, map[][], copyMap[][], size;
	static Queue<Integer> queueL = new LinkedList<>();
	static public int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken());
		Q = stoi(st.nextToken());
		size = (1 << N); // N최대 6이라서 2^6=64라서 int로 해도 될듯
		map = new int[size][size];
		copyMap = new int[size][size];
		for (int i = 0; i < size; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < size; ++j) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Q; ++i)
			queueL.offer(stoi(st.nextToken()));
		process();
	}

	public static void process() {
		while (!queueL.isEmpty()) { // Q번 실행할 때 까지 반복한다.
			int L = (1 << queueL.poll());// 현재 L을 뽑아서 2^L로 만들어서 저장.
			copyMap(); // 맵을 복사한다.
			for (int i = 0; i < size; i += L) { // 1. 부분 배열들을 회전시킨다.
				for (int j = 0; j < size; j += L) {
					rotate(i, j, L);
				}
			}
			// 2. 녹인다.
			melt();
		}
		// 남아있는 얼음의 합을 구하자.
		System.out.println(getIceSum());
		// 남아있는 얼음 중 가장 큰 덩어리를 차지하는 칸의 개수
		System.out.println(getBiggestIce());
	}

	public static void rotate(int x, int y, int L) {
		for (int i = 0; i < L; ++i) {
			for (int j = 0; j < L; ++j) {
				copyMap[j][L - 1 - i] = map[x + i][y + j];
			}
		}
		for (int i = 0; i < L; ++i) {
			for (int j = 0; j < L; ++j) {
				map[x + i][y + j] = copyMap[i][j];
			}
		}
	}

	public static void melt() {
		Queue<int[]> melts = new LinkedList<>();
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				int cnt = 0;
				for (int d = 0; d < 4; ++d) {
					int nx = i + dir[0][d];
					int ny = j + dir[1][d];
					if (isBoundary(nx, ny) && map[nx][ny] > 0) { // 구역 내에 있고 얼음이 있다면
						++cnt; // 얼음개수
					}
				}
				if (cnt < 3)
					melts.offer(new int[] { i, j });
			}
		}
		// 녹인다.
		while (!melts.isEmpty()) {
			int[] current = melts.poll();
			--map[current[0]][current[1]];
		}
	}

	public static void copyMap() {
		for (int i = 0; i < size; ++i) { // map 복사.
			for (int j = 0; j < size; ++j) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	public static int getBiggestIce() {
		int big = Integer.MIN_VALUE;
		boolean[][] isVisited = new boolean[size][size];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (!isVisited[i][j] && map[i][j] > 0) { // 미방문이고 얼음이 있으면
					isVisited[i][j] = true;
					big = Math.max(big, bfs(i, j, isVisited));
				}
			}
		}
		return big;
	}

	public static int bfs(int x, int y, boolean[][] isVisited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];
				if (isBoundary(nx, ny) && map[nx][ny] > 0 && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true; // 방문 처리하고
					q.offer(new int[] { nx, ny });
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int getIceSum() {
		int sum = 0;
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if(map[i][j]>0) sum += map[i][j];
			}
		}
		return sum;
	}

	public static boolean isBoundary(int x, int y) {
		return 0 <= x && x < size && 0 <= y && y < size;
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map.length; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] rotation(int[][] partMap) {
		int L = partMap.length;
		int[][] rotationMap = new int[L][L];
		int x = 0, y = 0;
		// 90도 오른쪽 회전은 마지막행이 첫 열이됨.
		for (int i = L - 1; i >= 0; --i) { // 마지막 행부터
			x = 0;
			for (int j = 0; j < L; ++j) {
				rotationMap[x++][y] = partMap[i][j];
			}
			y++;
		}
		// rotation결과를 반환한다
		return rotationMap;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
