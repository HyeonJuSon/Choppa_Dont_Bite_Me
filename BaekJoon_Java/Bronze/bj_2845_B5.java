package bronze;

import java.io.*;
import java.util.*;
public class bj_2845_B5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int people = L*P;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine()," ");
		int val = Integer.parseInt(st.nextToken());
		sb.append(val-people);
		while(st.hasMoreTokens()) {
			val = Integer.parseInt(st.nextToken());
			sb.append(" ").append(val-people);
		}
		System.out.println(sb.toString());
	}

}
