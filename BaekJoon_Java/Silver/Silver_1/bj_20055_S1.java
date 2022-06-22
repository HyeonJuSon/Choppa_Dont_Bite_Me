package silver;

import java.io.*;
import java.util.*;

public class bj_20055_S1 {

	static class Belt {
		int val;
		boolean isRobot;

		Belt(int val, boolean isRobot) {
			this.val = val;
			this.isRobot = isRobot;
		}
	}

	static int[][] dir= {{1,0,-1,0},{0,1,0,-1}};// 하 우 상 좌
	static int N;
	static Belt[][] belts;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		belts = new Belt[2][N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < N; ++j)
			belts[0][j] = new Belt(Integer.parseInt(st.nextToken()), false);
		for (int j = N - 1; j >= 0; --j)
			belts[1][j] = new Belt(Integer.parseInt(st.nextToken()), false);

		int step = 0;
		while (true) {
			++step;
			if(belts[0][N-1].isRobot) belts[0][N-1].isRobot=false;
			// step 1
			Belt tmp = belts[0][0];
			int x = 0;
			int y = 0;
			for (int d = 0; d < 4; ++d) {
				int nx = x + dir[0][d];
				int ny = y + dir[1][d];
				if (isBoundary(nx, ny)) {
					belts[x][y] = belts[nx][ny];
					x = nx;
					y = ny;
					--d;
				}
			}
			belts[x][y+1]=tmp;
			if(belts[0][N-1].isRobot) belts[0][N-1].isRobot=false;
			// step 2
			for(int j=N-2;j>=1;--j) {
				if(belts[0][j].isRobot && !belts[0][j+1].isRobot && belts[0][j+1].val>0) {
					belts[0][j].isRobot = false;
					belts[0][j+1].isRobot = true;
					--belts[0][j+1].val;
				}
			}
			// step 3
			if(belts[0][0].val > 0) {
				belts[0][0].isRobot=true;
				--belts[0][0].val;
			}
			// check
			int cnt = 0;
			for(int i=0;i<2;++i) {
				for(int j=0;j<N;++j) {
					if(belts[i][j].val==0)++cnt;
				}
			}
			if(cnt >= K) break;
		}
		System.out.println(step);
	}

	static void print() {
		for(int i=0;i<2;++i) {
			for(int j=0;j<N;++j) {
				System.out.print(belts[i][j].val+" ");
			}
			System.out.println();
		}
	}
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < 2 && 0 <= y && y < N;
	}
}
