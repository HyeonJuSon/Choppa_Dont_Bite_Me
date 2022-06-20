package bronze;

import java.io.*;

public class bj_4470_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;++i) {
			System.out.println(i+". "+ br.readLine());
		}
	}

}
