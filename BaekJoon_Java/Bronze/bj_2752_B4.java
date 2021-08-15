package bronze;

import java.io.*;
import java.util.*;

public class bj_2752_B4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<3;++i) pq.add(Integer.parseInt(st.nextToken()));
		while(!pq.isEmpty()) System.out.print(pq.poll()+" ");
	}

}
