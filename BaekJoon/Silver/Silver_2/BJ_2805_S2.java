import java.util.*;
import java.io.*;

public class BJ_2805_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int L = 0, R = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			R = Math.max(arr[i], R);
		}

		while (L < R) {
			int H = (L + R) / 2;
			long sum = 0;
			
			for(int tree : arr) {
				if(tree-H > 0) sum += tree-H;
			}
			if(sum < M) R = H;
			else L = H+1;
		}
		
		System.out.println(L-1);
	}

}
