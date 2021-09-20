package gold;

import java.io.*;
import java.util.*;

public class bj_17143_G2 {
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int R, C, M, sum = 0;
	static Shark[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
		}
		int kingPos = -1;
		while (++kingPos < C) {
			kill(kingPos);
			move();
		}
		bw.write(sum+"");
		bw.flush();
	}

	static void kill(int kingPos) {
		for (int i = 0; i < R; ++i) {
			if (map[i][kingPos] != null) {
				sum += map[i][kingPos].z;
				map[i][kingPos] = null;// 상어를 잡는다.
				break;
			}
		}
	}

	static int[][] dir = { { -1, 1, 0, 0 }, { 0, 0, 1, -1 } };// 상 하 우 좌 순서

	static void move() {
//		PriorityQueue<Shark> afterMoves = new PriorityQueue<Shark>();
		Queue<Shark> afterMoves = new LinkedList<>();
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] != null) { // 상어가 있으면
					Shark now = map[i][j];
					for (int s = 0; s < now.s; ++s) {
						now.r += dir[0][now.d];
						now.c += dir[1][now.d];
						if (!isBoundary(now.r, now.c)) {
							if(now.d <=1) now.d = 1-now.d;
							else now.d = 5-now.d;
							now.r += dir[0][now.d]*2;
							now.c += dir[1][now.d]*2;
						}
					}
					afterMoves.add(new Shark(now.r, now.c, now.s, now.d, now.z));
					map[i][j] = null;
				}
			}
		}
		// 상어 이동 작업을 완료한다.
		while (!afterMoves.isEmpty()) {
			Shark now = afterMoves.poll();
			boolean isBigger = true;
			if(map[now.r][now.c]!=null) {
				isBigger = map[now.r][now.c].z < now.z ? true : false;
			}
			if(isBigger)
				map[now.r][now.c] = new Shark(now.r, now.c, now.s, now.d, now.z);
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}

	
}
