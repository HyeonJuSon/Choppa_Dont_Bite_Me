package silver;

import java.util.*;

public class bj_2822_S5 {
	static class Score implements Comparable<Score>{
		int idx;
		int val;
		Score(int idx, int val){
			this.idx=idx;
			this.val=val;
		}
		@Override
		public int compareTo(Score o) {
			return Integer.compare(o.val, this.val);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Score> pq = new PriorityQueue<>();
		for(int i=0;i<8;++i) {
			pq.add(new Score(i+1,sc.nextInt()));
		}
		int sum = 0;
		PriorityQueue<Integer> answer = new PriorityQueue<Integer>();
		for(int i=0;i<5;++i) {
			Score now = pq.poll();
			sum += now.val;
			answer.add(now.idx);
		}
		System.out.println(sum);
		while(!answer.isEmpty()) System.out.print(answer.poll()+" ");
		
	}

}
