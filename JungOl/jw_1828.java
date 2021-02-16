package com.algo;

import java.util.*;

/*
 * [ 아이디어 ] 최고 온도 기준으로 오름차순으로 정렬한 뒤 비교한다.
 * 	1) i의 최고온도가 i+1의 최저온도보다 크면 겹친다. -> 냉장고가 추가로 필요하지 않다. 
 * 	2) i의 최고온도가  i+1의 최저온도보다 작으면 겹치지 않는다. -> 냉장고가 추가로 필요하다.
 */
class Pair implements Comparable<Pair>{
	public int low;
	public int high;
	public Pair() {}
	public Pair(int low, int high) {
		this.low=low;
		this.high=high;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.high, o.high);
	}
}
public class Main_jw_1828_냉장고_구미_4_손현주 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Pair> list = new LinkedList<>();
		int cnt = 1;
		for (int i = 0; i < N; ++i) {
			list.offer(new Pair(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list);
		int high = list.poll().high;
		while(!list.isEmpty()) {
			if(high < list.peek().low) {
				cnt++;
				high = list.poll().high;
			}else {
				list.poll();
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
