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
			this.x = this.y = -1; // 배치 되기 전이므로 -1로 둔다.
		}
	}
	static int N, map[][];
	static int[] score = { 0, 1, 10, 100, 1000 }; // 점수표
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
	static ArrayList<Student> batchedStudent = new ArrayList<>(); // 배치된 학생들의 리스트
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		Queue<Student> students = new LinkedList<>(); // 배치할 학생들
		for (int i = 0; i < N * N; ++i) {
			st = new StringTokenizer(br.readLine());
			students.offer(new Student(stoi(st.nextToken()), new int[] { stoi(st.nextToken()), stoi(st.nextToken()),
					stoi(st.nextToken()), stoi(st.nextToken()) }));
		}
		// map을 인접 빈칸 갯수로 초기화한다.
		map = new int[N][N];
		initEmptyBlock(map);
		// 학생들을 배치한다.
		while (!students.isEmpty()) {
			Student now = students.poll();
			batchStudent(now);
		}
		// 학생의 만족도 총 합을 출력한다.
		System.out.println(getScore());
	}
	
	// 만족도의 총 합
	static int getScore() {
		int answer = 0;
		for (Student s : batchedStudent) {
			int cnt = 0;
			for (int d = 0; d < 4; ++d) {
				int nx = s.x + dir[0][d];
				int ny = s.y + dir[1][d];
				if(!isBoundary(nx,ny)) continue;
				if (s.likes.containsKey(map[nx][ny] * -1)) {
					++cnt;
				}
			}
			answer += score[cnt]; // 점수를 합산한다.
		}
		return answer;
	}
	
	// 주위 빈 칸의 개수를 반환
	static int getEmptyCnt(int x, int y) {
		int cnt = 0;
		for(int d=0;d<4;++d) {
			int nx = x+dir[0][d];
			int ny = y+dir[1][d];
			if(isBoundary(nx,ny) && map[nx][ny]>0) ++cnt;
		}
		return cnt;
	}
	
	// 입력받은 배열에 주위 좋아하는 학생
	static void batchStudent(Student now) {
		int max = -1, x = -1, y = -1;
		if (batchedStudent.size() == 0) { // 배치된 학생이 없다면
			// 빈칸이 가장 많은 곳에 넣는다.
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (max < map[i][j]) {
						max = map[i][j];
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
						if (isBoundary(nx, ny) && map[nx][ny] > 0) {
							tmp[nx][ny]++;
						}
					}
				}
			}
			// 가장 큰 값 찾기
			boolean isDupl = false; // 여러개인 경우의 플래그
			Queue<int[]> big = new LinkedList<>(); // 여러개일 때 비교할 대상을 담을 큐
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j]>0) { // 이미 배치된 곳을 제외한 곳을 검사
						if (max < tmp[i][j]) {
							max = tmp[i][j];
							x = i;
							y = j;
							isDupl=false;
							big.clear(); // 초기화를 해주고 담아준다.
							big.add(new int[] {i,j});
						} else if (max == tmp[i][j]) { // 같은 곳이 여러곳
							big.add(new int[] {i,j});
							isDupl = true; // 플래그
						}
					}
				}
			}
			if(isDupl) {
				// 빈칸을 가장 많이 가진 것을 저장한다. 최상단 최좌측부터 담겨져있음. 2,3번 조건
				max = -1;
				while(!big.isEmpty()) {
					int[] b = big.poll();
					int bCnt = getEmptyCnt(b[0], b[1]);//주위 빈칸의 개수를 가져온다.
					if(max < bCnt) { // 최초값만 저장하면되므로
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
		map[x][y] = -1 * now.sId; // 음수로 학생의 번호를 저장해둔다.
	}

	// 입력받은 배열에 주위 빈칸의 개수를 반환
	static void initEmptyBlock(int[][] map) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				int cnt = 4;
				if (i == 0 || i == N - 1) --cnt;
				if (j == 0 || j == N - 1) --cnt;
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
