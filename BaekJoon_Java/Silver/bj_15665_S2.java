package bj.silver;

import java.io.*;
import java.util.*;

public class bj_15665_S2 {
	static int N, M;
	static int[] input;
	static LinkedHashSet<String> output = new LinkedHashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) input[i] =Integer.parseInt(st.nextToken());
		Arrays.sort(input);// 오름차순으로해야해서.
		permutation(0,"");
		for(String t : output) sb.append(t.substring(0,t.length()-1)).append('\n');
		System.out.println(sb);
	}

	static void permutation(int cnt,String s) {
		if (cnt == M) {
			output.add(s);
			return;
		}

		for (int i = 0; i < N; ++i) permutation(cnt + 1,s+input[i]+" ");
	}
	
}
