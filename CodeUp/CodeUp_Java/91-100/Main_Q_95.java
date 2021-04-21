package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_95 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) min = Math.min(min, Integer.parseInt(st.nextToken()));
		System.out.println(min);
	}
}
