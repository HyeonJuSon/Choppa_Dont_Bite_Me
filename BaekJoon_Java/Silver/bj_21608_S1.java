package silver;

import java.io.*;
import java.util.*;

public class bj_21608_S1 {

	static class Student {
		int sId;
		int x, y; // 배치되었을 때의 위치
		HashMap<Integer, Integer> likes = new HashMap<>();

		public Student(int sId, int[] likes) {
			this.sId = sId;
			for (int i = 0; i < likes.length; ++i) {
				this.likes.put(likes[i], 1);
			}
			this.x = this.y = -1;
		}
	}

	static int N, empty[][];
	static ArrayList<Student> batchedStudent = new ArrayList<>();
	static int[] score = { 0, 1, 10, 100, 1000 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Student> students = new LinkedList<>();
		StringTokenizer st = null;
		for (int i = 0; i < N * N; ++i) {
			st = new StringTokenizer(br.readLine());
			students.offer(new Student(stoi(st.nextToken()), new int[] { stoi(st.nextToken()), stoi(st.nextToken()),
					stoi(st.nextToken()), stoi(st.nextToken()) }));
		}
		// 비어있는 곳을 체킹
		empty = new int[N][N];
		getEmptyBlock(empty);

		// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸이 가장 많은 칸으로 정한다.
		// 2. 1이 여러개인 경우 인접 칸에서 빈 칸이 가장 많은 칸을 선택한다.
		// 3. 2가 여러개인 경우 행이 작은순, 열이 작은순으로 정한다.
		while (!students.isEmpty()) {
			Student now = students.poll();
			checkFavorite(now);
		}
		// 4. 학생의 만족도 총 합을 출력한다.
		System.out.println(getScore());
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	// 만족도의 총 합
	static int getScore() {
		int answer = 0;
		for (Student s : batchedStudent) {
			int cnt = 0;
			for (int d = 0; d < 4; ++d) {
				int nx = s.x + dir[0][d];
				int ny = s.y + dir[1][d];
				if (isBoundary(nx, ny) && s.likes.containsKey(empty[nx][ny] * -1)) {
					++cnt;
				}
			}
			answer += score[cnt];
		}
		return answer;
	}

	// 입력받은 배열에 주위 좋아하는 학생
	static void checkFavorite(Student now) {
		int max = -1, x = -1, y = -1;
		if (batchedStudent.size() == 0) { // 배치된 학생이 없다면
			// 빈칸이 가장 많은 곳에 넣는다.
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (max < empty[i][j]) {
						max = empty[i][j];
						x = i;
						y = j;
					}
				}
			}

		} else { // 배치된 사람이 있다면
			int[][] tmp = new int[N][N]; // 주위에 선호하는 사람의 수
			for (Student s : batchedStudent) {
				if (now.likes.containsKey(s.sId)) { // 선호 목록에 있으면
					for (int d = 0; d < 4; ++d) {
						int nx = s.x + dir[0][d];
						int ny = s.y + dir[1][d];
						if (isBoundary(nx, ny) && empty[nx][ny] > 0) {
							tmp[nx][ny]++;
						}
					}
				}
			}
			// 가장 큰 값 찾기
			boolean isDupl = false;
			Queue<int[]> big = new LinkedList<>();
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (tmp[i][j] >= 0 && empty[i][j]>0) {
						if (max < tmp[i][j]) {
							max = tmp[i][j];
							x = i;
							y = j;
							isDupl=false;
							big.clear();
							big.add(new int[] {i,j});
						} else if (max == tmp[i][j]) {
							big.add(new int[] {i,j});
							isDupl = true; // 선호하는 학생 수가 같은 곳이 여러곳이면 더 검사할 필요 x
						}
					}
				}
			}
			if(isDupl) {
				// 빈칸을 가장 많이 가진 것을 저장한다.
				max = -1;
				while(!big.isEmpty()) {
					int[] b = big.poll();
					int bCnt = 0;
					for(int d=0;d<4;++d) {
						int nx = b[0]+dir[0][d];
						int ny = b[1] +dir[1][d];
						if(isBoundary(nx,ny) && empty[nx][ny]>0) ++bCnt;
					}
					if(max < bCnt) {
						max = bCnt;
						x=b[0];
						y=b[1];
					}
				}
				
			}
		}
		now.x = x;
		now.y = y;
		batchedStudent.add(now);
		empty[x][y] = -1 * now.sId;
		
	}

	// 입력받은 배열에 주위 빈칸의 개수를 반환
	static void getEmptyBlock(int[][] map) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				int cnt = 4;
				if (i == 0 || i == N - 1)
					--cnt;
				if (j == 0 || j == N - 1)
					--cnt;
				map[i][j] = cnt;
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static int stoi(String s) {
		return Integer.parseInt(s) - 1;
	}
}
