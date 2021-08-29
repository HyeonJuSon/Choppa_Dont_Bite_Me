package gold;

import java.io.*;
import java.util.*;

public class bj_20056_G5 {
	static class FireBall {
		int x, y;
		int m, s, d;

		FireBall(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int N, M, K;
	static int[][] dir = { { -1, -1, 0, 1, 1, 1, 0, -1 }, { 0, 1, 1, 1, 0, -1, -1, -1 } };
	static Queue<FireBall> fireballs = new LinkedList<>();
	static ArrayList<FireBall>[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		map = new ArrayList[N][N]; // map 초기화
		for (int i = 0; i < M; ++i) { // 파이어볼을 입력받는다.
			st = new StringTokenizer(br.readLine(), " ");
			int x = stoi(st.nextToken()) - 1;
			int y = stoi(st.nextToken()) - 1;
			fireballs.offer(new FireBall(x, y, stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
		} // 입력 끝
		System.out.println(process()); // 출력
	}

	static public int process() {

		for (int i = 0; i < K; ++i) { // 이동을 K번 한다.
			// 0. 맵초기화
			for (int x = 0; x < N; ++x) {
				for (int y = 0; y < N; ++y) {
					map[x][y] = new ArrayList<>();
				}
			}
			// 1. 모든 파이어볼이 d방향으로 s속력만큼 이동한다.
			while(!fireballs.isEmpty()) { 
				FireBall current = fireballs.poll(); // 이동작업
				current.x = (current.x + N + dir[0][current.d] * current.s % N) % N;
				current.y = (current.y + N + dir[1][current.d] * current.s % N) % N;
				map[current.x][current.y].add(current);// 맵에 추가해준다.
			}
			// 2. 파이어볼이 2개 이상인 곳 처리, 1개인 곳 그냥 넣기
			for (int x = 0; x < N; ++x) {
				for (int y = 0; y < N; ++y) {
					if (map[x][y].size() == 1)// 1개면 그냥 큐에 넣기
						fireballs.offer(map[x][y].get(0)); 
					else if (map[x][y].size() >= 2)// 2개이상이면 처리해줘야한다.
						divideFireBalls(x, y); 
				}
			}
		}
		// 3. 계산해서 반환하기
		return getSum();
	}

	static int getSum() {
		int sum = 0;
		while (!fireballs.isEmpty()) sum += fireballs.poll().m;
		return sum;
	}

	static void divideFireBalls(int x, int y) {
		int mSum = 0, sSum = 0;
		boolean isOdd = false, isEven = false;
		for (int i = 0; i < map[x][y].size(); ++i) {
			mSum += map[x][y].get(i).m;
			sSum += map[x][y].get(i).s;
			if (map[x][y].get(i).d % 2 == 0) isEven = true;
			else isOdd = true;
		}

		int m = mSum / 5;
		int s = sSum / map[x][y].size();
		if (m > 0) { // 질량이 0이면 소멸된다.
			if (isEven != isOdd) {// 모두 홀수 or 짝수
				for(int i=0;i<4;++i) 
					fireballs.offer(new FireBall(x,y,m,s,2*i));
			} else { // 반대의 경우
				for(int i=1;i<=4;++i) 
					fireballs.offer(new FireBall(x,y,m,s,2*i-1));
			}
		}
	}

	static public int stoi(String s) { // string to int
		return Integer.parseInt(s);
	}

}
