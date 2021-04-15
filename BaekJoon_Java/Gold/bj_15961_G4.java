package com.sweaTestQuestion;

import java.io.*;
import java.util.*;

public class bj_15961_G4 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N];
		for(int i=0;i<N;++i) sushi[i] = Integer.parseInt(br.readLine());
		System.out.println(max(sushi,D,K,C));
	}
	static int max(int[] sushi, int D, int K, int C) {
		int[] check = new int[D+1];								// 이미 뽑혔는지 체크
		int cnt =1;												// cnt변수C를넣어놔서1부터시작
		check[C]++;												// 미리 넣어둔다.
		for(int i=0;i<K; ++i) if(check[sushi[i]]++ == 0) cnt++;	// 처음4자리를넣는다
		int max = cnt;											// 반환할 변수
		for(int i=0;i<sushi.length;++i) {
			if(check[sushi[(i+K)%sushi.length]]++ == 0) cnt++;	// 안뽑혔던상태면 카운팅
			if(--check[sushi[i]]==0)cnt--;						// 뺐는데 0이면 카운트빼준다.
			max=Math.max(max, cnt);								// 최대값갱신
		}
		return max;
	}
}
