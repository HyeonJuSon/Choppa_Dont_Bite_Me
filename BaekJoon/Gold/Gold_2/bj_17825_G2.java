package gold;

import java.io.*;
import java.util.*;

public class bj_17825_G2 {
	static final int scoreCnt = 10;
	static int[] score;
	static Node[][] board;
	static final int nodeCnt = 33;
	static int Max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		score = new int[scoreCnt];
		for (int i = 0; i < scoreCnt; ++i) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		board = new Node[2][33];
		initBoard(); // 게임판을 초기화 한다.
		Max = Integer.MIN_VALUE; // 결과를 담을 변수를 초기화한
		process(); // 시작
		System.out.println(Max); // 최댓값을 출력한다.
	}

	// 말의 위치
	static ArrayList<Integer> horses;

	static void process() {
		// 1. 10개의 말을 픽한다.
		comb(0, new int[10]);

	}

	static void comb(int cnt, int[] select) {
		if (cnt == 10) {
			// 2. 말을 이동시켜본다.
			horses = new ArrayList<Integer>(); // 말들 초기화
			for (int i = 0; i < 4; ++i) {
				horses.add(0); // 0번 위치에 4마리 있음
			}
			// 뽑은 말을 돌면서 체크해본다.
			int sum = 0;
			boolean move = true; // 이동가능 여부
			boolean[] isVisited = new boolean[nodeCnt];// 말 위치 체크
			// String now = "LOG =================\n";
			root: for (int i = 0; i < 10; ++i) {
				int nowPos = horses.get(select[i]); // 현재 뽑은 말의 위치
				if (nowPos == -1) { // 도착칸에 있는걸 또고르면 최댓값 X
					move = false;
					break root;
				}
				isVisited[nowPos] = false;// 이동할거기때문에 지워진다
				int nowScore = score[i];// 현재 주사위 점수
				boolean isBlue = false;
				if (nowPos == 5 || nowPos == 10 || nowPos == 15) {
					isBlue = true;
				}
				// now += "ㅁ 이동 :"+nowPos+"-> ";
				for (int s = 0; s < nowScore; ++s) { // 주사위 점수만큼 한칸씩 이동
					// 현재 위치가 파란색 칸인지?
					if (isBlue) {
						if (board[1][nowPos].to == -1) {
							nowPos = board[1][nowPos].to;
							break;
						}
						if (s==nowScore-1&&isVisited[board[1][nowPos].to]) { // 이 경우의 수는 사용 불가
							move = false;
							break root;
						}
						nowPos = board[1][nowPos].to;// 갱신해준다.
						isBlue = false;
					} else { // 빨간색 칸
						if (board[0][nowPos].to == -1) {
							nowPos = board[0][nowPos].to;
							break;
						}
						if (s==nowScore-1&&isVisited[board[0][nowPos].to]) { // 이 경우의 수는 사용 불가
							move = false;
							break root;
						}
						nowPos = board[0][nowPos].to;
					}
				}
				if (nowPos != -1) { // 도착지에 도착햇으면 점수 x
					sum += board[0][nowPos].score;// score는 같아서 아무거나 (행=0,1)더해줌
					isVisited[nowPos] = true; // 이동 위치에 놓아준다.
				}
				horses.set(select[i], nowPos);// 위치를 갱신한다.
				// now += nowPos+"-> ";
			}
			if (move) { // 이동가능하다면
				// System.out.println(now);
				Max = Math.max(Max, sum);
			}
			return;
		}
		for (int i = 0; i < 4; ++i) {
			select[cnt] = i;
			comb(cnt + 1, select);
		}
	}

	// 게임판 초기화
	static void initBoard() {
		// 1. 빨간색 부터
		int score = 0;
		// 가장 바깥쪽 라인
		for (int i = 0; i < 19; ++i, score += 2) {
			board[0][i] = new Node(i + 1, score);
		}
		board[0][19] = new Node(31, 38);
		// 안쪽 라인
		board[0][20] = new Node(21, 13);
		board[0][21] = new Node(22, 16);
		board[0][22] = new Node(28, 19);

		board[0][23] = new Node(24, 22);
		board[0][24] = new Node(28, 24);

		board[0][25] = new Node(26, 28);
		board[0][26] = new Node(27, 27);
		board[0][27] = new Node(28, 26);
		// 정중앙부터 위로
		score = 25; // 정 중앙
		for (int i = 28; i < 32; ++i, score += 5) {
			board[0][i] = new Node(i + 1, score);
		}
		board[0][32] = new Node(-1, -1); // 도착 지점

		// 파란색
		board[1][5] = new Node(20, 10);
		board[1][10] = new Node(23, 20);
		board[1][15] = new Node(25, 30);
	}

	static class Node {
		int to;
		int score;

		public Node(int to, int score) {
			this.to = to;
			this.score = score;
		}
	}

}
