package SWEA;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_1204 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_1204.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 테스트케이스 수
		int T = stoi(br.readLine());
		// 테스트 케이스 수만큼 반복
		for (int tc = 1; tc <= T; ++tc) {
			// 배열
			int[] jumsu = new int[101];
			int num = stoi(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 1000; ++i) {
				jumsu[stoi(st.nextToken())]++;
			}
			int max = -1, index = -1;
			for (int i = 0; i < 101; ++i) {
				if (max < jumsu[i]) {
					max = jumsu[i];
					index = i;
				} else if (max == jumsu[i]) {
					max = i > index ? jumsu[i] : max;
					index = i > index ? i : index;
				}
			}
			sb.append("#").append(num).append(" ").append(index).append('\n');
		}
		System.out.println(sb);
	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
