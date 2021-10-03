package silver;

import java.io.*;
import java.util.*;

public class bj_1789_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long S = Long.parseLong(br.readLine());
		long sum = 0, val = 0, N = 0;
		while (S >= sum) sum += ++val;
		System.out.println(sum == N ? val : val - 1);
	}

}
