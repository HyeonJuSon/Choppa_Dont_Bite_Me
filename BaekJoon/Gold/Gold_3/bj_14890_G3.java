// solve time : 1h 16m 
package gold;
import java.io.*;
import java.util.*;

public class bj_14890_G3 {

	static int N, L, map[][], answer;
	static boolean[][] isStepper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 배열 길이
		L = Integer.parseInt(st.nextToken()); // 경사로 길이
		map = new int[N][N];
		isStepper = new boolean[N][N];
		answer = 0;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행 검사
		for (int i = 0; i < N; ++i) {
			if (findRoad(i, true))
				++answer;
		}
		for(int i=0;i<N;++i)
			Arrays.fill(isStepper[i], false);
		// 열 검사
		for (int i = 0; i < N; ++i) {
			if (findRoad(i, false))
				++answer;
		}

		System.out.println(answer);
	}

	static boolean makeStepper(int[] line, int idx, boolean isRow) {
		boolean[][] tmpStepper = new boolean[N][N];
		
		if(isRow) {
			for(int j=0;j<N;++j) tmpStepper[idx][j]=isStepper[idx][j];
		}else for(int i=0;i<N;++i) tmpStepper[i][idx] =isStepper[i][idx];
		
		for (int i = 1; i < N; ++i) {
			if (line[i - 1] != line[i]) {
				// 높이차가 2이상인지?
				if (Math.abs(line[i] - line[i - 1]) >= 2)
					return false;
				// 같은 높이가 L개 이상이어야 함.
				int sameCnt = 0;
				boolean isReverse = false;
				if (line[i - 1] < line[i]) {
					isReverse = true;
					for (int j = i - 1; j >= 0; --j) {
						if (line[i - 1] == line[j])
							++sameCnt;
						else
							break;
					}
				} else {
					isReverse = false;
					for (int j = i; j < N; ++j) {
						if (line[i] == line[j])
							++sameCnt;
						else
							break;
					}
				}
				// i와 같은 값의 연속된 개수가 L 개가 아닌지?
				// 같은 높이인지?
				if (sameCnt < L)
					return false;
				// 이미 놓여진 경사로가 없는지?
				if (isReverse) {
					if (isRow) {
						for (int j = i - L; j <= i - 1; ++j) {
							if (tmpStepper[idx][j])
								return false;
						}
					} else if (!isRow) {
						for (int j = i - L; j <= i - 1; ++j) {
							if(tmpStepper[j][idx]) return false;
						}
					}
				} else {
					if (isRow) {
						for (int j = i; j < i + L; ++j) {
							if(tmpStepper[idx][j])
								return false;
						}
					}
					else if (!isRow) {
						for (int j = i; j < i + L; ++j) {
							if(tmpStepper[j][idx])
								return false;
						}
					}
				}
				// 범위가 벗어나진 않는지?
				if (isReverse && i - L < 0)
					return false;
				else if (!isReverse && i + L > N)
					return false;

				// 경사로를 놓는다.
				if (isReverse) {
					for (int j = i - L; j <= i - 1; ++j) {
						if (isRow)
							tmpStepper[idx][j] = true;
						else
							tmpStepper[j][idx] = true;
					}
				} else {
					for (int j = i; j < i + L; ++j) {
						if (isRow)
							tmpStepper[idx][j] = true;
						else
							tmpStepper[j][idx] = true;
					}
					i += L - 1;
				}
			}
		}
		if(isRow) {
			for(int j=0;j<N;++j)
				if(tmpStepper[idx][j])
					isStepper[idx][j] = true;
		}else {
			for(int i=0;i<N;++i)
				if(tmpStepper[i][idx])
					isStepper[i][idx] = true;
		}
		
		return true;
	}

	static boolean findRoad(int idx, boolean isRow) {
		int[] line = getLine(idx, isRow); // 검사할 길을 가져온다.
		if (!sameLine(line)) {
			// 같지 않다면 경사로를 놓아본다.
			if (makeStepper(line, idx, isRow))
				return true;
			else
				return false;
		}
		return true;
	}

	static boolean sameLine(int[] line) {
		for (int i = 1; i < N; ++i) {
			if (line[i - 1] != line[i])
				return false;
		}
		return true;
	}

	static int[] getLine(int idx, boolean isRow) {
		int[] line = new int[N];
		if (isRow) { // 행이라면
			for (int j = 0; j < N; ++j) {
				line[j] = map[idx][j];
			}
		} else {
			for (int i = 0; i < N; ++i) {
				line[i] = map[i][idx];
			}
		}
		return line;
	}
}

/*
 * summary 지도의 각 칸에는 높이가 적혀있음 지도에서 지나갈 수 있는 길이 몇개인지 (한행 or 한열, 한쪽 끝에서 다른쪽 끝가지
 * 지나감)
 * 
 * 길을 지나갈 수 있으려면 길에 속한 모든 칸의 높이가 모두 같아야 함 혹은 경사로를 만들어야함 ( 경사로 높이 항상 1, 길이 L )
 * 
 * 경사로는 낮은 칸과 높은 칸을 연결 [ 조건 ] 경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다. 낮은
 * 칸과 높은 칸의 높이 차이는 1 경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속 [ 놓을 수 없는 조건 ] 이미
 * 경사로가 있는 경우 높이 차가 2이상인 경우 낮은 지점의 칸 높이가 모두 같지 않거나, L개가 연속되지 않은 경우 경사로를 놓다가 범위를
 * 벗어나는 경우
 * 
 * 
 */
