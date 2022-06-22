package silver;

import java.io.*;
import java.util.*;

public class bj_14888_S1 {

	static int N, arr[], min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] oper = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; ++i) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int cnt,int sum) {
		if (cnt == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; ++i) {
			if (oper[i]>0) {
				--oper[i];
				switch(i) {
				case 0: dfs(cnt+1, sum+arr[cnt]); break;
				case 1: dfs(cnt+1, sum-arr[cnt]); break;
				case 2: dfs(cnt+1, sum*arr[cnt]); break;
				case 3: dfs(cnt+1, sum/arr[cnt]); break;
				}
				++oper[i];
			}
		}
	}

}
