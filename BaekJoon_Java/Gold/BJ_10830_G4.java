package gold;

import java.io.*;
import java.util.*;

public class BJ_10830_G4 {

	static int[][] answer, original;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		original = new int[A][A];// ���� �迭
		for (int i = 0; i < A; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < A; ++j) {
				original[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		// B������ŭ
		answer = multiply(original,B);
		// ���
		for (int i = 0; i < A; ++i) {
			for (int j = 0; j < A; ++j) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] multiply(int[][] now, long B) {
		// 1������ �Ǹ� ��ȯ
		if (B == 1L) {
			return now;
		}
		// ���ϴ� ��Ŀ��� �������� �����´�.
		int[][] tmp = multiply(now, B / 2);
		tmp = mul(tmp, tmp);
		// ������ Ȧ���̸� �� ���� �����ش�.
		if(B%2==1L) {
			tmp = mul(tmp, original);
		}
		
		return tmp;
	}

	static int[][] mul(int[][] X, int[][] Y) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				for (int k = 0; k < N; ++k) {
					tmp[i][j] += X[i][k] * Y[k][j];
					tmp[i][j] %= 1000;
				}
			}
		}
		return tmp;
	}
}
