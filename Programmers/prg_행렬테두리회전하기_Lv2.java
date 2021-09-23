import java.util.*;

public class prg_lv2_행렬테두리회전하기 {

	static int[][] dir = { { 1, 0, -1, 0 }, { 0, 1, 0, -1 } };// 하, 우, 상, 좌
	static int N, M, map[][];

	static public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int answerIdx = 0;
		// input
		int val = 1;
		N = rows;
		M = columns;
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				map[i][j] = val++;
			}
		}
		// rotation
		int[][] pos = new int[2][2];
		for (int i = 0; i < queries.length; ++i) {
			int min = Integer.MAX_VALUE;
			// input pos
			int nowx = queries[i][0]-1;
			int nowy = queries[i][1]-1;
			pos[0][0] = queries[i][0] - 1;
			pos[0][1] = queries[i][1] - 1;
			pos[1][0] = queries[i][2] - 1;
			pos[1][1] = queries[i][3] - 1;

			int startVal = map[pos[0][0]][pos[0][1]];
			min = Math.min(min, startVal);
			for (int d = 0; d < 4; ++d) {
				int nx = nowx + dir[0][d];
				int ny = nowy + dir[1][d];
				if(isBoundary(nx,ny,pos)) {
					map[nowx][nowy] = map[nx][ny];
					min = Math.min(min, map[nowx][nowy]);
					nowx=nx;
					nowy=ny;
					--d;
				}
			}
			map[nowx][nowy+1]=startVal;
			answer[answerIdx++] = min;
			System.out.println((i+1)+"번쨰 회전");
			for(int x=0;x<N;++x) {
				for(int y=0;y<M;++y) {
					System.out.printf("%2d ", map[x][y]);
				}
				System.out.println();
			}
		}
		return answer;
	}

	static boolean isBoundary(int x, int y, int[][] pos) {
		return pos[0][0] <= x && x <= pos[1][0] && pos[0][1] <= y && y <= pos[1][1];
	}

	public static void main(String[] args) {
		int[] answer = solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } });
		for(int a: answer)
			System.out.print(a+" ");
	}

}
