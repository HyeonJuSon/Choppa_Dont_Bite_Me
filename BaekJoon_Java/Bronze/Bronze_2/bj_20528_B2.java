package bronze;

import java.io.*;
import java.util.*;

public class bj_20528_B2 {
	static int N;
	static String[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			arr[i] = st.nextToken();
		char now = arr[0].charAt(0);
		for(int i=1;i<N;++i) {
			if(now != arr[i].charAt(0)) {
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
	}

}
