package bronze;

import java.io.*;
import java.util.*;


public class bj_10822_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),",");
		int len = st.countTokens();
		int sum =0;
		for(int i=0;i<len;++i)sum+= Integer.parseInt(st.nextToken());
		System.out.println(sum);
	}

}
