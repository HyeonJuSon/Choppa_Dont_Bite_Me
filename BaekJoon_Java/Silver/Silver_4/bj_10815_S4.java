package gold;
import java.io.*;
import java.util.*;
public class bj_10815_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		HashMap<Integer,Integer> have = new HashMap<>();
		for(int i=0;i<N;++i) {
			int val = Integer.parseInt(st.nextToken());
			have.put(val, 1);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;++i) {
			int val = Integer.parseInt(st.nextToken());
			if(have.containsKey(val)) sb.append(1);
			else sb.append(0);
			sb.append(' ');
		}
		System.out.println(sb.toString());
	}

}
