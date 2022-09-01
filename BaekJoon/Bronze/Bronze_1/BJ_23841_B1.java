package bronze;

import java.io.*;
import java.util.*;

public class BJ_23841_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; ++i) {
			String now = br.readLine();
			for (int j = 0; j < M; ++j) {
				arr[i][j] = now.charAt(j);
			}
		}
		int mid = M / 2;
		int jj = M - 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < mid; ++j) {
				if (arr[i][j] != '.') {
					arr[i][jj] = arr[i][j];
				}
				--jj;
			}
			jj = M - 1;
		}
		jj = mid-1;
		for (int i = 0; i < N; ++i) {
			for (int j = mid; j < M; ++j) {
				if(arr[i][j]!='.') {
					arr[i][jj]=arr[i][j];
				}
				--jj;
			}
			jj = mid-1;
		}
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
