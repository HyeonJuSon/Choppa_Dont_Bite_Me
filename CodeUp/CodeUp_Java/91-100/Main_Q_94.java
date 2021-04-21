package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_94 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) arr[i]=Integer.parseInt(st.nextToken());
		for (int i = N-1; i >=0; --i) System.out.print(arr[i]+" ");
	}

}
