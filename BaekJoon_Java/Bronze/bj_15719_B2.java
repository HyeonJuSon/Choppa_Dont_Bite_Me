package bronze;

import java.io.*;
import java.util.*;

public class bj_15719_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int M = -1;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; ++i) {
			int val = Integer.parseInt(st.nextToken());
			arr[val]++;
			if(arr[val]>=2) M=val;
		}
		System.out.println(M);
	}

}
