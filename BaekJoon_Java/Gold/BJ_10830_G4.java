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
		original = new int[A][A];// 곱할 배열
		for (int i = 0; i < A; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < A; ++j) {
				original[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		// B제곱만큼
		answer = multiply(original,B);
		// 출력
		for (int i = 0; i < A; ++i) {
			for (int j = 0; j < A; ++j) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] multiply(int[][] now, long B) {
		// 1제곱이 되면 반환
		if (B == 1L) {
			return now;
		}
		// 최하단 행렬에서 제곱값을 가져온다.
		int[][] tmp = multiply(now, B / 2);
		tmp = mul(tmp, tmp);
		// 지수가 홀수이면 한 번더 곱해준다.
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
