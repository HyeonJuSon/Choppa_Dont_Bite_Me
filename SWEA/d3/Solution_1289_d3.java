package com.algo;

import java.io.*;
import java.util.*;

public class Solution_1289_원재의메모리복구하기_구미_4_손현주 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String s= br.readLine();
			int[] a = new int[s.length()];
			for(int i=0; i<s.length();i++) {
				a[i] = s.charAt(i)-'0';
			}
			int cnt = a[0];
			
			for(int i=1;i<a.length;i++) {
				if(a[i] != a[i-1]) cnt++;
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
//		Scanner sc = new Scanner(System.in);
//		
//		int T = sc.nextInt();
//		
//		for(int tc=1; tc<=T; tc++) {
//			String s = sc.next();
//			int[] a = new int [s.length()];
//			for(int i=0; i<s.length();i++) {
//				a[i] = s.charAt(i)-'0';
//			}
//			int cnt = a[0];
//			
//			for(int i=1; i<a.length; i++) {
//				if(a[i] != a[i-1]) cnt++;
//			}
//			
//			System.out.println("#"+tc+ " "+cnt);
//		}
//		
//		sc.close();
	}

}
