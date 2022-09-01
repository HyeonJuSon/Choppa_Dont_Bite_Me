package com.algo;

import java.io.*;
import java.util.Stack;

public class Solution_1223_계산기2_구미_4_손현주 {
	// 우선순위 비교 
	static boolean topIsBigger(int top, int val) {
		// + : 43  *:42 이므로 top이 크면 우선순위가 낮은 것
		if(top>val) return false; 
		return true;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d4_1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 총 10개의 테케가 주어진다.
		for (int tc = 1; tc <= 10; ++tc) {
			int Length = Int(br.readLine());
			char[] expression = br.readLine().toCharArray();
			int index = 0;
			Stack<Character> operator = new Stack<Character>();
			Stack<Integer> number = new Stack<Integer>();
			String after = "";
			// 1. 후위식으로 변경한다.
			while (index < Length) {
				char tmp = expression[index++];
				// 숫자면 바로 after에 더해준다.
				if ('0' <= tmp && tmp <= '9') after += tmp;
				else {// 스택이 비어있으면 바로 넣어준다.
					if (operator.isEmpty()) operator.push(tmp);
					else {// 탑이 새로들어가는 연산자보다 우선순위가 낮으면 바로 넣어준다.
						if (!topIsBigger(operator.peek(), tmp)) operator.push(tmp);
						else {// 탑의 우선순위가 새로 들어가는 것 보다 높다면 
							while (true) {
								if (operator.isEmpty()) {
									operator.push(tmp);
									break;
								}
								if (!topIsBigger(operator.peek(), tmp)) {
									operator.push(tmp);
									break;
								}
								// 탑의 우선순위가 작아질 때 까지 빼주고, 결과에 더해준다.
								after += operator.pop();
							}
						}
					}
				}
			}
			while(!operator.isEmpty()) after += operator.pop();
			// 2. 변경이 완료되면 식을 계산한다.
			index = 0; // 시작
			int a = 0, b = 0; 
			while (index < after.length()) {
				char tmp = after.charAt(index++);
				if('0'<=tmp && tmp <='9') number.push(Int(tmp));//숫자면 바로 넣어주고 
				else {// 문자면 pop
					b = number.pop();
					a = number.pop();
					switch (tmp) {
					case '*':
						number.push(a * b);
						break;
					case '+':
						number.push(a + b);
						break;
					}
				} 
			}
			sb.append("#" + tc + " ").append(number.pop()).append(" \n");
		}
		System.out.println(sb);
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}

	static int Int(char c) {
		return  c-'0';
	}

	
}
