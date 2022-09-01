package com.swea.d5;

import java.io.*;
import java.util.*;

public class swea_d5_1247 { // 치킨집 문제랑 유사한듯.
	static ArrayList<int[]> myList = new ArrayList<>();
	static ArrayList<int[]> customers = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Int(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Int(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			myList.add(new int[]{Int(st.nextToken()),Int(st.nextToken())}); //company
			myList.add(new int[]{Int(st.nextToken()),Int(st.nextToken())}); //home
			for (int i = 0; i < N; ++i) {
				customers.add(new int[] {Int(st.nextToken()), Int(st.nextToken())});
			}
			
			System.out.println();
			search();
		}
	}

	static void search() {
		
		for(int[] me : myList) {
			int min = Integer.MAX_VALUE;
			for(int[] cus : customers) {
				int dist = Math.abs(me[0]-cus[0]) + Math.abs(me[1]-cus[1]);
				min = Math.min(min, dist);
			}
		}
	}
	
	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
