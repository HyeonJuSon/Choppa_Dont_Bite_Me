import java.io.*;
import java.util.*;

public class bj_21609_G2 {

	static public class Block {
		Pos pos;
		int color;

		Block(int x, int y, int color) {
			this.pos = new Pos(x, y);
			this.color = color;
		}
	}

	static public class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static public class Group {
		int blockCnt;
		int rainbowCnt;
		Pos base;

		Group() {
			this.blockCnt = 0;
			this.rainbowCnt = 0;
			this.base = new Pos(-1, -1);
		}
	}

	static int N, M, map[][], score;
	static final int black = -1, rainbow = 0, empty = -2;
	static Group bigGroupBase;
	
	static Queue<Block> bigGroup = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // ���� �� ���� ũ��
		M = Integer.parseInt(st.nextToken()); // �Ϲ� ��� ���� ��
		score = 0;
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (!findBlock()) break;
			eraseBlock();
			gravity();
			rotate();
			gravity();
			print("�߷�");
		}

		System.out.println(score);
	}


	// ���� ū ����� ã�´�.
	static boolean findBlock() {
		bigGroup = new LinkedList<>(); // ���� ū ��� �׷��� ��´�.
		bigGroupBase = new Group(); // ���� ū �׷��� ���� ����� �����Ѵ�.
		boolean[][] isVisited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (M>=map[i][j]&&map[i][j] > rainbow && !isVisited[i][j]) {
					bfs(i, j, map[i][j], isVisited);
				}
			}
		}
		return bigGroup.size() > 1; // �׷쿡 ���� ����� ������ 2�� �̻��̾����. �׸��� �ּ� �Ѱ� �̻� �Ϲ� ����̾����.
	}

	static int[][] dir = { { -1, 0, 0, 1 }, { 0, -1, 1, 0 } };

	static void bfs(int x, int y, int color, boolean[][] isVisited) {
		Queue<Block> q = new LinkedList<>();
		Queue<Block> tmp = new LinkedList<>(); // ���� ����� ������ ����� ���ϱ� ����.
		q.add(new Block(x, y, color));
		tmp.add(new Block(x, y, color));
		isVisited[x][y] = true;
		Group tmpBase = new Group(); // �ӽ� ���� ����� ���� ��ü
		tmpBase.base.x = x;
		tmpBase.base.y = y;
		tmpBase.blockCnt++;
		while (!q.isEmpty()) {
			Block now = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = now.pos.x + dir[0][d];
				int ny = now.pos.y + dir[1][d];
				if (isBoundary(nx, ny) && (map[nx][ny] == color || map[nx][ny] == rainbow) && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true;
					q.add(new Block(nx, ny, map[nx][ny]));
					tmp.add(new Block(nx, ny, map[nx][ny]));
					// ���� ��� ����
					if (map[nx][ny] != rainbow) { // ���������� ������ �� �� ����
						// ���� �� ũ�ų� // ���� ������ ���� ��ũ�ų�
						if (tmpBase.base.x > nx || (tmpBase.base.x == nx && tmpBase.base.y > ny)) {
							tmpBase.base.x = nx;
							tmpBase.base.y = ny;
						}
						tmpBase.blockCnt++;
					} else {
						// ������ ��� �� ī��Ʈ
						tmpBase.rainbowCnt++;
					}
				}
			}
		}
		boolean isChange = false;
		if (tmp.size() > 1 && tmpBase.blockCnt >=1) { // �׷쿡�� �ּ� 1���̻��� �Ϲ� ����� �־���Ѵ�.
			// �׷��� �� ũ��
			if (bigGroup.size() < tmp.size()) {
				isChange = true;
			} else if (bigGroup.size() == tmp.size()) {
				// �׷� ������ ���v��
				// ������ ��� ���� ū ��
				if(bigGroupBase.rainbowCnt < tmpBase.rainbowCnt) {
					isChange = true;
				}else if(bigGroupBase.rainbowCnt == tmpBase.rainbowCnt) {
					if(bigGroupBase.base.x < tmpBase.base.x) {
						isChange = true;
					}else if(bigGroupBase.base.x == tmpBase.base.x && bigGroupBase.base.y < tmpBase.base.y) {
						isChange = true;
					}
				}
			}
		}
		
		if(isChange) {
			bigGroup.clear();
			while(!tmp.isEmpty()) {
				Block now = tmp.poll();
				if(now.color==rainbow) {
					isVisited[now.pos.x][now.pos.y]=false;
				}
				bigGroup.add(now);
			}
			bigGroupBase.base.x = tmpBase.base.x;
			bigGroupBase.base.y = tmpBase.base.y;
			bigGroupBase.blockCnt = tmpBase.blockCnt;
			bigGroupBase.rainbowCnt =  tmpBase.rainbowCnt;
		}else {
			while(!tmp.isEmpty()) {
				Block now = tmp.poll();
				if(now.color==rainbow) {
					isVisited[now.pos.x][now.pos.y]=false;
				}
			}
		}
	}

	static boolean isBoundary(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	static void eraseBlock() {
		score += bigGroup.size() * bigGroup.size();
		while(!bigGroup.isEmpty()) {
			Block now = bigGroup.poll();
			map[now.pos.x][now.pos.y] = empty;
		}
	}

	// �߷�
	static void gravity() {
		for (int j = 0; j < N; ++j) {
			int cnt = 0;
			for (int i = N - 1; i >= 0; --i) {
				if (map[i][j] == empty) {
					++cnt;
				} else {
					if (map[i][j] != black && cnt > 0) {
						map[i + cnt][j] = map[i][j];
						map[i][j] = empty;
						i = i + cnt;
						cnt = 0;
					}else { // �������� ���
						
						cnt = 0;
					}
				}
			}
		}
	}

	// 90�� �ݽð� ����
	static void rotate() {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; ++i) {
			int x = 0;
			for (int j = N - 1; j >= 0; --j) {
				tmp[x++][i] = map[i][j];
			}
		}
		map = tmp;
	}

	// print
	static void print(String header) {
		System.out.println(header);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(map[i][j]==-2) System.out.print("  ��");
				else System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}
	}
}
