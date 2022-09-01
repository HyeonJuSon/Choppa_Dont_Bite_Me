package bronze;
import java.io.*;
import java.util.*;
public class bj_15819_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		PriorityQueue<String> dictionary = new PriorityQueue<String>();
		for(int i=0;i<N;++i) {
			dictionary.add(br.readLine());
		}
		int idx = 1;
		while(true) {
			String now = dictionary.poll();
			if(idx++ == I) {
				System.out.println(now);
				break;
			}
		}
	}

}
