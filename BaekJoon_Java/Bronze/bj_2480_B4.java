package bronze;

import java.io.*;
import java.util.*;

public class bj_2480_B4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < 3; ++i) {
			int val = Integer.parseInt(st.nextToken());
			hm.put(val, hm.getOrDefault(val, 0) + 1);
		}
		int max = 0;
		for (Integer key : hm.keySet()) {
			int val = hm.get(key);
			if (val == 3)
				System.out.println(10000 + key * 1000);
			else if (val == 2) {
				System.out.println(1000 + key * 100);
				max = 0;
				break;
			}
			else
				max = Math.max(max, key);
		}
		if (max != 0) {
			System.out.println(max * 100);
		}
	}

}
