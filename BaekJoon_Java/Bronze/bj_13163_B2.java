package bronze;

import java.io.*;
import java.util.*;

public class bj_13163_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			st.nextToken();
			String answer ="";
			while(st.hasMoreTokens()) {
				answer+=st.nextToken();
			}
			System.out.println("god"+answer);
		}
		
		
	}

}
