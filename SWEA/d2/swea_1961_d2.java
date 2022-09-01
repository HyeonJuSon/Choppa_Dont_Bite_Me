package com.algo.d2;

import java.io.*;
import java.util.*;

public class Solution_1961_d2 {

	static int[][] base; 	// ���� �迭
	static int[][] after; 	// �ӽ� �迭
	static String[][] show;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		// 1. �Է�
		int T = Int(br.readLine()); 		// �׽�Ʈ ���̽��� ��
		for (int tc = 1; tc <= T; ++tc) { 	// �׽�Ʈ ���̽��� �ݺ�
			N = Int(br.readLine()); 		// �迭�� ������ N
			base = new int[N][N]; 			// ���� �迭
			after = new int[N][N];			// �ӽ� �迭
			show = new String[N][3]; 		// 90/180/270�� ��� �迭
			// 2. �迭 �� ���� ����
			for (int i = 0; i < N; ++i) {
				base[i] = new int[N]; 		// �ʱ�ȭ - 2���� �迭�̶� ���ϸ� �ȵȴ�.
				show[i] = new String[3];	// �ʱ�ȭ
				st = new StringTokenizer(br.readLine(), " "); // ��ū ����
				for (int j = 0; j < N; ++j) {
					base[i][j] = Int(st.nextToken()); // �迭 �� ����
				}
			}
			// 3. �迭 90, 180, 270 ����
			int y = 0; 				// ���� �迭�� �ε���
			boolean isFirst= true;			// ó���ƴ϶�� �迭�� �������ִ� �÷���
			for (int cnt = 0; cnt < 3; cnt++) {
				if(!isFirst) afterCopy();	// �ٲ� �迭�� ����
				for (int j = 0; j < N; ++j) {
					String tmp = "";
					y=0;
					for (int i = N - 1; i >= 0; --i) {
						if(isFirst) isFirst = false;
						int val = base[i][j];
						after[j][y++] = val;
						tmp += val;
					}
					show[j][cnt] = tmp;
				}
			}
			sb.append("#").append(tc).append('\n');
			setShow();
		}
		System.out.println(sb);
	}
	// show �迭 ���� �޼ҵ�
	static void setShow() {
		for(int i=0;i<N; ++i) {
			for(int j=0; j<3; ++j) {
				sb.append(show[i][j]).append(" ");
			}
			sb.append('\n');
		}
	}
	// �迭 ī�� �޼ҵ�
	static void afterCopy() {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				base[i][j]=after[i][j];
			}
		}
	}
	// Int������ �Ľ� �� ��ȯ �޼ҵ�
	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
