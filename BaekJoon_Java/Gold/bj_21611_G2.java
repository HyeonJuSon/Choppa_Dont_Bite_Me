package gold;

import java.io.*;
import java.util.*;

public class bj_21611_G2 {

	static int N, M, map[][], D, S;
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } }; // 구슬 파편 던질 때 사용
	static int[][] moveDir = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } };// 0,0에서부터 들어감. 우 하 좌 상
	static int[] bombCnt = new int[3];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		D = Integer.parseInt(st.nextToken()) - 1; // 0 1 2 3 상 하 좌 우
		S = Integer.parseInt(st.nextToken());
		System.out.println(process());
	}

	static int process() {
		int answer = -1; // 반환할 답의 위치
		// M번 반복한다.
		for (int i = 0; i < M; ++i) {
			int[] startPos = { N / 2, N / 2 }; // 상어의 시작 위치
			map[startPos[0]][startPos[1]] = -1; // 상어 위치 표시
			int destroyCnt = 0; // 파괴된 개수
			// d 방향으로 거리가 s이하인 칸의 구슬을 모두 파괴한다.
			for (int s = 1; s <= S; ++s) {
				int nx = (dir[0][D] * s) + startPos[0];
				int ny = (dir[1][D] * s) + startPos[1];
				if (isBoundary(nx, ny)) {
					map[nx][ny] = 0;
					++destroyCnt;
				}
			}
			
			for(int dc = 0 ; dc < destroyCnt;++dc) { // 파괴된 개수만큼해야한다.
				move(); // 빈 칸이 생겼으므로 이동시킨다.
			}
			// 더 이상 구슬 폭발이 발생하지 않을 때 까지 반복한다.
			// 구슬 폭발 : 4개 이상의 연속하는 구슬 -> 1,2,3번 몇개 폭발하는지 카운트 필요
			for(int dc = 0; dc < 1; ++dc) {
				int len = N; // N,N-1,N-1,N-2,N-2,...,1,1
				int cnt = 0; // 두 번씩 진행된다.
				int beforeNum = -1; // 직전 번호
				int contCnt = 0; // 연속된 개수
				int sum = 0; // 전체 개수
				boolean isNoBomb = true;
				boolean bombFlag = false;//폭발 플래그
				boolean isFirst = true;
				Stack<int[]> posHistory = new Stack<>();
				if (map[0][0] != 0) {
					posHistory.add(new int[] { 0, 0 });
					beforeNum = map[0][0];
					++contCnt;
				}
				boolean isBreak = false;
				int[] startHistory = new int[]{0,0};
				while (true) { // 0을 찾으면 바로 끝
					for (int d = 0; d < 4; ++d) {
						for (int l = len; l > 0; --l) {
							int nx = startHistory[0] + moveDir[0][d];
							int ny = startHistory[1] + moveDir[1][d];
							if(nx == N/2 && ny==N/2) {
								isBreak = true;
								break;
							}
							if (isBoundary(nx, ny)) {
								if (map[nx][ny] != 0) {
									posHistory.add(new int[] { nx, ny });
									if(map[startHistory[0]][startHistory[1]] == map[nx][ny]) { // 직전과 같은 번호면 
										beforeNum=map[startHistory[0]][startHistory[1]];
										++contCnt;
										if(contCnt >=4) { // 4개이상이면
											bombFlag = true; // 플래그를 추가해준다.
										}
									}else { // 다른 번호면
										if(contCnt >= 4 && bombFlag) { // 그만한다. 터뜨려야함.
											posHistory.pop();//하나빼준다.
											bomb(posHistory,contCnt);
											isNoBomb = false;
											sum += contCnt;
											posHistory.clear();
											bombFlag=false;
										}
										beforeNum = map[nx][ny];
										contCnt = 1;
									}
								}
								else if (map[nx][ny] == 0 && !posHistory.isEmpty()) {
									posHistory.add(new int[] { nx, ny });
									isBreak = true;
									break;
								}
								startHistory[0] = nx;
								startHistory[1] = ny;
							}
						}
						if (isFirst || ++cnt >= 2) {
							isFirst = false;
							cnt = 0;
							--len;
						}
						if (isBreak)
							break;
					}
					if (isBreak)
						break;
				}
				for(int m=0;m<sum;++m) {
					move();
					print();
					System.out.println();
				}
				if(!isNoBomb) --dc;
			}
			print();
			// 구슬 변화 : 1개의 그룹(연속(=같은번호로) 하는구슬)이 A (구슬개수) B(구슬번호)로 안에서부터채워진다.
			// 범위 밖으로나가면 사라진다.
		}

		return answer;
	}
	
	static void move() {
		int len = N; // N,N-1,N-1,N-2,N-2,...,1,1
		int cnt = 0; // 두 번씩 진행된다.
		boolean isFirst = true;
		Stack<int[]> posHistory = new Stack<>();
		if (map[0][0] != 0)
			posHistory.add(new int[] { 0, 0 });
		boolean isBreak = false;
		int[] startHistory = new int[]{0,0};
		while (true) { // 0을 찾으면 바로 끝
			for (int d = 0; d < 4; ++d) {
				for (int l = len; l > 0; --l) {
					int nx = startHistory[0] + moveDir[0][d];
					int ny = startHistory[1] + moveDir[1][d];
					if (isBoundary(nx, ny)) {
						if (map[nx][ny] != 0)
							posHistory.add(new int[] { nx, ny });
						else if (map[nx][ny] == 0 && !posHistory.isEmpty()) {
							posHistory.add(new int[] { nx, ny });
							isBreak = true;
							break;
						}
						startHistory[0] = nx;
						startHistory[1] = ny;
					}
				}
				if (isFirst || ++cnt >= 2) {
					isFirst = false;
					cnt = 0;
					--len;
				}
				if (isBreak)
					break;
			}
			if (isBreak)
				break;
		}
		int[] zero = posHistory.pop();// 맨 위에 좌표로 한칸씩 당겨준다.
		while (!posHistory.isEmpty()) {
			// 담아둔 걸 다 앞으로 당긴다.
			int[] pop = posHistory.pop();
			map[zero[0]][zero[1]] = map[pop[0]][pop[1]];
			map[pop[0]][pop[1]] = 0;
			zero = pop;
		}
	}
	
	static void bomb(Stack<int[]> posHistory, int contCnt) {
		int[] zero = null;
		for(int z=0;z<contCnt;++z) {
			zero = posHistory.pop();
			bombCnt[map[zero[0]][zero[1]]-1]++;
			map[zero[0]][zero[1]]=0; // 폭발시킨다.
			
		}
	}
	
	static void print() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
	}

	// 범위 안에 있는 좌표인지 여부를 반환한
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
