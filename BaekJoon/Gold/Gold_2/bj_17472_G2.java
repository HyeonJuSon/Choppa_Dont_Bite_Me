package bj.gold;

import java.io.*;
import java.util.*;

public class bj_17472_G2 {
	// 좌표를 나타내기 위한 객체
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 간선 class
	static class edge implements Comparable<edge> {
		int start, end, value;

		public edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(edge o) {
			return Integer.compare(this.value, o.value);
		}
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, map[][];
	static boolean[][] isVisited;
	static final int empty = 0, island = -1;
	static PriorityQueue<edge> edges = new PriorityQueue<>();
	static int[] parents; // 사장님들 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Int(st.nextToken());
		M = Int(st.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Int(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = island;
			}
		}
		// 몇 개의 섬으로 이루어졌는지 살펴봄
		int islandCnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == island) {
					islandCnt++;
					dfs(i, j, islandCnt);
				}
			}
		}
		// 다리를 깔아본다.
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] != empty)
					makeBridge(i, j, map[i][j]);
			}
		}
		// 크루스칼 알고리즘 실행
		// pq 반복, 사이클 확인해가면서 최소 간선 합구하는 알고리즘
		parents = new int[islandCnt+1];
		// make
		for(int i=0;i<parents.length;++i) parents[i] = i;
		// kruskal
		int result =0;
		int bridgeCnt =0;
		int size = edges.size();
		for(int i=0;i<size;++i) {
			edge current = edges.poll();
			int a= find(current.start);
			int b= find(current.end);
			if(a==b) 
				continue; // 이미 연결되있으면 통과
			union(current.start, current.end);//연결
			result+=current.value;
			bridgeCnt++;
		}
		if(result == 0 || bridgeCnt != islandCnt-1) System.out.println(-1);
		else System.out.println(result);
	}

	static void print() {
		System.out.println("-------");
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void makeBridge(int x, int y, int islandNum) {
		int nx = x;
		int ny = y;
		int length = 0;

		for (int d = 0; d < 4; ++d) {
			while (true) {// 한쪽 방향으로 쭈욱 나가본다.
				nx += dx[d];
				ny += dy[d];
				if (isAvailable(nx, ny)) { // 진행가능한 경우
					if (map[nx][ny] == empty) {// 0이면 나아갈수있다.
						length++;
					} else if (map[nx][ny] == islandNum) {// 내 자신이면 초기화하면 break
						nx = x;
						ny = y;
						length = 0;
						break;
					} else {// 다른 번호면 섬에 도달한경우므로 길이를 검사하고 break
						if (length > 1) {
							edges.offer(new edge(islandNum, map[nx][ny], length));
						}
						nx = x;
						ny = y;
						length = 0;
						break;
					}
				} else { // 불가능한 경우 다시 초기화
					nx = x;
					ny = y;
					length = 0;
					break;
				}
			}
		}
	}

	static void dfs(int x, int y, int cnt) {
		map[x][y] = cnt;// 해당섬에 번호를 붙인다.
		for (int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isAvailable(nx, ny) && map[nx][ny] == island) {
				dfs(nx, ny, cnt);
			}
		}
	}

	// union & find algorithm
	static int find(int a){
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) parents[rootA] = b;
		else return;
	}
	
	static boolean isAvailable(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}

/*
 * 7 8 0 0 0 0 0 0 1 1 1 1 0 0 0 0 1 1 1 1 0 0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0 0
 * 1 1 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1
 */
