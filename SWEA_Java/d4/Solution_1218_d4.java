package com.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_4일차괄호짝짓기_구미_4_손현주 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d4_4일차괄호짝짓기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; ++i) {
			int length = Integer.parseInt(br.readLine());
			String val = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int k = 0; k < length; ++k) {
				char check = val.charAt(k);
				if (check == '(') {
					stack.push(')');
				} else if (check == '[') {
					stack.push(']');
				} else if (check == '{') {
					stack.push('}');
				} else if (check == '<') {
					stack.push('>');
				} else if (check == ')') {
					if(stack.peek()==')') {
						stack.pop();
					}else {
						System.out.println("#"+(i+1)+" 0");
						break;
					}
				} else if (check == ']') {
					if(stack.peek()==']') {
						stack.pop();
					}else {
						System.out.println("#"+(i+1)+" 0");
						break;
					}
				} else if (check == '}') {
					if(stack.peek()=='}') {
						stack.pop();
					}else {
						System.out.println("#"+(i+1)+" 0");
						break;
					}
				} else if (check == '>') {
					if(stack.peek()=='>') {
						stack.pop();
					}else {
						System.out.println("#"+(i+1)+" 0");
						break;
					}
				}
			}
			if(stack.isEmpty()) System.out.println("#"+(i+1)+" 1");
		}
	}

}
