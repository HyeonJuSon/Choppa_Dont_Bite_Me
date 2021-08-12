package silver;

import java.io.*;
import java.util.*;

public class bj_1764_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		PriorityQueue<String> listenwatch = new PriorityQueue<String>();// 듣보
		// 듣
		for(int i=0;i<N+M;++i) {
			String key =br.readLine();
			hm.put(key, hm.getOrDefault(key, 0)+1);
		}
		hm.forEach((k, v)->{
			if(v == 2) listenwatch.add(k);//듣보면 듣보리스트에 올린다.
		});
		System.out.println(listenwatch.size());
		while(!listenwatch.isEmpty())
			System.out.println(listenwatch.poll());
	}

}
