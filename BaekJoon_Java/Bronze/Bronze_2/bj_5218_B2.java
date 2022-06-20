package bronze;

import java.io.*;
import java.util.*;

public class bj_5218_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sb.append("Distances: ");
			String X = st.nextToken();
			String Y = st.nextToken();
			int len = X.length();
			for (int j = 0; j < len; ++j) {
				int x = X.charAt(j) -'0';
				int y = Y.charAt(j) -'0';
				if(y>=x) sb.append(y-x).append(" ");
				else sb.append((y+26)-x).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
