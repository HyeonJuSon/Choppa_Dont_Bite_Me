package com.algo;

import java.io.*;

public class Solution_3499_퍼펙트셔플_구미_4_손현주 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d3_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			br.readLine();
			String[] tmp = br.readLine().split(" ");
			int len = tmp.length/2;
			int x=0, ex, y, ey=tmp.length;
			if(tmp.length%2==0) {
				ex=len;
				y=len;
			}else {
				ex=len+1;
				y=len+1;
			}
			sb.append("#").append(tc).append(" ");
			while (true) {
				if (x < ex) sb.append(tmp[x++]).append(" ");
				if (y < ey) sb.append(tmp[y++]).append(" ");
				if(x>=ex && y>=ey) break;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
