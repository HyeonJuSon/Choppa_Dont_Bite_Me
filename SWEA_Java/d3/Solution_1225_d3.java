package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_7일차암호생성기_구미_4_손현주 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d3_7일차암호생성기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; ++i) {
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> q = new LinkedList<>();
			for (int x = 0; x < 8; ++x) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			int val = 0;
			boolean On = true;
			while (On) {
				for (int cycle = 1; cycle <= 5; ++cycle) {
					val = q.poll() - cycle;
					if(val > 0)
						q.offer(val);
					else {
						q.offer(0);
						On = false;
						break;
					}
				}
			}
			System.out.print("#"+T+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}

}
