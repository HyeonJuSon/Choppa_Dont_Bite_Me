package com.swea.d3;

import java.util.*;
import java.io.*;

public class Solution_5607_d3 {
	static int N, R;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			System.out.printf("#%d %d", tc, Combination(N,R) % 1234567891);
		}
	}	
	// nCr = n-1Cr-1 + n-1Cr
	static int Combination(int n , int r) {
		if(n==r || r==0) return 1;
		return Combination(n-1,r-1) + Combination(n-1,r);
	}

}
