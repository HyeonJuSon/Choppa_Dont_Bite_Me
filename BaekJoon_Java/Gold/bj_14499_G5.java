package BJ;

import java.io.*;
import java.util.*;

public class bj_14499_G5 {
	static int[][] dice = new int[4][3]; 						// 주사위 전개도
	static int[][] map; 										// 지도
	static final int East = 1, West = 2, North = 3, South = 4; 	// 동서남북
	static int N, M, r, c;							

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Int(st.nextToken());		 						// 지도의 행 크기
		M = Int(st.nextToken()); 								// 지도의 열 크기
		r = Int(st.nextToken()); 								// 주사위 시작 행 위치
		c = Int(st.nextToken()); 								// 주사위 시작 열 위치
		int k = Int(st.nextToken()); 							// 명령의 개수
		map = new int[N][M]; 									// 지도 배열 할당
		for (int i = 0; i < N; ++i) { 							// 지도 숫자 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) map[i][j] = Int(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; ++i)	diceMove(Int(st.nextToken()));	// 명령 입력
	}

	static void diceMove(int orderIdx) {						// 주사위 이동
		switch (orderIdx) {
		case East:												// 동쪽 이동
			if (isAvailable(r, c+1)) {							// 이동가능여부
				eastMove();										// 이동
				updateLowerSide(r,++c);							// 아랫면 업뎃
				printUpperSide();								// 윗면 출력
			}
			break;
		case West:												// 서쪽 이동
			if (isAvailable(r, c - 1)) {						// 이동가능여부
				westMove();										// 이동
				updateLowerSide(r,--c);							// 아랫면 업뎃
				printUpperSide();								// 윗면 출력
			}
			break;
		case North:												// 북쪽 이동
			if (isAvailable(r - 1, c)) {						// 이동가능여부
				northMove();									// 이동
				updateLowerSide(--r,c);							// 아랫면 업뎃
				printUpperSide();								// 윗면 출력
			}
			break;
		case South:												// 남쪽 이동
			if (isAvailable(r + 1, c)) {						// 이동가능여부
				southMove();									// 이동
				updateLowerSide(++r,c);							// 아랫면 업뎃
				printUpperSide();								// 윗면 출력
			}
			break;
		}
	}

	static void updateLowerSide(int x, int y) {
		if(map[x][y] == 0) map[x][y] = dice[1][1];				// 지도의 수가 0인경우
		else {													// 그 외 경우
			dice[1][1] = map[x][y];								
			map[x][y] = 0;
		}
	}
	
	static void eastMove() {									// 동쪽 이동
		int tmp = dice[1][0];
		for(int j=1;j<3;++j) dice[1][j-1] = dice[1][j];
		dice[1][2] = dice[3][1];
		dice[3][1] = tmp;
	}

	static void westMove() {									// 서쪽 이동
		int tmp = dice[1][2];
		for(int j=1;j>=0;--j) dice[1][j+1] = dice[1][j];
		dice[1][0] = dice[3][1];
		dice[3][1] = tmp;
	}

	static void northMove() {									// 북쪽 이동
		int tmp = dice[3][1];
		for(int i=2; i >= 0;--i) dice[i+1][1] = dice[i][1];
		dice[0][1] = tmp;
	}

	static void southMove() {									// 남쪽 이동
		int tmp = dice[0][1];
		for (int i = 1; i < 4; ++i) dice[i-1][1] = dice[i][1];
		dice[3][1] = tmp;
	}

	static boolean isAvailable(int x, int y) {					// 범위 가능여부
		if (x < 0 || x >= N || y < 0 || y >= M) return false;
		return true;
	}

	static void printUpperSide() {								// 윗면 출력
		System.out.println(dice[3][1]);
	}

	static int Int(String s) {									// 파싱 
		return Integer.parseInt(s);
	}
}
