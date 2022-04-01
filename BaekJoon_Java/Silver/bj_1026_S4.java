package gold;

import java.io.*;
import java.util.*;

public class bj_1026_S4 {

	static int N, answer;
	static Integer A[], B[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new Integer[N];
		B = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			B[i] = Integer.parseInt(st.nextToken());
		answer = 0;
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		for(int i=0;i<N;++i) answer += A[i]*B[i];
		System.out.println(answer);
	}

}
