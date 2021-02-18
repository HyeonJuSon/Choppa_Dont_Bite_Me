package bj;
import java.io.*;
import java.util.*;
public class bj_1987 {
	static char[][] board;
	static boolean[] alphabet = new boolean[26];	// �湮 ���� ����
	static String include="";
	static int R, C;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; ++i) board[i] = br.readLine().toCharArray();
		search(0,0,0);
		System.out.println(max);
	}
	static int[] dx = {-1,1,0,0};					// �����
	static int[] dy = {0,0,-1,1};					// ������
	static void search(int cnt, int x, int y) { 	// dfs Ž��
		// �������� : ���ĺ��� ������ �Ǵ���
		if(alphabet[board[x][y]-'A']) {				// �̹� �湮�ߴ� ���ĺ��̶�� ����
			max = Math.max(max, cnt);
			return;
		}
		alphabet[board[x][y]-'A'] = true; 			// �湮 ó��
		for(int d= 0 ; d< 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];						// �湮 �����ϸ� ��Ž��
			if(isAvailable(nx,ny)) search(cnt+1,nx,ny);
		}
		alphabet[board[x][y]-'A'] = false;			// �湮 ����
	}
	static boolean isAvailable(int x, int y) {		// �湮 ���� ���� ��ȯ
		if(x<0 || x>=R || y< 0 || y>=C) return false;
		return true;
	}
}
