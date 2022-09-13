import java.util.*;
import java.io.*;
public class BJ_2559_S3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N];
		for(int i=0;i<N;++i) arr[i] = Integer.parseInt(st.nextToken());
		int sum = Integer.MIN_VALUE;
		for(int i=0;i<N;++i) {
			if(i+K-1>=N) break;
			int now =0;
			for(int j=i;j<i+K;++j) now+= arr[j];
			sum = Math.max(sum,now);
		}
		System.out.println(sum);
	}

}
