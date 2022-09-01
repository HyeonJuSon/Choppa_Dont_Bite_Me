package bronze;
import java.io.*;
import java.util.*;
public class bj_14909_B3 {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int cnt  =0 ;
		while(st.hasMoreTokens()) {
			int val  =Integer.parseInt(st.nextToken());
			cnt = val > 0 ? cnt + 1 : cnt;
		}
		System.out.println(cnt);
	}

}
