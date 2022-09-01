package bronze;

import java.io.*;
import java.util.*;

public class bj_2358_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hashX = new HashMap<>();
		HashMap<String, Integer> hashY = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String val = st.nextToken();
			hashX.put(val, hashX.getOrDefault(val, 0) + 1);
			val = st.nextToken();
			hashY.put(val, hashY.getOrDefault(val, 0) + 1);
		}
		int sum = 0;
		for(String key : hashX.keySet()) {
			int val = hashX.get(key);
			if(val > 1) sum++;
		}
		for(String key : hashY.keySet()) {
			int val = hashY.get(key);
			if(val > 1) sum++;
		}
		System.out.println(sum);
	}

}
