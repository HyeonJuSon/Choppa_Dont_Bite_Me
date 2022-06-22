package silver;
import java.io.*;
import java.util.*;
public class bj_1927_S1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; ++tc) {
			int val = Integer.parseInt(br.readLine());
			if(val == 0) {
				System.out.println(pq.isEmpty()? "0" : pq.poll());
			}else pq.add(val);
		}
	}

}
