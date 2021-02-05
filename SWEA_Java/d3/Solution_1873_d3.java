package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_구미_4_손현주 {
	static int dir, H, W; // 방향 0 상 1 하 2 좌 3 우
	static char[][] Map; // 맵 배열
	static int[][] d = { 
			{ -1, 0 }, 
			{ 1, 0 }, 
			{ 0, -1 }, 
			{ 0, 1 } }; // 상,하,좌,우

	static boolean isBoundary(int x, int y) {
		if (x >= 0 && x < H && y >= 0 && y < W)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		// IO
		System.setIn(new FileInputStream("res/Input_d3_상호의배틀필드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 1. 테스트 케이스를 입력받는다.
		int T = Integer.parseInt(br.readLine());
		// 2. 테스트 케이스 수 만큼 반복한다.
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			// 3. 높이와 너비 입력
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			// 4. 맵 할당
			Map = new char[H][W];
			// 5. 맵 초기화
			int posX = -1, posY = -1;
			for (int i = 0; i < H; ++i) {
				String tmp = br.readLine();
				for (int j = 0; j < W; ++j) {
					Map[i][j] = tmp.charAt(j);
					// 5-1. 초기 전차 위치 Get
					if (Map[i][j] == '<' || Map[i][j] == '>' || Map[i][j] == '^' || Map[i][j] == 'v') {
						if (Map[i][j] == '^') dir = 0;
						else if (Map[i][j] == 'v') dir = 1;
						else if (Map[i][j] == '<') dir = 2;
						else if (Map[i][j] == '>') dir = 3;
						posX = i;
						posY = j;
					}
				}
			}
			// 6.커맨드 입력
			int length = Integer.parseInt(br.readLine());
			String command = br.readLine();
			// 7.커맨드 처리
			for (int k = 0; k < length; ++k) {
				int nx, ny;
				char ch = command.charAt(k); // 커맨드를 한글자씩
				if (ch == 'U' || ch == 'D' || ch == 'L' || ch == 'R') {
					if (ch == 'U') {
						dir = 0;
						Map[posX][posY] = '^';
					} else if (ch == 'D') {
						dir = 1;
						Map[posX][posY] = 'v';
					} else if (ch == 'L') {
						dir = 2;
						Map[posX][posY] = '<';
					} else if (ch == 'R') {
						dir = 3;
						Map[posX][posY] = '>';
					}
					nx = posX + d[dir][0]; // x - 행
					ny = posY + d[dir][1]; // y - 열
					// 바운더리 안에 있고, 평지라면
					if (isBoundary(nx, ny) && Map[nx][ny] == '.') {						
							Map[nx][ny] = Map[posX][posY];// 이동값넣어주고
							Map[posX][posY] = '.';// 전 위치는 평지로
							posX = nx; // 위치 변경
							posY = ny;
					}
				} else if (ch == 'S') {
					nx = posX; // 총알위치로 사용한다.
					ny = posY;
					while (true) {
						nx += d[dir][0]; // 행
						ny += d[dir][1]; // 열
						// 맵밖이거나, 강철벽이면 나간다.
						if (!isBoundary(nx, ny) || Map[nx][ny] == '#') break;
						else if (Map[nx][ny] == '*') {// 벽돌벽이면
							Map[nx][ny] = '.'; // 부셔주고
							break;
						}
					}
				}
			}
			// 8. 바뀐 맵을 출력해준다.
			System.out.print("#" + tc + " ");
			for (int x = 0; x < H; ++x) {
				for (int y = 0; y < W; ++y) {
					System.out.print(Map[x][y]);
				}
				System.out.println();
			}
		}

	}
}
