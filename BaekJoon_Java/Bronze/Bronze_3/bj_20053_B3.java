package bronze;
import java.io.*;
import java.util.*;
public class bj_20053_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T;++t) {
			int N = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;++i) {
				int val = Integer.parseInt(st.nextToken());
				if(min > val) min = val;
				if(max < val) max = val;
			}
			System.out.println(min+" "+max);
		}
	}

}
