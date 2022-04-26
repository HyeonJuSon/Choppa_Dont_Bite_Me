package gold;

import java.io.*;
import java.util.*;

public class bj_13460_G1 {

	static int N, M, original[][];
	static final int empty = 0, wall = 1, hole = 2, red = 3, blue = 4;
	static final int L = 0, R = 1, U = 2, D = 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		original = new int[N][M];
		Ball redBall = new Ball(-1, -1);
		Ball blueBall = new Ball(-1, -1);
		Ball goal = new Ball(-1, -1);
		for (int i = 0; i < N; ++i) {
			String now = br.readLine();
			for (int j = 0; j < M; ++j) {
				char ch = now.charAt(j);
				if (ch == '#')
					original[i][j] = wall;
				else if (ch == '.')
					original[i][j] = empty;
				else if (ch == 'O') {
					original[i][j] = hole;
					goal = new Ball(i, j);
				} else if (ch == 'R') {
					original[i][j] = red;
					redBall = new Ball(i, j);
				} else {
					original[i][j] = blue;
					blueBall = new Ball(i, j);
				}
			}
		}
		// 탐색한다.
		Queue<Node> bfs = new LinkedList<>();
		int answer = Integer.MAX_VALUE;
		bfs.add(new Node(original, 0)); // 한번도 안굴린 상태를 넣어준다.
		while (!bfs.isEmpty()) {
			Node now = bfs.poll();
			if (now.cnt > answer || now.cnt > 10) {
				continue;
			}
			for (int d = 0; d < 4; ++d) {
				int[][] tmp = copy(now.nowMap); // 복사해서 넣어준다.(굴려야하기 때문)
				int goalState = turnBall(tmp, d); // 0은 이동 가능, 1은 빨강이 골일때, 2는 파랑이 골에 들어갔을 떄
				if(goalState==0) {//더 굴러가야한다면
					bfs.add(new Node(tmp, now.cnt+1));
				}else if(goalState == 1) {
					answer = Math.min(answer, now.cnt+1);
					continue;
				}else {
					continue;
				}
			}
		}
		// 출력
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static int turnBall(int[][] map, int d) {
		// 같이 들어가는 경우
		if (d == L) { // 좌로 굴릴 때.
			for (int i = 1; i < N-1; ++i) {
				for (int j = 1; j < M-1; ++j) {
					if (map[i][j] == red) {
						int tmp = j;
						while (true) {
							if (map[i][tmp] != wall && map[i][tmp] != blue) {
								if (map[i][tmp] == hole) {
									return 1; // 구멍에 빨간 공이 들어갔음.
								}
								map[i][tmp + 1] = empty;
								map[i][tmp--] = red;
							} else
								break;
						}
					} else if(map[i][j]==blue) {
						int tmp = j;
						while (true) {
							if (map[i][tmp] != wall  && map[i][tmp] != red) {
								if (map[i][tmp] == hole) {
									return 2; // 구멍에 파란 공이 들어갔음.
								}
								map[i][tmp + 1] = empty;
								map[i][tmp--] = blue;
							} else
								break;
						}
					}
				}
			}
		} else if (d == R) {
			for (int i = 1; i < N-1; ++i) {
				for (int j = M - 1; j >= 1; --j) {
					if (map[i][j] == red) { // 빨간공이면
						int tmp = j;
						while (true) {
							if (map[i][tmp] != wall && map[i][tmp] != blue) {
								if (map[i][tmp] == hole) {
									return 1; // 구멍에 빨간 공이 들어갔음.
								}
								map[i][tmp - 1] = empty;
								map[i][tmp++] = red;
							} else
								break;
						}
					} else if(map[i][j]==blue) {
						int tmp = j;
						while (true) {
							if (map[i][tmp] != wall && map[i][tmp] != red) {
								if (map[i][tmp] == hole) {
									return 2; // 구멍에 파란 공이 들어갔음.
								}
								map[i][tmp - 1] = empty;
								map[i][tmp++] = blue;
							} else
								break;
						}
					}
				}
			}
		} else if (d == U) {
			for (int j = 1; j < M-1; ++j) {
				for (int i = 1; i < N-1; ++i) {
					if (map[i][j] == red) {
						int tmp = i;
						while (true) {
							if ( map[tmp][j] != wall && map[tmp][j] != blue) {
								if (map[tmp][j] == hole) {
									return 1; // 구멍에 빨간 공이 들어갔음.
								}
								map[tmp + 1][j] = empty;
								map[tmp--][j] = red;
							} else
								break;
						}
					} else if(map[i][j]==blue){
						int tmp = i;
						while (true) {
							if (map[tmp][j] != wall && map[tmp][j] != red) {
								if (map[tmp][j] == hole) {
									return 2; // 구멍에 파란 공이 들어갔음.
								}
								map[tmp + 1][j] = empty;
								map[tmp--][j] = blue;
							} else
								break;
						}
					}
				}
			}
		} else if (d == D) {
			for (int j = 1; j < M-1; ++j) {
				for (int i = N - 1; i >= 1; --i) {
					if (map[i][j] == red) {
						int tmp = i;
						while (true) {
							if (map[tmp][j] != wall && map[tmp][j]!= blue) {
								if (map[tmp][j] == hole) {
									return 1; // 구멍에 빨간 공이 들어갔음.
								}
								map[tmp - 1][j] = empty;
								map[tmp++][j] = red;
							} else
								break;
						}
					} else if(map[i][j]==blue){
						int tmp = i;
						while (true) {
							if (map[tmp][j] != wall && map[tmp][j] != red) {
								if (map[tmp][j] == hole) {
									return 2; // 구멍에 파란 공이 들어갔음.
								}
								map[tmp - 1][j] = empty;
								map[tmp++][j] = blue;
							} else
								break;
						}
					}
				}
			}
		}
		return 0; // 이동 완료
	}

	static int[][] copy(int[][] from) {
		int[][] answer = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				answer[i][j] = from[i][j];
			}
		}
		return answer;
	}

	static class Ball {
		int x, y;

		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Node {
		int[][] nowMap = new int[N][M];
		int cnt;

		public Node( int[][] nowMap, int cnt) {
			this.cnt = cnt;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					this.nowMap[i][j] = nowMap[i][j];
				}
			}
		}
	}
}
