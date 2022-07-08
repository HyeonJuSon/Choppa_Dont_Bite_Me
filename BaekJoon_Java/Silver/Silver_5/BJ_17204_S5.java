package silver;

import java.io.*;
import java.util.*;

public class BJ_17204_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0;i<N;++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		int idx = 0;// 0번부터시작
		while(true) {
			++cnt;
			int val = arr[idx];
			if(val == K) break;
			idx= val;
			if(cnt > N) break;
		}
		System.out.println(cnt > N ? -1 : cnt);
	}

}
