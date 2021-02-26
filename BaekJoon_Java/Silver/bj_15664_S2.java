package bj.silver;

import java.io.*;
import java.util.*;

public class bj_15664_S2 {
	static int N, M;
	static int[] input;
	static boolean[] isSelected;
	static LinkedHashSet<String> output = new LinkedHashSet<>();
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) input[i] =Integer.parseInt(st.nextToken());
		Arrays.sort(input);// 오름차순으로해야해서.
		permutation(0,0,"");
		for(String t : output) sb.append(t.substring(0,t.length()-1)).append('\n');
		System.out.println(sb);
	}

	static void permutation(int start,int cnt,String s) {
		if (cnt == M) {
			output.add(s);
			return;
		}

		for (int i = start; i < N; ++i) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			permutation(i+1,cnt + 1,s+input[i]+" ");
			isSelected[i] = false;
		}
	}
	
	
}
