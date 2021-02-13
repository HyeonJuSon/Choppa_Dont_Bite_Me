package com.algo.d2;

import java.io.*;
import java.util.*;

public class swea_1859_d2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Int(br.readLine());
		for(int tc=1; tc<=T; ++tc) {
			int N = Int(br.readLine());
			int[] arr= new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N;++i) {
				arr[i] = Int(st.nextToken());
			}
			long sum=0;
			int max = arr[N-1];
			for(int i=N-2;i>=0;--i) {
				if(max > arr[i]) {
					sum += (max - arr[i]);
				}else {
					max = Math.max(max, arr[i]);
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}

	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
