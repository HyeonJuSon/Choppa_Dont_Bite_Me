import java.io.*;
import java.util.*;

public class bj_11066_G3 {

	static int N, dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;++i) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			int sum = 0;
			while(!pq.isEmpty()) {
				if(pq.size()==1) break;
				int a = pq.poll();
				int b= pq.poll();
				int c = a+b;
				sum += c;
				pq.offer(c);
			}
			System.out.println(sum);
		}
	}

}
