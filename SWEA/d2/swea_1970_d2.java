package com.algo.d2;

import java.io.*;
import java.util.*;

public class Solution_1970_d2 {
	static int Money;
	static int[] cnt;
	static final int[] type = new int[] {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = stoi(st.nextToken());
		for (int tc = 1; tc <= T; ++tc) {
			cnt = new int[8];
			st = new StringTokenizer(br.readLine()," ");
			Money = stoi(st.nextToken());
			for(int i=0;i<8;++i) calc(type[i],i);
			System.out.println("#"+tc+" ");
			for(int i=0;i<8;++i) {
				System.out.print(cnt[i]+" ");
			}
			System.out.println();
		}
	}
	static void calc(int range, int index) {
		if(Money >= range) {
			cnt[index] = Money / range;
			Money %= range;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
