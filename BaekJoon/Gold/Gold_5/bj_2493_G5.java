package com.hwalgo04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑_구미_4_손현주 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer[]> s = new Stack<Integer[]>();
		int n = stoi(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;++i) {
			int tmp = stoi(st.nextToken());
			while(!s.isEmpty() && s.peek()[0] < tmp) 
				s.pop();
			System.out.print(s.isEmpty() ? "0 " : s.peek()[1]+" ");
			s.push(new Integer[]{tmp,i});
		}
		
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
