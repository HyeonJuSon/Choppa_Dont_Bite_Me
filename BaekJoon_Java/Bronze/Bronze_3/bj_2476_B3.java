package bronze;

import java.io.*;
import java.util.*;

public class bj_2476_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int maxWinner = 0;
		int money = 0;
		for (int i = 0; i < T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] isVisited = new int[7];
			isVisited[Integer.parseInt(st.nextToken())]++;
			isVisited[Integer.parseInt(st.nextToken())]++;
			isVisited[Integer.parseInt(st.nextToken())]++;
			boolean flag = true;
			int max = money = 0;
			for (int d = 1; d < 7; d++) {
				if (isVisited[d] >= 3) {
					money = 10000 + d * 1000;
					flag = false;
				} else if (isVisited[d] >= 2) {
					money = 1000 + d * 100;
					flag = false;
				} else if (isVisited[d] == 1) {
					max = Math.max(max, d);
				}
			}

			if (flag)
				money = max * 100;
			
			maxWinner = Math.max(maxWinner, money);
		}
		System.out.println(maxWinner);
	}

}
