package bronze;

import java.io.*;
import java.util.*;

public class bj_2711_B2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int idx = Integer.parseInt(st.nextToken());
			String input = st.nextToken();
			System.out.println(input.substring(0,idx-1) + input.substring(idx,input.length()));
		}
	}

}
