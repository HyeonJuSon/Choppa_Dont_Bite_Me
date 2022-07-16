package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class bj_16236_G4 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, count = 0, time = 0, sharkSize = 2;
	static int[][] map, distMap;
	static boolean[][] visited;
	static Pos p = null;
	static ArrayList<Pos> fishesList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		distMap = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					p = new Pos(i, j);
			}
		}

		while (true) {
			find(p);
			if (fishesList.size() == 0) break; // 엄마를 부른다
			p = getEatPos(); // 아기상어를 먹은 물고기 위치로 이동시킨다.
			visited = new boolean[N][N];
			distMap = new int[N][N];
		}
		System.out.println(time);
	}

	// 아기상어가 이동하면서 먹을 수 있는 물고기의 좌표를 담는다.
	static void find(Pos d) {
		fishesList = new ArrayList<Pos>();
		Queue<Pos> findList = new LinkedList<Pos>();		//탐색해야할 목록
		visited[d.x][d.y] = true; // 방문처리
		findList.add(d);// 현재 상어위치를 넣어준다.

		while (!findList.isEmpty()) { // 큐가 빌때까지 반복
			Pos t = findList.remove(); // 임시 위치값을 받아들이고.
			int x = t.x;
			int y = t.y;
			// 아기상어가 아닌 물고기라면 물고기 리스트에 넣어준다.
			if (map[x][y] < sharkSize && map[x][y] >= 1 && map[x][y] <= 6) fishesList.add(new Pos(x, y));
			// 4방 탐색을 한다.
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isRange(nx, ny) && distMap[nx][ny] == 0 && map[nx][ny] <= sharkSize) {
					findList.add(new Pos(nx, ny));
					distMap[nx][ny] = distMap[x][y] + 1; // 거리
					visited[nx][ny] = true;// 방문처리
				}
			}
		}

	}

	static boolean isRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) return false;
		if (visited[x][y]) return false;
		return true;
	}

	// 최소거리에 있는 물고기를 먹겠다.
	static Pos getEatPos() {
		PriorityQueue<Integer> distance = new PriorityQueue<>();
		ArrayList<int[]> minDistFishes = new ArrayList<>();
		// 최소 거리 구하기
		for (int i = 0; i < fishesList.size(); i++) {
			distance.add(distMap[fishesList.get(i).x][fishesList.get(i).y]);
		}
		// 제일 작은 거리를 구한다.
		int shortestDist = distance.peek();

		// 최소 거리의 x,y 좌표 구하기
		for (int i = 0; i < fishesList.size(); i++) {
			if (distMap[fishesList.get(i).x][fishesList.get(i).y] == shortestDist) {
				minDistFishes.add(new int[] {fishesList.get(i).x, fishesList.get(i).y});
			}
		}
		// x,y의 최소값(제일 상단,여러개면 제일 좌측)
		Collections.sort(minDistFishes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		// 최소 위치의 물고기 찾기
		Pos minPos = new Pos(minDistFishes.get(0)[0], minDistFishes.get(0)[1]);
		// 아기상어가 먹이를 먹고 이동
		map[p.x][p.y] = 0;
		map[minPos.x][minPos.y] = 9;
		// 먹이를 먹은 수 체크해서 shark_size와 같으면 sharkSize 증가하고 먹은 count를 다시 0으로
		if (++count == sharkSize) {
			sharkSize++;
			count = 0;
		}
		// 최소 거리 시간만큼 더해주기
		time += shortestDist;

		return minPos;
	}
}