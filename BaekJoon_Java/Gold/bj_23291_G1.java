package gold;

import java.io.*;
import java.util.*;

public class bj_23291_G1 {

	static int N, K, map[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			map[i] = Integer.parseInt(st.nextToken());
		// 최대값 - 최소값이 K이하이면 그만한다.
//		while(true) {
//			if(getDiff() <= K) break;
		// 최솟값의 위치를 찾아 +1한다.
		minValUp();
		// 맨 왼쪽 어항을 오른쪽 위로 올린다.
		int[][] tmp = new int[2][N - 1];
		goRightUp(tmp);
		// 2개 이상 쌓여있는 것들을 가능할때까지 계속 90도회전시킨다
		// 물고기의 수를 조절한다
		int[][] rotMap = manageFishCnt(rotateBowl(tmp));
		// 일렬로 바꾸어 준다.
		int[] line = makeOneLine(rotMap);
		for (int i = 0; i < line.length; ++i)
			System.out.print(line[i] + " ");
		}
//	}

	// 180도 회전
	
	// 물고기의 수를 조절한다.
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
	static int[][] manageFishCnt(int[][] tmp) {
		int x = tmp.length, y = tmp[0].length;
		int[][] diff = new int[x][y];
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				int nowVal = tmp[i][j];
				if(nowVal==0) continue;
				int sum = 0;
				for (int direction = 0; direction < 4; ++direction) {
					int nx = i + dir[0][direction];
					int ny = j + dir[1][direction];
					if (0 <= nx && nx < x && 0 <= ny && ny < y && tmp[nx][ny]!=0) {
						int nextVal = tmp[nx][ny];
						int d = Math.abs(nowVal - nextVal) / 5;
						if (d > 0) {
							if (nowVal > nextVal) {
								sum -=d;
							} else if (nowVal < nextVal) {
								sum +=d;
							}
						}
					}
				}
				diff[i][j] = sum;
			}
		}
		// 갱신한다.
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				diff[i][j] += tmp[i][j];
			}
		}
		// 결과를 반환한다.
		return diff;
	}

	// 최대값과 최소값의 차이를 찾는다.
	static int getDiff() {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			max = Math.max(max, map[i]);
			min = Math.min(min, map[i]);
		}
		return max - min;
	}

	// 최솟값의 위치를 찾아 +1 하는 메소드
	static void minValUp() {
		int min = Integer.MAX_VALUE;
		// 1. 최솟값을 찾는다.
		for (int i = 0; i < N; ++i)
			min = Math.min(min, map[i]);
		// 2. 최솟값과 동일한 경우 +1 해준다.
		for (int i = 0; i < N; ++i) {
			if (map[i] == min)
				++map[i];
		}
	}

	// 맨 왼쪽 어항을 위로 올린다.
	static void goRightUp(int[][] tmp) {
		tmp[0][0] = map[0];
		for (int j = 1; j < N; ++j)
			tmp[1][j - 1] = map[j];
	}

	// 더이상 회전이 안 될때 까지 회전시킨다.
	static int[][] rotateBowl(int[][] tmp) {
		int[][] rotTmp = tmp;
		while (true) {
			// 1. 몇 번째 열까지 2행이상인지 찾는다.
			int targetCol = 0;
			for (int j = 0; j < rotTmp[0].length; ++j) {
				if (rotTmp[0][j] != 0)
					++targetCol;
			}
			int[] oldXY = { rotTmp.length, rotTmp[0].length };
			int[] newXY = { targetCol + 1, rotTmp[0].length - targetCol };
			int[][] now = new int[newXY[0]][newXY[1]];
			boolean isLeft = true;
			// 2. 가능하면 돌리고
			if (oldXY[0] <= newXY[1]) {
				int x = oldXY[0] - 1;
				int y = 0;
				for (int i = 0; i < newXY[0]; ++i) {
					for (int j = 0; j < newXY[1]; ++j) {
						if (isLeft) {
							if (x >= 0) {
								now[i][j] = rotTmp[x--][y];
							}
						} else {
							now[i][j] = rotTmp[oldXY[0] - 1][j + targetCol];
						}
					}
					x = 1;
					if (++y >= targetCol) {
						isLeft = false;
					}
				}
				rotTmp = now;// 갱신해준다.

			} else
				break; // 3. 불가능하면 반환한다.
		}
		return rotTmp;
	}

	// 일렬로 만들어준다.
	static int[] makeOneLine(int[][] tmp) {
		// 1. 카운트 세기
		int cnt = 0, x = tmp.length, y = tmp[0].length;
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				if (tmp[i][j] != 0)
					++cnt;
			}
		}
		// 2. 일렬로 만들기
		int[] res = new int[cnt];
		int idx = 0;
		for (int j = 0; j < tmp[0].length; ++j) {
			for (int i = x - 1; i >= 0; --i) {
				if (tmp[i][j] != 0) {
					res[idx++] = tmp[i][j];
				}
			}
		}
		return res; // 일렬로 만들어진거를 반환한다.
	}
}
