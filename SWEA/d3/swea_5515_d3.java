package com.swea.d3;

import java.io.*;
import java.util.*;

public class swea_5515_d3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int mon = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			for (int i = 1; i < mon; ++i) {
				switch (i) {
				case 4:	case 6: case 9: case 11:
					day += 30;
					break;
				case 2:
					day += 29;
					break;
				default:
					day += 31;
					break;
				}
			}
			System.out.println("#"+tc+ " "+(day-1+4) % 7);
		}
	}
}
