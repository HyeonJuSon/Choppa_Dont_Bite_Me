package bronze;

import java.io.*;

public class bj_15917_B3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			int val = Integer.parseInt(br.readLine());
			System.out.println((val&(-1*val))==val ? 1: 0 );
		}
	}

}
