import java.io.*;
import java.util.*;

public class BJ_23883_G4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] sort = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			sort[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sort);
		HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; ++i)
			d.put(arr[i], i);
		boolean isFind =false;
		for (int i = N - 1; i >= 0; --i) {
			if (sort[i] != arr[i]) {
				int[] tmp = { arr[i], sort[i] };
				int swap = arr[i];
				arr[i]=arr[d.get(sort[i])];
				arr[d.get(sort[i])] = swap;
				
				swap=d.get(tmp[0]);
				d.put(tmp[0], d.get(tmp[1]));
				d.put(tmp[1], swap);
				if(--K==0) {
					System.out.println(tmp[0]+" "+tmp[1]);
					isFind = true;
					break;
				}
			}
		}
		if(!isFind) System.out.println(-1);
	}

}
