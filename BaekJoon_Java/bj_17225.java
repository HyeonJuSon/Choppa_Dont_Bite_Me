package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_17225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 상민초, 지수초, 손님수, 구매시간, 구매색상, 선물개수
		int A, B, N, time, color, cnt;
		// 상민이 일, 지수 일 리스트
		LinkedList<int[]> workA = new LinkedList<>();
		LinkedList<int[]> workB = new LinkedList<>();
		// 선물 큐 
		LinkedList<Integer> presents = new LinkedList<>();
		
		// A,B,N입력
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		// 손님 수 만큼 입력을 반복
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; ++i) {
			time = Integer.parseInt(st.nextToken());
			color = st.nextToken() == "B" ? 1 : 2;
			cnt = Integer.parseInt(st.nextToken());
			
		}
	}

}
