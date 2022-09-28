import java.io.*;
import java.util.*;

public class BJ_14003_P5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> binary = new ArrayList<>();
		int[] arr = new int[N + 1]; // elements
		int[] idx = new int[N + 1]; // index of elements
		for (int i = 1; i <= N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		binary.add(Integer.MIN_VALUE);

		for (int i = 1; i <= N; ++i) {
			int val = arr[i];
			int L = 1;
			int R = binary.size() - 1;

			// if val is bigger than last, add it
			if (val > binary.get(binary.size() - 1)) {
				binary.add(val);
				idx[i] = binary.size() - 1;
			} else {
				while (L < R) {
					int M = (L + R) >> 1;
					if (binary.get(M) >= val)
						R = M;
					else
						L = M + 1;
				}
				binary.set(R, val);
				idx[i] = R;
			}
		}
		// print longest length
		System.out.println(binary.size() - 1);

		Stack<Integer> trace = new Stack<>();
		int target = binary.size() - 1;

		for (int i = N; i > 0; --i) {
			if(idx[i] == target) {
				--target;
				trace.push(arr[i]);
			}
		}
		
		while(!trace.isEmpty()) {
			System.out.print(trace.pop()+" ");
		}
		System.out.println();
	}

}
