package com.algo.d2;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
	public double sum;
	public int index;

	public Pair() {

	}

	public Pair(double sum, int index) {
		this.sum = sum;
		this.index = index;
	}

	@Override
	public int compareTo(Pair o) {
		return Double.compare(o.sum, this.sum);
	}
}

public class swea_1983 {
	static String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1983.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Int(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			LinkedList<Pair> student = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			int N = Int(st.nextToken());
			int K = Int(st.nextToken());
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int mid = Int(st.nextToken());
				int fnl = Int(st.nextToken());
				int hw = Int(st.nextToken());
				double sum = (mid * 0.35d) + (fnl * 0.45d) + (hw * 0.2d);
				student.offer(new Pair(sum, i + 1));
			}
			Collections.sort(student);
			int ratio =N/10;
			int index =0;
			boolean isFlag = false;
			while(!isFlag) {
				
				for(int i=0; i<ratio; ++i) {
					if(student.peek().index == K) {
						System.out.println("#"+tc+" "+grade[index]);
						isFlag = true;
						break;
					}
					student.poll();
				}
				index++;
			}
		}
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}

}
