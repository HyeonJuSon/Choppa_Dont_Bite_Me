package bronze;

import java.io.*;
import java.util.*;

public class bj_1977_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> value = new HashSet<Integer>();
		for (int i = 1; i <= 10000; ++i) {
			value.add(i * i);
		}
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i <= N; ++i) {
			if (value.contains(i)) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		if (sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
