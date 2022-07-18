import java.io.*;
import java.util.*;

public class bj_14500_G5 {

	static class Block {
		int x, y;
		int[][] arr;

		Block(int x, int y, int[][] arr) {
			this.x = x;
			this.y = y;
			this.arr = arr;
		}
	}

	static int N, M, map[][];
	static ArrayList<Block> blocks = new ArrayList<>(); // 블록들을 담을 배열
	static final int blockCnt = 19; // 총 블록 개수 (회전 포함)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		initBlocks(); // 블록초기화.
		System.out.println(process());
	}

	public static int process() {
		int Max = Integer.MIN_VALUE;
		for (int i = 0; i < blockCnt; ++i) { // 하나씩 뽑아서 놔보기
			Block now = blocks.get(i); // 현재 블록
			for (int x = 0; x < N; ++x) {
				for (int y = 0; y < M; ++y) {
					int sum = 0;
					boolean isPossible = true;
					for (int xx = 0; xx < now.x; ++xx) {
						if (!isPossible)
							break;
						for (int yy = 0; yy < now.y; ++yy) {
							if (0 > x+xx || x+xx >= N || 0 > y+yy || y+yy >= M) {
								isPossible = false;
								sum = 0;
								break;
							}
							if(now.arr[xx][yy]==1)
								sum += map[x+xx][y+yy];
						}
					}
					Max = Math.max(Max, sum);
				}
			}
		}

		return Max;
	}

	public static void initBlocks() {
		// type 1. | ㅡ
		blocks.add(new Block(4, 1, new int[][] { { 1 }, { 1 }, { 1 }, { 1 } }));
		blocks.add(new Block(1, 4, new int[][] { { 1, 1, 1, 1 } }));
		// type 2. ㄴ 모양
		blocks.add(new Block(3, 2, new int[][] { { 1, 0 }, { 1, 0 }, { 1, 1 } }));
		blocks.add(new Block(3, 2, new int[][] { { 0, 1 }, { 0, 1 }, { 1, 1 } }));
		blocks.add(new Block(3, 2, new int[][] { { 1, 1 }, { 0, 1 }, { 0, 1 } }));
		blocks.add(new Block(3, 2, new int[][] { { 1, 1 }, { 1, 0 }, { 1, 0 } }));
		blocks.add(new Block(2, 3, new int[][] { { 0, 0, 1 }, { 1, 1, 1 } }));
		blocks.add(new Block(2, 3, new int[][] { { 1, 0, 0 }, { 1, 1, 1 } }));
		blocks.add(new Block(2, 3, new int[][] { { 1, 1, 1 }, { 1, 0, 0 } }));
		blocks.add(new Block(2, 3, new int[][] { { 1, 1, 1 }, { 0, 0, 1 } }));
		// type 3. ㄹ 모양
		blocks.add(new Block(3, 2, new int[][] { { 1, 0 }, { 1, 1 }, { 0, 1 } }));
		blocks.add(new Block(3, 2, new int[][] { { 0, 1 }, { 1, 1 }, { 1, 0 } }));
		blocks.add(new Block(2, 3, new int[][] { { 0, 1, 1 }, { 1, 1, 0 } }));
		blocks.add(new Block(2, 3, new int[][] { { 1, 1, 0 }, { 0, 1, 1 } }));
		// type 4. ㅗ 모양
		blocks.add(new Block(2, 3, new int[][] { { 1, 1, 1 }, { 0, 1, 0 } }));
		blocks.add(new Block(2, 3, new int[][] { { 0, 1, 0 }, { 1, 1, 1 } }));
		blocks.add(new Block(3, 2, new int[][] { { 1, 0 }, { 1, 1 }, { 1, 0 } }));
		blocks.add(new Block(3, 2, new int[][] { { 0, 1 }, { 1, 1 }, { 0, 1 } }));
		// type 5. ㅁ 모양
		blocks.add(new Block(2, 2, new int[][] { { 1, 1 }, { 1, 1 } }));
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
