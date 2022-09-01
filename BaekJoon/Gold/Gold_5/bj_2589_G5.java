import java.io.*;
import java.util.*;

/*
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
 */
public class bj_2589_G5 {
	static int X, Y, map[][];
	static final int Land = 1, Water = 0;
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } }; // 4방향 탐색
	static boolean[][] bfsVisited;// bfs에 사용할 거

	static class Pos { // 클래스 생성
		int x, y, cnt; // x,y좌표 / 현재 카운트

		Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		for (int i = 0; i < X; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < Y; ++j) {
				char WL = tmp.charAt(j);
				map[i][j] = WL == 'L' ? Land : Water; // 육지 0 바다 1
			}
		} // input 끝
		process();//처리시작
	}

	static void process() {
		int answer = 0;
		for (int i = 0; i < X; ++i) {
			for (int j = 0; j < Y; ++j) {
				if (map[i][j] == Land) {//땅이면 완탐으로 다돌려보기
					bfsVisited = new boolean[X][Y]; // 초기화
					answer = Math.max(answer, bfs(i, j)); // 젤장시간으로갱신
				}
			}
		}
		System.out.println(answer);//출력
	}

	static int bfs(int i, int j) {
		Queue<Pos> q = new LinkedList<>();// bfs큐만들고
		q.offer(new Pos(i, j, 0));// 큐에추가
		bfsVisited[i][j] = true; // 방문체크
		int val = 0;
		while (!q.isEmpty()) {// q 빌때까지 반복해주고
			Pos now = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now.x + dir[0][d];
				int ny = now.y + dir[1][d];
				if (isBoundary(nx, ny) && map[nx][ny] == Land && !bfsVisited[nx][ny]) {
					int nval = now.cnt + 1;
					q.offer(new Pos(nx, ny, nval));// q에 넣어준다.
					bfsVisited[nx][ny] = true;
					val = Math.max(val, nval);// 최장시간 갱신
				}
			}
		}
		return val;
	}

	static boolean isBoundary(int i, int j) { // 범위체크
		return 0 <= i && i < X && 0 <= j && j < Y;
	}
}
