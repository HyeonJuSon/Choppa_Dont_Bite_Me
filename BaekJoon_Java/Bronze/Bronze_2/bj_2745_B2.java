package bronze;
import java.io.*;
import java.util.*;
public class bj_2745_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=0;i<N.length();++i) {
			char now = N.charAt(i);
			ans = ans * B;
			if('0'<=now && now <='9') {
				ans += (now-'0');
			}else { // 10이상인 경우
				ans += (now-'A'+10);
			}
		}
		System.out.println(ans);
		
	}

}
