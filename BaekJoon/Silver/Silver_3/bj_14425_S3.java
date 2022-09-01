package gold;
import java.util.*;
import java.io.*;
public class bj_14425_S3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> hm = new HashMap<>();
		for(int i=0;i<N;++i) {
			hm.put(br.readLine(), 1);
		}
		int answer =0 ;
		for(int i=0;i<M;++i) {
			String now = br.readLine();
			if(hm.containsKey(now)) ++answer;
		}
		System.out.println(answer);
	}

}
