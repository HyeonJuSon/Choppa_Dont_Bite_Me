package gold;

import java.io.*;
import java.util.*;

public class bj_19237_G2 {

	static int N, M, K;
	static Smell[][] map;
	static TreeMap<Integer, Shark> sharks;
	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// init
		map = new Smell[N][N];
		sharks = new TreeMap<>();
		// map init
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				int val = Integer.parseInt(st.nextToken());
				if (val > 0) {
					sharks.put(val, new Shark(val,i, j, -1)); // ��� ��ġ�� �־��ְ�
					map[i][j] = new Smell(val, K); // ����� ������ �־��ش�.
				}
			}
		}
		// direction init
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; ++i) { // ����� ���� ������ �������ش�.
			int dir = Integer.parseInt(st.nextToken())-1;
			sharks.put(i, new Shark(i,sharks.get(i).x, sharks.get(i).y, dir));
		}
		// order init
		for (int i = 1; i <= M; ++i) { // ��� ������ ��ŭ ��/��/��/�� �켱������ �޾Ƶ��δ�.
			for (int x = 0; x < 4; ++x) { // �� / �� / �� / ��
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < 4; ++y) { // 0 / 1/ 2/ 3
					sharks.get(i).order[x][y] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		// process
		int time = 0;
		while (true) {
			if (++time >1000)
				break; // 1000 �� �ʰ��� �Ǹ� break;
			// ��� �̵�
			Queue<Shark> move = new LinkedList<>();
			for (Integer idx : sharks.keySet()) {
				Shark now = sharks.get(idx); // ���� �� �����´�.
				// ���ο� ������ ã�´�. (������ ���� ĭ ���� ã�´�.)
				boolean isFind = false;
				for (int d = 0; d < 4; ++d) {
					int nDir = now.order[now.dir][d];// ���� ���⿡�� �켱������ ���������� �ҷ��´�.
					int nx = now.x + dir[0][nDir];
					int ny = now.y + dir[1][nDir];
					if (!isBoundary(nx, ny))
						continue;
					if (map[nx][ny] == null) { // ������ ���ٸ�
						now.dir = nDir; // ������ �ٲ��ش�.
						move.add(new Shark(now.num,nx,ny,now.dir)); // ���� �̵��� ���ؼ� ����ش�.
						isFind = true;
						break;
					}
				}
				if(isFind) continue; // ã������ �н�
				for(int d=0 ; d<4;++d) {
					int nDir = now.order[now.dir][d];
					int nx = now.x  +dir[0][nDir];
					int ny = now.y + dir[1][nDir];
					if(!isBoundary(nx,ny)) continue;
					if(map[nx][ny].num == now.num) { // �� �������
						now.dir=nDir;
						move.add(new Shark(now.num,nx,ny,now.dir));
						break;
					}
				}
			}
			// ���� ����
			minusSmell();
			// ��� ���� �̵�
			moveShark(move);
			// 1�� �� ���Ҵ���?
			if(sharks.size()==1 && sharks.containsKey(1)) break;
		}
		System.out.println(time > 1000 ? -1 : time);
	}
	
	static void moveShark(Queue<Shark> move) {
		while(!move.isEmpty()) {
			Shark now = move.poll();
			if(map[now.x][now.y]==null || map[now.x][now.y].num == now.num) {
				// ��ġ ����
				sharks.get(now.num).x = now.x;
				sharks.get(now.num).y = now.y;
				// ���� ����
				map[now.x][now.y]= new Smell(now.num, K);
			}else {
				if(map[now.x][now.y].num > now.num) { // ���� �� ���� ��ȣ��� �켱������ ������.
					sharks.remove(map[now.x][now.y].num); // �ش� ��ġ �� �����ش�.
					// ��ġ ����
					sharks.get(now.num).x = now.x;
					sharks.get(now.num).y = now.y;
					// ���� ����
					map[now.x][now.y]= new Smell(now.num, K);
				}else sharks.remove(now.num); // �� �����ش�.
			}
		}
	}
	
	static void minusSmell() {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(map[i][j]==null) continue;
				if(--map[i][j].cnt <= 0) {
					map[i][j] = null;
				}
			}
		}
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	// class ===================
	static class Shark {
		int num;
		int x, y;
		int dir;
		int[][] order = new int[4][4];

		public Shark(int num, int x, int y, int dir) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static class Smell {
		int num;
		int cnt;

		public Smell(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
