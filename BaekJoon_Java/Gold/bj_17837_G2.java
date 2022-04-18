package gold;

import java.io.*;
import java.util.*;

public class bj_17837_G2 {
	static class Horse {
		int dir, x, y;

		Horse(int dir, int x, int y) {
			this.dir = dir;
			this.x = x;
			this.y = y;
		}
	}

	static class Tower {
		int color;
		ArrayList<Integer> list;

		Tower(int color) {
			this.color = color;
			list = new ArrayList<Integer>();
		}
	}

	static int N, K;
	static Tower[][] map;
	static ArrayList<Horse> horses;
	static final int white = 0, red = 1, blue = 2;
	static int[][] direction = { { 0, 0, 0, -1, 1 }, { 0, 1, -1, 0, 0 } }; // ��,��,��,��

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Tower[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = new Tower(Integer.parseInt(st.nextToken()));
			}
		}
		horses = new ArrayList<>(); // ���� ������ ��Ƶ� ����Ʈ
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			horses.add(new Horse(d, x, y));
			map[x][y].list.add(i);
		}
		int answer = 0;
		while (true) {
			if (isClear())
				break;
			if (++answer > 1000)
				break;
			move();
		}
		System.out.println(answer > 1000 ? -1 : answer);
	}

	static void copy(ArrayList<Integer> tmp, ArrayList<Integer> ori) {
		tmp.clear();
		for (int o : ori) {
			tmp.add(o);
		}
	}

	static void move() {
		// ������� �̵��Ѵ�.
		for (int i = 0; i < K; ++i) {
			Horse now = horses.get(i); // ���� ��
			int nx = now.x + direction[0][now.dir];
			int ny = now.y + direction[1][now.dir];
			ArrayList<Integer> nowList = new ArrayList<>();// �� ��ġ�� ���� �� ����Ʈ
			copy(nowList, map[now.x][now.y].list);
			ArrayList<Integer> tmp = new ArrayList<>(); // �̵� ��ġ�� ���� �� ����Ʈ
			ArrayList<Integer> after = new ArrayList<>(); // �� ��ġ�� ���� �� ����Ʈ
			int nowLen = map[now.x][now.y].list.size();
			int target = map[now.x][now.y].list.indexOf(i); // ���� ���� ����Ʈ�� �� ��° ��ġ�� ����ִ°�?
			if (!isBoundary(nx, ny) || map[nx][ny].color == blue) {
				now.dir = getReverseDir(now.dir); // ������ �ٲٰ�
				nx = now.x + direction[0][now.dir];
				ny = now.y + direction[1][now.dir];
				if (!isBoundary(nx, ny) || map[nx][ny].color == blue) {
					continue; // �� �̵����ϸ� ����
				}
				if (map[nx][ny].color == red) {
					for (int x = 0; x < target; ++x)
						after.add(nowList.get(x)); // �̵� �ȵǴ� ���Ҵ� ����
					for (int x = nowLen - 1; x >= target; --x)
						tmp.add(nowList.get(x));// ������ �Ųٷ� ��
				} else {
					for (int x = 0; x < target; ++x) // �̵��� ���� �ֵ�
						after.add(nowList.get(x));
					for (int x = target; x < nowLen; ++x) // �̵� �� �ֵ�
						tmp.add(nowList.get(x));
				}
			} else if (map[nx][ny].color == red) {
				for (int x = 0; x < target; ++x)
					after.add(nowList.get(x)); // �̵� �ȵǴ� ���Ҵ� ����
				for (int x = nowLen - 1; x >= target; --x)
					tmp.add(nowList.get(x));// ������ �Ųٷ� ��
			} else if (map[nx][ny].color == white) { // �׳� �ٷ� �̵�
				for (int x = 0; x < target; ++x)
					after.add(nowList.get(x));
				for (int x = target; x < nowLen; ++x)
					tmp.add(nowList.get(x));
			}
			copy(map[now.x][now.y].list, after);
			for (int idx : tmp) { // �ٰ��� ��ġ�� �ٲ���� �Ѵ�.
				map[nx][ny].list.add(idx);
				horses.get(idx).x = nx;
				horses.get(idx).y = ny;
			}
			if (isClear())
				break;
		}
	}

	static int getReverseDir(int d) {
		if (d == 1 || d == 3)
			return d + 1;
		return d - 1;
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static boolean isClear() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j].list.size() >= 4)
					return true;
			}
		}
		return false;
	}
}
// ��ȣ, ����, ��ġ
// 