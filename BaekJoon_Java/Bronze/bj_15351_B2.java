package bronze;
import java.io.*;
public class bj_15351_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;++i) {
			String str = br.readLine();
			int sum =0;
			for(int s=0;s<str.length();++s) {
				if(str.charAt(s)!=' ')
					sum += (int)str.charAt(s) -64;
			}
			System.out.println(sum == 100 ? "PERFECT LIFE" : sum);
		}
	}

}
