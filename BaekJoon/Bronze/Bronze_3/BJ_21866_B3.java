package bronze;

import java.io.*;
import java.util.*;

public class BJ_21866_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] max = { 100, 100, 200, 200, 300, 300, 400, 400, 500 };
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for (int i = 0; i < 9; ++i) {
			int val = Integer.parseInt(st.nextToken());
			if(val > max[i]) {
				System.out.println("hacker");
				System.exit(0);
			}
			sum+=val;
		}
		System.out.println(sum >= 100 ? "draw" : "none");
	}

}
