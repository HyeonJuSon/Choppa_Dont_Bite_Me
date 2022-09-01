package gold;

import java.io.*;
import java.util.*;

public class BJ_12738_G2 {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		System.out.println(binarySearch(N));
	}

	static int binarySearch(int N) {
		int[] answer = new int[N + 1];
		int len = 0;
		answer[len++] = arr[0]; // ù ���Ҹ� �־��ش�.

		for (int i = 1; i < N; ++i) {
			if (answer[len - 1] < arr[i])
				answer[len++] = arr[i];// ���� ������ ũ�� ���� ��ġ�� ����
			else { // ��ġ�� ã�´�.
				int s = 0, e = len;
				while (s <= e) {
					int m = (s + e) / 2;
					int midVal = answer[m];
					if (midVal < arr[i]) {
						s = m + 1;
					} else if (midVal >= arr[i]) {
						e = m - 1;
					}
				}
				answer[s]=arr[i];
			}

		}
		
		return len;
	}
}
