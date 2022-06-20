package bronze;

import java.util.*;

public class bj_2161_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		// 버리는 카드들을 순서대로 출력 하고 제일 마지막 카드를 출력한다.
		ArrayDeque<Integer> cards = new ArrayDeque<>();
		// 1~N까지 1이왼쪽
		for(int i=1;i<=N;++i) {
			cards.addLast(i); //1.2.3.4...N
		}
		while(cards.size()>1) {
			System.out.print(cards.pollFirst()+" ");//맨위를 제거 후 출력
			cards.addLast(cards.pollFirst()); // 맨 윗장을 맨 아래로.
		}
		System.out.print(cards.poll());
	}

}
