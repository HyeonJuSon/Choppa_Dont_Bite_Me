package com.algo.d2;

import java.io.*;
import java.util.*;

public class swea_1974_d2 {
	static int[][] sdoku; // ������ ���� ���� �迭
	static final int N = 9; // �������� ����
	static final int total = 45; // 1~9 ���ϸ� 45
	static final int[] di = {-1,-1,-1,0,0,0,1,1,1}; // 8��
	static final int[] dj = {-1, 0,1,-1,0,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Int(br.readLine()); // �׽�Ʈ ���̽� ���� �Է¹޴´�.
		for (int tc = 1; tc <= T; ++tc) { // �׽�Ʈ ���̽� �� ��ŭ �ݺ��Ѵ�.
			sdoku = new int[N][N]; // ������ �迭 �Ҵ�
			int col_sum = 0; // ���� ��(�󿡼� �Ϸ� �������� ���鼭 �˻�)
			int row_sum = 0; // ���� ��(�¿��� ��� �������鼭 �˻�)
			int map_sum = 0; // �� ����� ��
			boolean isError = false; // ����� �Ǿ��ִ��� ���� �˻�
			for (int x = 0; x < N; ++x) { // 9*9 ������ ���� �Է¹޴´�.
				sdoku[x] = new int[N]; // �� �ະ �Ҵ�
				st = new StringTokenizer(br.readLine(), " "); // ��ū �Է�
				for (int y = 0; y < N; ++y) {
					sdoku[x][y] = Int(st.nextToken());
					row_sum += sdoku[x][y]; // �� �˻縦 ���� ��
				}
				if (row_sum != total) { // ���ٴ� ���� �ȳ����� �߸��� ��.
					isError = true;
				}
				row_sum = 0;
			}
		
			// �� �˻絵 �߰��� �ؾ� �Ѵ�.
			if (!isError) {
				for (int y = 0; y < N; ++y) {
					for (int x = 0; x < N; ++x) {
						col_sum += sdoku[x][y];
					}
					if (col_sum != total) {
						isError = true;
						break;
					}
					col_sum = 0;
				}
			}
			
			if(!isError) {
				for(int m=1; m<N; m=m+3) {
					for(int n=1; n<N; n=n+3) {
						map_sum =0;
						for(int d= 0; d<9;d++) {
							int ni = m+di[d];
							int nj = m+dj[d];
							map_sum += sdoku[ni][nj];
						}
						if(map_sum != total) {
							isError=true;
							break;
						}
						
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(isError ? "0" : "1").append('\n');
		}
		System.out.println(sb);
	}

	// Int�� ��ȯ���ش�
	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
