package bj;

import java.util.*;

public class bj_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1~N의 수, N번 반복
		int K = sc.nextInt(); // K 번째 수를 제거
		Queue<Integer> q = new LinkedList<Integer>(); // 큐 선언
		for (int i = 1; i <= N; ++i)
			q.offer(i); // 1~N까지 수를 대입
		System.out.print('<');
		while (!q.isEmpty()) {
			// 반복해주고
			for (int i = 0; i < K-1; i++) {
				int tmp = q.poll();
				q.offer(tmp);
			}
			// 값 출력
			if(q.size()!=1)
				System.out.print(q.poll()+", ");
			else
				System.out.print(q.poll());
		}
		System.out.println('>');
	}

}
