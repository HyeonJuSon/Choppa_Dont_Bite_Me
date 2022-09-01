package com.swea.d3;

import java.io.*;
import java.util.*;

public class swea_1206_d3 {
	static int[] dx = { -1, 1, -2, 2 };
	static int[] dy = { 0, 0 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; ++tc) {
			map = new int[1004][255];
			int col = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < col; ++i) {
				int loopCnt = Integer.parseInt(st.nextToken());
				for (int j = 0; j < loopCnt; ++j) {
					map[i][j] = 1;
				}
			}
			sb.append("#").append(tc).append(" ").append(find()).append('\n');
		}
		System.out.println(sb);
	}

	static int find() {
		int cnt = 0;
		for (int i = 0; i < 1004; ++i) {
			for (int j = 0; j < 255; ++j) {
				if (map[i][j] == 0)
					continue;
				if (map[i + dx[0]][j] == 0 && 
					map[i + dx[1]][j] == 0 &&
					map[i + dx[2]][j] == 0 &&
					map[i + dx[3]][j] == 0 ) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
