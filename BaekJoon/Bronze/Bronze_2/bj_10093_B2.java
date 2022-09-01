package bronze;
import java.io.*;
import java.util.*;
public class bj_10093_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long start = Long.parseLong(st.nextToken());
		long end = Long.parseLong(st.nextToken());
		if(start > end) {
			long tmp = start;
			start = end;
			end = tmp;
		}
		StringBuilder sb = new StringBuilder();
		for(long now = start+1; now < end; ++now)
			sb.append(now).append(' ');
		long cnt = end-start -1;
		if(cnt < 0) cnt= 0;
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}
