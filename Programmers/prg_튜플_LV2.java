package Programmers;

import java.util.*;

public class prg_튜플_LV2 {
	// 카운트 별로 정렬하기 위한 클래스
	static class Tuple implements Comparable<Tuple> {
		int value, cnt;
		Tuple(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Tuple o) {
			return Integer.compare(o.cnt, this.cnt);
		}
	}

	static public int[] solution(String s) {
		HashMap<Integer, Integer> numbers = new HashMap<>();
		String sub = s.substring(1, s.length() - 1).replaceAll(",|},", "/").replaceAll("\\{|}", "");
		String[] arr = sub.split("/"); // 배열들을 나누어준다.
		for (int i = 0; i < arr.length; ++i) {
			int now = Integer.parseInt(arr[i]);
			numbers.put(now, numbers.getOrDefault(now, 0) + 1);
		}
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		for (Integer key : numbers.keySet()) {
			pq.add(new Tuple(key, numbers.get(key)));
		}
		int[] answer = new int[pq.size()];
		int idx = 0;
		while (!pq.isEmpty()) {
			answer[idx++] = pq.poll().value;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] answer = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		for (int a : answer)
			System.out.print(a + " ");
	}

}
