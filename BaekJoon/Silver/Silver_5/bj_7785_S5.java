package silver;
import java.io.*;
import java.util.*;
public class bj_7785_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			String log = st.nextToken();
			if(log.equals("enter")) {
				map.put(name, 1);//출근중
			}else
				map.put(name, 0);//없다
		}
		PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(String key : map.keySet()) {
			if(map.get(key)==1) pq.add(key);
		}
		
		while(!pq.isEmpty()) System.out.println(pq.poll());
	}

}
