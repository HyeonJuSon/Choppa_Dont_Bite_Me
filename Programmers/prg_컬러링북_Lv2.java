
public class prg_컬러링북_lv2 {

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };// 4방 이동
	static boolean[][] isVisited;// 방문체크
	static int M, N, sum;

	static public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;// 영역의 개수
		int maxSizeOfOneArea = 0;// 영역의 최대 크기
		isVisited = new boolean[m][n];// 방문체크
		M = m;// 행
		N = n;// 열
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (picture[i][j] != 0 && !isVisited[i][j]) {// 색칠되어있고, 미방문인 경우
					++numberOfArea;// 영역의 개수를 증가
					isVisited[i][j] = true;// 방문체크
					sum = 1;// 합계 시작 (시작위치는 미리 카운트)
					dfs(i, j, picture, picture[i][j]);//탐색시작
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sum);//최대크기갱신
				}
			}
		}
		return new int[] { numberOfArea, maxSizeOfOneArea }; // 반환
	}

	static void dfs(int i, int j, int[][] picture, int type) {
		for (int d = 0; d < 4; ++d) {//4방탐색
			int nx = dir[0][d] + i;
			int ny = dir[1][d] + j;
			if (isBoundary(nx, ny) && !isVisited[nx][ny] && picture[nx][ny] == type) {
				isVisited[nx][ny] = true;//방문체크
				dfs(nx, ny, picture, type);//재탐색
				sum++;//크기증가
			}
		}
	}

	static boolean isBoundary(int x, int y) {//범위체크후 반환
		return 0 <= x && x < M && 0 <= y && y < N;
	}

	public static void main(String[] args) {
		int[] answer = solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
		for (int a : answer)
			System.out.println(a);
	}

}
