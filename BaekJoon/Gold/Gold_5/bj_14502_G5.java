package bj.gold;
//1시간 18분 걸렸음!!!!!골드!!!!
import java.io.*;
import java.util.*;

public class bj_14502_G5 {

	static int Int(String s) {
		return Integer.parseInt(s);
	}

	static int[][] arr, copy;
	static int N, M, R = 3, max = Integer.MIN_VALUE;
	static int[] input = new int[R];			// 뽑힌 인덱스가 담길 배열 (3개만담김)
	static final int empty = 0, wall = 1, virus = 2;
	static ArrayList<Pos> viruses = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Int(st.nextToken()); 				// 행
		M = Int(st.nextToken()); 				// 열
		arr = new int[N][M]; 					// 원본 배열
		copy = new int[N][M]; 					// 벽을 계속 놓아보기 위한 배열
		for (int i = 0; i < N; ++i) {// 입력을받는다.
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Int(st.nextToken());
				if(arr[i][j] == virus) viruses.add(new Pos(i,j));
			}
		}
		Combination(0, 0, 0);
		System.out.println(max);
	}

	static void copyOrigin() { // 깊은 복사해야함
		for (int i = 0; i < copy.length; ++i)
			System.arraycopy(arr[i], 0, copy[i], 0, arr[0].length);
	}
	
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x =x;
			this.y=y;
		}
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		for(Pos p : viruses) q.offer(p);
		boolean[][] isVisited = new boolean[N][M];
		isVisited[q.peek().x][q.peek().y] = true;
		
		while(!q.isEmpty()) {
			Pos current = q.poll();
			copy[current.x][current.y]= virus; 
			for(int d=0;d<4;++d) {
				int nx= current.x  + dx[d];
				int ny = current.y + dy[d];
				if(0<=nx&&nx<N && 0<=ny &&ny<M&& 
				!isVisited[nx][ny] &&copy[nx][ny]==empty) {
					isVisited[nx][ny] = true;
					q.offer(new Pos(nx,ny));
				}
			}
		}
	}
	
	static int getCount() {
		int cnt =0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(copy[i][j] == empty) cnt++;
			}
		}
		return cnt;
	}
	
	static void Combination(int start, int idx, int cnt) {
		if (cnt == R) {
			copyOrigin();// 배열을 복사하고                 열기준으로 생각하면 됌.
			for (int x = 0; x < R; ++x) copy[input[x] / M][input[x] % M] = 1; // 실제로 벽을 세워본다.
			bfs();// bfs로 바이러스를 퍼뜨려본다.
			max = Math.max(max, getCount());// 안전영역을 카운트 한다.
			return;
		}

		for (int i = start; i < N * M; ++i) {
			if (arr[i / M][i % M] == empty) {	// 빈공간에만 벽을 세울수 있음.
				input[idx] = i;
				Combination(i + 1, idx + 1, cnt + 1);
			}
		}
	}
}
