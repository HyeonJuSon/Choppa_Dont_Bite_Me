import java.io.*;
import java.util.*;
public class BJ_25304_B5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int calc=0;
		for(int t=0;t<T;++t) {
			st = new StringTokenizer(br.readLine()," ");
			int price = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			calc += price*cnt;
		}
		System.out.println(calc==sum?"Yes":"No");
	}

}
