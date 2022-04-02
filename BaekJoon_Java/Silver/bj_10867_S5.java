package silver;
import java.io.*;
import java.util.*;
public class bj_10867_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<N;++i) {
			int val = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(val)) {
				hm.put(val, 1);
				pq.add(val);
			}
		}
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
	}

}
