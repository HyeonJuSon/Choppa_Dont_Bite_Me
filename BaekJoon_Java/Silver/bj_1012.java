package BJ;
import java.io.*;
import java.util.*;
public class bj_1012 {
	static int M, N, K, Cnt; 						// M - ����, N - ����, K - ������ ����, ������ ����
	static int[][] ground; 							// ���� ��.
	static int[] dx = { -1, 1, 0, 0 }; 				// �� ����
	static int[] dy = { 0, 0, -1, 1 }; 				// �� ����
	static boolean isFirst;							// ī���� �÷���
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); 	// ���� �Է�
		for (int tc = 1; tc <= T; ++tc) { 			// ���ɼ� ��ŭ �ݺ�
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); 	// M - ����
			N = Integer.parseInt(st.nextToken()); 	// N - ����
			K = Integer.parseInt(st.nextToken());	// K - ���� ����
			ground = new int[M][N]; 				// ���� �� �Ҵ�
			Cnt = 0;								// ī��Ʈ �ʱ�ȭ
			for (int i = 0; i < K; ++i) { 			// ���� ���� ��ŭ �ݺ�
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = 1; 					// ���� ��ġ �ʱ�ȭ
			}
			for (int i = 0; i < M; ++i) {			// 0,0 ���� Ž�� ���� -> �湮 üũ
				for (int j = 0; j < N; ++j) {
					isFirst = true;					// ī���� �÷��� �ʱ�ȭ
					search(i, j);					// Ž�� ȣ��
				}
			}
			System.out.println(Cnt);				// ���
		}
	}

	static boolean isAvailable(int x, int y) {		// ������ ���� ������ �˻�
		if (x < 0 || x >= M || y < 0 || y >= N) return false;
		if (ground[x][y] != 1) return false;
		return true;
	}

	static void search(int x, int y) {
		if (ground[x][y] != 1) return; 				// ���߰� �ƴ϶�� ����(0 �ƴϸ� -1�� �� ����)
		else {
			ground[x][y] = -1; 						// �湮 üũ�� ����
			if (isFirst) {							// ���� �� �׷�� ī���� ���ַ��� �÷��� ���
				Cnt++;
				isFirst = false;
			}
			for (int d = 0; d < 4; ++d) {			// 4���� Ž���� ����
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (isAvailable(nx, ny)) {			// �̵� �Ϸ��� ���� �̵� �����ϸ� 
					search(nx, ny); 				// ��Ž��
				}
			}
		}
	}
}
