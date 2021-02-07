package com.algo.d2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1940_d2 {
	static final int maintain = 0;
	static final int accel = 1;
	static final int decel = 2;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1940.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int distance = 0, speed = 0;
		
		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			int sec = stoi(br.readLine());
			distance = 0;
			speed = 0;
			for (int i = 0; i < sec; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int cmd = stoi(st.nextToken());
				switch (cmd) {
				case accel:
					speed += stoi(st.nextToken());
					break;
				case decel:
					speed -= stoi(st.nextToken());
					if (speed < 0)
						speed = 0;
					break;
				}
				distance += speed;
			}
			sb.append("#" + tc + " ").append(distance).append('\n');
		}
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
