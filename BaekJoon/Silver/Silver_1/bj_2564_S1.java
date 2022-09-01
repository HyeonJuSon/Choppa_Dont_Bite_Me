package bj.silver;

import java.io.*;
import java.util.*;

/*
 * 시계 방향일때
 * 1: 북 -> val
 * 2: 남 -> N*2 + M - val
 * 3: 서 -> 2(M+N) - val
 * 4: 동 -> N + val
 * 반시계 방향일 때 위치 = 2(M+N)-시계방향일때 위치
 */
public class bj_2564_S1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int houseCnt = Integer.parseInt(br.readLine());
		int[] dist = new int[houseCnt+1];
		for(int i=0;i<houseCnt+1; ++i) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			int pos = 0;
			if(dir == 1) pos = val;
			else if(dir == 2) pos = 2*N + M - val;
			else if(dir == 3) pos = 2*(N + M) - val;
			else if(dir == 4) pos = N + val;
			dist[i] = pos;
		}
		int start = dist[houseCnt];
		int sum =0;
		for(int i=0;i<houseCnt;++i) {
			int clockwise = Math.abs(start-dist[i]);
			sum += Math.min(clockwise, 2*(N+M) - clockwise);
		}
		System.out.println(sum);
	}
}
