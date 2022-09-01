package gold;

import java.io.*;
import java.util.*;

public class bj_5430_G5 {

	static ArrayDeque<Integer> dq; // 덱을 이용하여 구현한다.
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {// 테케 반복 시작
			String order = br.readLine();// 명령
			int N = Integer.parseInt(br.readLine());// 배열길이
			dq = new ArrayDeque<Integer>();
			st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < N; ++i)	dq.add(Integer.parseInt(st.nextToken()));
			ordering(order);
		} // 테케 반복 끝
		System.out.println(sb.toString());
	}

	static void ordering(String order) { // 명령 처리
		int length = order.length();
		boolean isReverse = false;// 처음엔 역순 아님
		for (int i = 0; i < length; ++i) { // 명령 시작
			char now = order.charAt(i);
			if (now == 'R') isReverse = !isReverse; // R연산 -> 뒤집기 ( 토글 )
			else {//D연산 -> 삭제
				if (!isReverse && dq.pollFirst() == null) { // 정방
					sb.append("error\n");
					return;// 리턴해서 함수 탈출시킨다.
				} else if (isReverse && dq.pollLast() == null) {// 역방
					sb.append("error\n");
					return; // 리턴해서 함수 탈출시킨다.
				}
			}
		} // 명령 끝
		/* 출력 프로세스 */
		sb.append("[");
		if (dq.size() > 0) { // 사이즈 1이상
			if (!isReverse) {//정방향
				sb.append(dq.pollFirst());//미리뽑아둠 (쉼표땜에)
				while (!dq.isEmpty()) sb.append(",").append(dq.pollFirst());
			} else {//역방향
				sb.append(dq.pollLast());//미리뽑아둠(쉼표땜에)
				while (!dq.isEmpty()) sb.append(",").append(dq.pollLast());
			}
		}
		sb.append("]").append("\n");
	}

}
