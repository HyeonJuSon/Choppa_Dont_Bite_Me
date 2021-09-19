package gold;

import java.io.*;
import java.util.*;

public class bj_21611_G2 {

	static class Node {
		int x, y, num;

		Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	static int N, M, map[][], D, S;
	static Node[] beads;
	static int[] bombCnt = new int[3];
	static int[][] moveDir = { { 0, 1, 0, -1 }, { -1, 0, 1, 0 } };// 좌 하 우 상
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } }; // 구슬 파편 던질 때 사용
	static int[] shark;

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
		shark = new int[] { N / 2, N / 2 };// 상어의 위치를 저장.
		initBeads(); // 구슬들을 담을 객체 배열 초기화
		for (int i = 0; i < M; ++i) { // M번 반복한다.
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken()) - 1; // 0 1 2 3 상 하 좌 우
			S = Integer.parseInt(st.nextToken());
			magic(); // 1. 마법
			explosion(); // 2. 폭발
			change(); // 3. 변화
		}
		System.out.println(1 * bombCnt[0] + 2 * bombCnt[1] + 3 * bombCnt[2]);
	}

	static void initBeads() {
		beads = new Node[N * N - 1]; // 상어위치부터 꼬리로 쭈욱
		int[] pos = new int[] { shark[0], shark[1] }; // 시작 위치
		int beadsCnt = 0;
		int len = 1; // 1,1,2,2,...,N
		int lenCnt = 0; // len을 늘려줄 카운트
		boolean isBreak = false;
		int d = 0;// 방향
		while (!isBreak) {
			for (int l = 0; l < len; ++l) {
				pos[0] += moveDir[0][d];
				pos[1] += moveDir[1][d];
				beads[beadsCnt++] = new Node(pos[0], pos[1], map[pos[0]][pos[1]]);
				if (pos[0] == 0 && pos[1] == 0) {
					isBreak = true;
					break;
				}
			}
			if (++lenCnt >= 2) {
				++len;
				lenCnt = 0;
			}
			if (++d >= 4)
				d = 0;
		}
	}

	static void magic() {
		int[] pos = new int[] { shark[0], shark[1] };
		for (int s = 0; s < S; ++s) { // s 길이 만큼 파괴시켜야 한다.
			pos[0] += dir[0][D];
			pos[1] += dir[1][D];
			if (isBoundary(pos)) { // 범위 안에 있다면
				map[pos[0]][pos[1]] = 0; // 맵에서 구슬을 파괴한다.
				for (int bead = 0; bead < beads.length; ++bead) {
					Node cur = beads[bead];
					if (cur.x == pos[0] && cur.y == pos[1]) { // beads에서 해당 구슬삭제
						beads[bead] = new Node(pos[0], pos[1], 0);
						break;
					}
				}
			}
		}
		move(); // 0이 된 곳을 채워준다.
	}

	static void explosion() {
		boolean isBreak = false;
		while (!isBreak) { // 더 이상 폭발할 게 없을 때 까지 반복한다.
			isBreak = true;
			for (int i = 0; i < beads.length -1; ++i) {
				int cnt = 1; // 같은 숫자 개수 카운팅
				if (beads[i].num != 0) {
					// 0이 아니고 다음거랑 같으면
					for (int j = i + 1; j < beads.length; ++j) {
						if (beads[i].num == beads[j].num)
							++cnt;
						else
							break;
					}
					if (cnt >= 4) { // 4개 이상 연속되면
						isBreak = false; // 그만두고
						bombCnt[beads[i].num-1] += cnt;// 카운트를 더해준다.
						for (int j = i; j < i + cnt; ++j) {
							beads[j].num = 0; // 폭발 시킨다.
						}
					}
				}
			}
			move(); // 폭발 후 생긴 0을 채워준다.
		}
	}

	static void change() {
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < beads.length - 1; ++i) {
			if (beads[i].num == 0)
				break;
			int cnt = 1; // 개수 세기
			for (int j = i + 1; j < beads.length; ++j) {
				if (beads[i].num == beads[j].num)
					++cnt;
				else {
					q.offer(new int[] { cnt, beads[i].num });// 변화를 넣어준다
					i += cnt-1;// i의 위치를 옮겨준다.
					break;
				}
			}
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			if(cnt >= N*N-1) break; // 범위 벗어나면 그만.
			int[] now = q.poll();
			beads[cnt++].num = now[0];
			beads[cnt++].num = now[1];
		}
	}

	static void move() {
		int maxLen = N * N - 1;
		for (int i = 0; i < maxLen; ++i) {
			int cnt = 0;// 0이 연속될 수도있기 때문에 카운트
			if (beads[i].num == 0) {
				int idx = i;
				while (idx < maxLen && beads[idx++].num == 0) {
					++cnt; // 연속된 0의 개수를 센다.
				}
				for (int j = i; j < i + cnt; ++j) {
					if (j + cnt >= maxLen)
						break; // 범위 벗어나면 그만
					beads[j].num = beads[j + cnt].num;// 당겨오고
					beads[j + cnt].num = 0; // 0으로 바꿔준다.
				}
			}
		}
	}

	// 영역안에 있는지 여부 검사
	static boolean isBoundary(int[] pos) {
		return 0 <= pos[0] && pos[0] < N && 0 <= pos[1] && pos[1] < N;
	}

	/* test print */
	static void print() {
		System.out.println("====================================================");
		for (int i = 0; i < beads.length; ++i) {
			System.out.print(beads[i].num);
			System.out.print(i % 7 == 0 ? "\n" : " ");
		}
		System.out.println();
	}
}
