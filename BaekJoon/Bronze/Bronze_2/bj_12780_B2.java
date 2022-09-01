package bronze;
import java.io.*;
public class bj_12780_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String H = br.readLine();
		String N = br.readLine();
		int len = N.length();
		int cnt = 0;
		for(int i=0;i<H.length()-len+1;++i) {
			boolean isPossible=true;
			for(int j=0;j<len;++j) {
				if(H.charAt(i+j) != N.charAt(j)) {
					isPossible=false;
					break;
				}
			}
			if(isPossible) ++cnt;
		}
		System.out.println(cnt);
	}

}
