package Programmers;

public class prrg_프렌즈4블록_LV2 {
	// 자신, 우, 하, 하우
	static int[][] dir = { { 0, 0, 1, 1 }, { 0, 1, 0, 1 } };

	static public int solution(int m, int n, String[] board) {
		int answer = 0;
		final char empty = 'z';
		// board를 2차원 배열로 바꾼다.
		char[][] arr = new char[m][n];
		for (int i = 0; i < m; ++i) {
			String now = board[i];
			for (int j = 0; j < n; ++j) {
				arr[i][j] = now.charAt(j);
			}
		}
		// 더 이상 지울게 없을 때 까지 반복한다.
		while (true) {

			// 더이상 반복을 진행하지 않아도 되는지 여부
			boolean isLoop = false;
			// 1. 지워질 블록을 판별한다.
			boolean[][] erase = new boolean[m][n]; // 지워질 위치를 체크할 곳
			// 0,0에서 부터 시작한다.
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					char nowVal = arr[i][j]; // 현재 값
					if (nowVal == empty)
						continue;
					boolean isBomb = true;
					for (int d = 1; d < 4; ++d) { // 자기자신은 뺴고 비교
						int ni = i + dir[0][d];
						int nj = j + dir[1][d];
						if (!(0 <= ni && ni < m && 0 <= nj && nj < n)) {
							isBomb = false; // 하나라도 범위를 벗어나면 false
							break;
						}
						if (nowVal != arr[ni][nj]) {
							isBomb = false; // 하나라도 다르면 ㄴ
							break;
						}
					}
					if (isBomb) { // 폭발시켜야하는 위치라면
						for (int d = 0; d < 4; ++d) { // 폭발 배열에 체크해둔다.
							erase[i + dir[0][d]][j + dir[1][d]] = true;
						}
						isLoop = true; // 하나라도 폭발 시킬게 있으면 반복해야함
					}
				}
			}
			// 폭발 시킬 게 없으면 끝낸다.
			if (!isLoop)
				break;
			// 2. 블록을 지운다.
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (erase[i][j]) { // 지워야하는 거라면
						++answer; // 카운팅
						arr[i][j] = empty;// 지워준다.
					}
				}
			}
			// 3. 아래로 내린다.(밑에서부터 위로 탐색)
			for (int j = 0; j < n; ++j) {
				for (int i = m - 1; i >0; --i) {
					if(arr[i][j]==empty) {
						// empty가 아닌 행까지 탐색
						int findIdx = i;
						while(true) {
							if(findIdx -1<0) break;
							if(arr[findIdx][j]!=empty) {
								arr[i][j] = arr[findIdx][j];
								arr[findIdx][j]=empty;
							}
							findIdx -=1;
						}
					}
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
//		System.out.println(solution(4, 5, new String[] { "CCBDE", "AAADE", "AAABF", "CCBBF" }));
		System.out.println(solution(7, 2, new String[] { "AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC" }));
	}

}