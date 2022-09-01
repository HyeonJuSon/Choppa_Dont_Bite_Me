package bronze;

import java.io.*;
import java.util.*;

public class bj_10807_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			int val=Integer.parseInt(st.nextToken());
			hm.put(val, hm.getOrDefault(val, 0)+1);
		}
		int V = Integer.parseInt(br.readLine());
		System.out.println(hm.containsKey(V) ? hm.get(V) : 0);
	}

}
