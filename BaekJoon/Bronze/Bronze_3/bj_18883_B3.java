package bronze;

import java.io.*;
import java.util.*;

public class bj_18883_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb= new StringBuilder();
		for(int i=1;i<=M*N;++i) {
			if(i%M==0) {
				sb.append(i).append('\n');
			}else {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb.toString());
	}	

}
