package silver;
import java.io.*;
import java.util.*;
public class BJ_14912_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int cnt = 0;
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;++i) {
			int now = i;
			while(true) {
				if(now%10==target) {
					++cnt;
				}
				if(now/10==0) break;
				now/=10;
			}
		}
		System.out.println(cnt);
	}

}
