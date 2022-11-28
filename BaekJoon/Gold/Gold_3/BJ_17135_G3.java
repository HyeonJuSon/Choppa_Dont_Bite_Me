import java.util.*;
import java.io.*;

public class BJ_17135_G3 {

	static int N, M, D;
	static Queue<int[]> Archers;
	static ArrayList<Pos> eInfo, enemies;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		eInfo = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 1) {
					eInfo.add(new Pos(i, j));
				}
			}
		}

		// 가능한 궁수 배치
		InitArchers();
		// 가능한 궁수 배치가 없을때까지 반복
		int answer = 0;
		while (!Archers.isEmpty()) {
			int[] archer = Archers.poll();
			enemies = new ArrayList<>();
			for (int i = 0; i < eInfo.size(); ++i)
				enemies.add(new Pos(eInfo.get(i)));
			int cnt = 0;
			// 해당 턴의 적이 더이상 없을때까지 반복
			while (!enemies.isEmpty()) {
				// 궁수 공격
				cnt += ArcherAttack(archer);
				// 적 이동
				EnemyMove();
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	static int ArcherAttack(int[] archer) {
		int cnt = 0;
		Queue<Pos> target = new LinkedList<>();
		for (int i = 0; i < archer.length; ++i) {
			int min = Integer.MAX_VALUE;
			Pos tmp = null;
			for (Pos e : enemies) {
				// 현재 거리
				int now = Math.abs(N - e.x) + Math.abs(archer[i] - e.y);
				// D보다 거리가 먼 적은 패스
				if (now > D) continue;
				// 가장 가까운 적으로 갱신
				if (min > now) {
					min = now;
					tmp = e;
				} else if (min == now) {
					if (tmp.y > e.y) {
						min = now;
						tmp = e;
					}
				}
			}
			// 공격할 적을 추가
			target.add(tmp);
		}
		// 적을 공격한다.
		while (!target.isEmpty()) {
			Pos t = target.poll();
			if (enemies.contains(t)) {
				enemies.remove(t);
				++cnt;
			}
		}
		return cnt;
	}

	static void EnemyMove() {

		for (int i = 0; i < enemies.size(); ++i) {
			if (++enemies.get(i).x == N) {
				enemies.remove(i);
				--i;
			}
		}
	}

	static void InitArchers() {
		Archers = new LinkedList<>();
		FindArchers(0, 0, new int[3]);
	}

	static void FindArchers(int cnt, int start, int[] input) {
		if (cnt == 3) {
			int[] tmp = new int[3];
			for (int i = 0; i < 3; ++i)
				tmp[i] = input[i];
			Archers.add(tmp);
			return;
		}
		// 0 ~ M C 3
		for (int i = start; i < M; ++i) {
			input[cnt] = i;
			FindArchers(cnt + 1, i + 1, input);
		}
	}

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Pos(Pos p) {
			this.x = p.x;
			this.y = p.y;
		}
	}

}
