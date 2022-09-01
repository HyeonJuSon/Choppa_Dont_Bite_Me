package silver;

import java.io.*;
import java.util.*;

public class bj_10845_S4 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			switch (order) {
			case "push":
				int val = Integer.parseInt(st.nextToken());
				dq.add(val);
				break;
			case "pop":
				System.out.println(dq.isEmpty()?-1:dq.pop());
				break;
			case "size":
				System.out.println(dq.size());
				break;
			case "empty":
				System.out.println(dq.isEmpty()?1:0);
				break;
			case "front":
				System.out.println(dq.isEmpty()?-1:dq.peekFirst());
				break;
			case "back":
				System.out.println(dq.isEmpty()?-1:dq.peekLast());
				break;
			}
		}
	}

}
