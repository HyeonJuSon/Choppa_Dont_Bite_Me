package silver;

import java.io.*;
import java.util.*;

public class bj_2108_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double sum = 0.0;
		int[] arr = new int[N];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; ++i) {
			int val = Integer.parseInt(br.readLine());
			arr[i] = val;
			sum += val;
			hm.put(val, hm.getOrDefault(val, 0) + 1);
		}
		Arrays.sort(arr);
		// 산술평균
		mean(sum , N);
		// 중앙값
		median(arr, N);
		// 최빈값
		mode(hm);
		// 범위 (최대-최소)
		range(arr, N);
	}
	
	static void mean(double sum, int N) {
		System.out.println(Math.round(sum/N));
	}
	static void median(int[] arr, int N) {
		System.out.println(arr.length%2==0? arr[N/2-1]: arr[N / 2]);
	}
	static void mode(HashMap<Integer, Integer> hm) {
		List<Integer> keySetList = new ArrayList<Integer>(hm.keySet());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Collections.sort(keySetList, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));
		int cnt = hm.get(keySetList.get(0));
		pq.add(keySetList.get(0));
		for (int i = 1; i < keySetList.size(); ++i) {
			if (cnt == hm.get(keySetList.get(i))) {
				pq.add(keySetList.get(i));
			}
		}
		if (pq.size() == 1) System.out.println(pq.poll());
		else {
			pq.poll();
			System.out.println(pq.poll());
		}
	}
	static void range(int[] arr, int N) {
		System.out.println(arr[N - 1] - arr[0]);
	}
}
