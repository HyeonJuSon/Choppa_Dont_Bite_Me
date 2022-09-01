package silver;
import java.io.*;
import java.util.*;
public class bj_11279_S2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; ++tc) {
			int val = Integer.parseInt(br.readLine());
			if(val == 0) {
				System.out.println(pq.isEmpty()? "0" : pq.poll());
			}else pq.add(val);
		}
	}

}
