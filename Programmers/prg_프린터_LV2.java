import java.io.*;
import java.util.*;

public class prg_프린터 {

	static class Pair implements Comparable<Pair> { // pair 클래스 생성
		int priority, index;// 중요도와 대기 순번

		Pair(int priority, int index) {
			this.priority = priority;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.priority == o.priority) {// 중요도가 동일하면
				return Integer.compare(this.index, o.index);// 대기목록 순위 기준 오름차순
			}
			return Integer.compare(o.priority, this.priority); // 중요도 내림차순
		}
	}

	static public int solution(int[] priorities, int location) {
		Queue<Pair> readyQueue = new LinkedList<>(); // 인쇄 대기목록
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());// 우선순위 순 정렬
		for (int i = 0; i < priorities.length; ++i) {
			readyQueue.offer(new Pair(priorities[i], i));// 대기목록생성
			priorityQueue.offer(priorities[i]);// 우선순위 큐
		}

		int answer = 0;
		while (true) {
			if (readyQueue.peek().priority == priorityQueue.peek()) { // 나랑 같은 우선순위면
				++answer;// 카운팅
				priorityQueue.poll();// 일단 하나뽑아주고
				if (readyQueue.peek().index == location) break; // 찾는 인덱스라면 그만하고 아니면 계속 ㄱㄱ
			}
			else // 우선순위가 다르면 
				readyQueue.offer(new Pair(readyQueue.peek().priority, readyQueue.peek().index));//맨뒤로 추가
			readyQueue.poll();//내차례 끝났으니까 뽑아준다.
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
	}
}
