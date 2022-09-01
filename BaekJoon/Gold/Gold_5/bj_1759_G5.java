package bj.gold;

import java.io.*;
import java.util.*;

public class bj_1759_G5 {
	static int N, R;
	static String[] input;
	static int[] out;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		input = new String[N];
		out = new int[R];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			input[i] = st.nextToken();
		Arrays.sort(input);
		Combination(0, 0, 0, 0, 0);
	}

	static void Combination(int start, int idx, int cnt, int ja, int mo) {
		if (cnt == R) {
			if (ja >= 2 && mo >= 1) {
				for (int i = 0; i < R; ++i)
					System.out.print(input[out[i]]);
				System.out.println();
			}
			return;
		}

		for (int i = start; i < N; ++i) {
			out[idx] = i;
			Combination(i + 1, idx + 1, cnt + 1, 
					ja + (!moCheck(input[out[idx]]) ? 1 : 0),
					mo + (moCheck(input[out[idx]]) ? 1 : mo));
		}
	}

	static boolean moCheck(String st) {
		if (st.equals("a")|| st.equals("e") || st.equals("i") ||st.equals("o") || st.equals("u"))
			return true;
		else
			return false;
	}
}
