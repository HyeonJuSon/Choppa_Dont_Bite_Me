package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1453_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[101];
		int reject = 0;
		for(int i=0;i<N;++i) {
			int seat = Integer.parseInt(st.nextToken());
			if(arr[seat]!=0) ++reject;
			else arr[seat]=1;
		}
		System.out.println(reject);
	}

}
