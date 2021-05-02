package bronze;
import java.io.*;
import java.util.*;
public class bj_2846_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start =0, end = 0;
		for(int i=0;i<N;++i) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<N;++i) {
			if(arr[i-1]<arr[i]) { // 오르막길이라면
				if(start==0) start = arr[i-1]; // 오르막길시작이면 시작점에 넣고
				end = arr[i]; // 마지막점에도 넣고
			}else {//내리막길이면
				pq.add(end-start);
				start = arr[i]; // 내리막이면 시작 변경
				end =0;
			}
		}
		pq.add(end-start);
		System.out.println(pq.poll());
	}

}
