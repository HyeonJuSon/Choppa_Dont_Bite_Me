package com.algo;

import java.io.*;
import java.util.*;

public class Solution_5215_햄버거다이어트 {
	static int N, L, max;
    static int[][] comb;
 
    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("res/Input_d3_5215.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());    // 재료 수
            L = Integer.parseInt(st.nextToken());    // 제한 칼로리
 
            comb = new int[N][2];
 
            // 재료 정보
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                comb[i][0] = Integer.parseInt(st.nextToken()); // 맛 점수
                comb[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
            }
 
            max = 0;
            search(0, 0, 0); // 부분 집합으로
 
            System.out.println("#" + tc + " " + max);
        }
    }
 
    public static void search(int idx, int taste, int cal) {
        // 칼로리 초과
        if (cal > L) return;
        // 주어진 제한 칼로리 이하의 조합
        if (cal <= L) max = Math.max(max, taste);
        // 모두 조합을 확인
        if (idx == N) return;
        
        // 선택
        search(idx + 1, taste + comb[idx][0], cal + comb[idx][1]);
        // 비선택
        search(idx + 1, taste, cal);
    }
    
    static int Int(String s) {
    	return Integer.parseInt(s);
    }
}
