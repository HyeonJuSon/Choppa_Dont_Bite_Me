package gold;

import java.io.*;
import java.util.*;

public class BJ_1826_G3 {

	static class Shop implements Comparable<Shop> {
		int pos, fuel;

		public Shop(int pos, int fuel) {
			this.pos = pos;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Shop o) {
			return Integer.compare(this.pos, o.pos);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		PriorityQueue<Shop> shops = new PriorityQueue<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int pos = Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());
			shops.add(new Shop(pos, sum));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int answer = 0;
		// 제일 연료 충전을 많이 할 수 있는 곳을 간다 = 최단거리
		PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());
		while (P<L) {
			// 방문 가능한 주유소를 입력받는다.
			while (!shops.isEmpty() && P >= shops.peek().pos) {
				tmp.add(shops.poll().fuel);
			}
			// 갈 수 있는 곳이 없다면
			if (tmp.isEmpty()) {
				answer = -1;
				break;
			}
			// 연료 충전.(= 거리)
			++answer;
			P += tmp.poll();
		}
		System.out.println(answer);
	}

}
