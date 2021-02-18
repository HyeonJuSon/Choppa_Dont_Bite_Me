package BJ;
import java.io.*;
import java.util.*;
public class bj_1012 {
	static int M, N, K, Cnt; 						// M - 가로, N - 세로, K - 배추의 개수, 지렁이 개수
	static int[][] ground; 							// 배추 밭.
	static int[] dx = { -1, 1, 0, 0 }; 				// 행 방향
	static int[] dy = { 0, 0, -1, 1 }; 				// 열 방향
	static boolean isFirst;							// 카운팅 플래그
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); 	// 테케 입력
		for (int tc = 1; tc <= T; ++tc) { 			// 테케수 만큼 반복
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); 	// M - 가로
			N = Integer.parseInt(st.nextToken()); 	// N - 세로
			K = Integer.parseInt(st.nextToken());	// K - 배추 개수
			ground = new int[M][N]; 				// 배추 밭 할당
			Cnt = 0;								// 카운트 초기화
			for (int i = 0; i < K; ++i) { 			// 배추 개수 만큼 반복
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = 1; 					// 배추 위치 초기화
			}
			for (int i = 0; i < M; ++i) {			// 0,0 부터 탐색 시작 -> 방문 체크
				for (int j = 0; j < N; ++j) {
					isFirst = true;					// 카운팅 플래그 초기화
					search(i, j);					// 탐색 호출
				}
			}
			System.out.println(Cnt);				// 출력
		}
	}

	static boolean isAvailable(int x, int y) {		// 가능한 범위 내인지 검사
		if (x < 0 || x >= M || y < 0 || y >= N) return false;
		if (ground[x][y] != 1) return false;
		return true;
	}

	static void search(int x, int y) {
		if (ground[x][y] != 1) return; 				// 배추가 아니라면 리턴(0 아니면 -1일 때 리턴)
		else {
			ground[x][y] = -1; 						// 방문 체크로 재사용
			if (isFirst) {							// 배추 한 그룹당 카운팅 해주려고 플래그 사용
				Cnt++;
				isFirst = false;
			}
			for (int d = 0; d < 4; ++d) {			// 4방향 탐색을 수행
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (isAvailable(nx, ny)) {			// 이동 하려는 곳이 이동 가능하면 
					search(nx, ny); 				// 재탐색
				}
			}
		}
	}
}
