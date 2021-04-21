package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_93 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[24];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; ++i)	arr[Integer.parseInt(st.nextToken())]++;
		for (int i = 1; i <= 23; ++i) System.out.print(arr[i]+" ");
	}

}
