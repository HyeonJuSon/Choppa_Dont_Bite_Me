package silver;
import java.io.*;
import java.util.*;
public class bj_2003_S3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) arr[i] = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int start = 0, end = 0;
		while(true) {
			if(end == N) break;
			
			int sum = 0;
			for(int i=start;i<=end;++i) sum+= arr[i];
			if(sum < M) ++end;
			else {
				if(sum==M)++cnt;
				++start;
			}
		}
		System.out.println(cnt);
	}

}
