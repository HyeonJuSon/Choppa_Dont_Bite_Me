package gold;

import java.io.*;
import java.util.*;

public class bj_19238_G3 {

	static int N, M, fuel;
	static int[] driver;
	static ArrayList<int[]> start, end; // 출발지, 도착지
	static int[][] distMap, map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N]; // 벽이 있는지 여부 판별 용
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 운전사 위치 초기화
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		driver = new int[] { x, y };
		// 승객 정보
		start = new ArrayList<int[]>();
		end = new ArrayList<int[]>();

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			start.add(new int[] { sx, sy }); // 출발지 리스트에 넣어둔다.
			end.add(new int[] { ex, ey }); // 도착지 리스트에 넣어둔다.
		}
		// 운영 시작한다.
		while (true) {
			// 1. 가장 가까운 승객을 찾는다.
			int nearest = getNearest();
			if (nearest == -1) break;
			// 2. 손님을 이동 시킨다.
			drive(nearest);
			if(fuel==0) break;
			// 4. M이 0이면 그만둔다. (모두 태워줌)
			if(M==0) break;
		}
		// M 1이상이면 -1 출력
		if(M>0) System.out.println(-1);
		else System.out.println(fuel); // 연료를 출력한다.
	}

	static void drive(int nearest) {
		int[] customer = start.get(nearest); // 승객 위치를 불러온다.
		// 현재 위치에서 연료를 계산한다.
		fuel = fuel - distMap[customer[0]][customer[1]];
		if (fuel < 0 || distMap[customer[0]][customer[1]]==-1) { // 이동이 안되므로 -1 출력 후 종료
			System.out.println(-1);
			System.exit(0);
		}

		// 운전자의 위치를 현 위치로 갱신한다.
		driver[0] = customer[0];
		driver[1] = customer[1];
		// 운전자 위치 기준 새로운 distMap을 갱신한다.
		initDistMap();
		// 고객의 종점을 가져온다.
		customer = end.get(nearest);
		// 연료를 계산한다.
		fuel = fuel - distMap[customer[0]][customer[1]];
		if (fuel < 0 || distMap[customer[0]][customer[1]]==-1) { // 이동이 안되므로 -1 출력 후 종료
			System.out.println(-1);
			System.exit(0);
		}
		// 목적지에 도착했으므로 새로운 연료를 충전한다.
		fuel += distMap[customer[0]][customer[1]] * 2;
		// 목적지 위치로 운전자의 위치를 갱신한다.
		driver[0]= customer[0];
		driver[1]= customer[1];
		// 해당 승객을 지운다.
		start.remove(nearest);
		end.remove(nearest);
		--M;
	}

	static int[][] dir = { { -1, 0, 0, 1 }, { 0, -1, 1, 0 } }; // 상,좌,우,하 -> 행 렬 작은 순

	static void initDistMap() {
		distMap = new int[N][N];
		for(int i=0;i<N;++i) Arrays.fill(distMap[i],-1);
		distMap[driver[0]][driver[1]]= 0;
		boolean[][] isVisited = new boolean[N][N];
		Queue<int[]> bfs = new LinkedList<>();
		bfs.add(driver);
		isVisited[driver[0]][driver[1]] = true;
		while (!bfs.isEmpty()) {
			int[] now = bfs.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now[0] + dir[0][d];
				int ny = now[1] + dir[1][d];
				if (isBoundary(nx, ny) && !isVisited[nx][ny] && map[nx][ny] != 1) {
					isVisited[nx][ny] = true;
					distMap[nx][ny] = distMap[now[0]][now[1]] + 1;
					bfs.add(new int[] { nx, ny });
				}
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static int getNearest() {
		initDistMap();

		int minDist = N * N;
		int minIdx = -1;
		int x = N, y=N;
		for (int i = 0; i < M; ++i) {
			int[] people = start.get(i);
			int dist = distMap[people[0]][people[1]];
			if (dist < minDist) {
				minDist = dist;
				minIdx = i;
				x = people[0];
				y = people[1];
			}else if(dist == minDist) {
				if(x > people[0]) {
					minIdx = i;
					x = people[0];
					y = people[1];
				}else if(x==people[0]){
					if(y > people[1]) {
						minIdx = i;
						x = people[0];
						y = people[1];
					}
				}
			}
		}
		return minIdx;
	}
}
