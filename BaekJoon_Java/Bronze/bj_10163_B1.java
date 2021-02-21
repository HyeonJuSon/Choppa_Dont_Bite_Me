package bj;

import java.util.*;

public class bj_10163_B1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());	// 색종이의 개수
		int[][] paper = new int[101][101];			// 색종이 필드
		int[] S = new int[N+1];						// 각 색종이의 면적
		for (int i = 0; i < N; ++i) {				// 색종이 수 만큼 반복
			int y = sc.nextInt();					// 열 시작 
			int x = sc.nextInt();					// 행 시작
			int w = sc.nextInt();					// 너비
			int h = sc.nextInt();					// 높이
			for (int m = x; m < x + h; ++m) {		// 시작 위치로부터 시작 
				for (int n = y; n < y + w; ++n) {	// 겹친 종이는 넓이 빼준다.
					if(paper[m][n] != 0) S[paper[m][n]]--;
					paper[m][n]=i+1;				// 종이 갱신
					S[paper[m][n]]++;				// 넓이 갱신
				}
			}
		}
		for(int i=1;i<=N;++i) System.out.println(S[i]);
		sc.close();
	}

}
