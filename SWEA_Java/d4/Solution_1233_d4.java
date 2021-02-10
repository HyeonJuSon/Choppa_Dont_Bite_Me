package com.algo;

import java.util.*;
import java.io.*;

public class Solution_1233_사칙연산유효성검사_구미_4_손현주 {

	static int size;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_1233_d4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; ++tc) {
			size = Integer.parseInt(br.readLine());
			String[][] token = new String[size +1 ][4]; // 노드번호, V, L, R
			for (int i = 1; i <= size; ++i) { // 각 노드의 값을 저장한다.
				st = new StringTokenizer(br.readLine(), " ");
				int idx = 0;
				while (st.hasMoreElements()) {
					token[i][idx++] = st.nextToken();
				}
			}
			
			// 최 말단 부터 검색해서 올라간다. 하나라도 틀리면 그 트리는 그냥 틀린 트리다.
			boolean isError = false;
			for (int i = size  ; i > 0; --i) {
				if(token[i][2] == null) { //leaf 노드면 연산자가 들어오면 안된다.
					String tmp = token[i][1];
					switch(tmp) {
					case "+":
					case "-":
					case "*":
					case "/":
						isError=true;
						break;
					}
				}
				if(isError) break;
			}
			// 출력
			System.out.println("#"+tc+" " + (isError ? "0" : "1"));
		}
	}
}
