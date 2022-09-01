package bj;

import java.util.*;

public class bj_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1~N�� ��, N�� �ݺ�
		int K = sc.nextInt(); // K ��° ���� ����
		Queue<Integer> q = new LinkedList<Integer>(); // ť ����
		for (int i = 1; i <= N; ++i)
			q.offer(i); // 1~N���� ���� ����
		System.out.print('<');
		while (!q.isEmpty()) {
			// �ݺ����ְ�
			for (int i = 0; i < K-1; i++) {
				int tmp = q.poll();
				q.offer(tmp);
			}
			// �� ���
			if(q.size()!=1)
				System.out.print(q.poll()+", ");
			else
				System.out.print(q.poll());
		}
		System.out.println('>');
	}

}
