import java.io.*;
import java.util.*;

public class prg_컬러링북_lv2 {

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };// 4방
	static boolean[][] isVisited;
	static int M, N,sum;

	static public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		isVisited = new boolean[m][n];
		M = m;
		N = n;
		
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (picture[i][j] != 0 && !isVisited[i][j]) {
					++numberOfArea;
					isVisited[i][j] = true;
					sum =1;
					dfs(i, j, picture, picture[i][j]);
					maxSizeOfOneArea=Math.max(maxSizeOfOneArea, sum);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	static void dfs(int i, int j, int[][] picture,int type) {
		for(int d=0;d<4;++d) {
			int nx = dir[0][d] + i;
			int ny = dir[1][d] + j;
			if(isBoundary(nx,ny) && !isVisited[nx][ny] && picture[nx][ny]==type) {
				isVisited[nx][ny]= true;
				dfs(nx,ny,picture,type);
				sum++;
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}

	public static void main(String[] args) {
		int[] answer = solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
		for (int a : answer)
			System.out.println(a);
	}

}
