package bronze;

import java.io.*;
import java.util.*;

public class bj_18883_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = N*M;
		for(int i=1;i<=max;++i) {
			System.out.print(i+" ");
			if(i%M==0) System.out.println();
		}
	}	

}
