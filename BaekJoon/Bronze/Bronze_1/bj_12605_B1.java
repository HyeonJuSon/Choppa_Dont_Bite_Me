package bronze;

import java.io.*;
import java.util.*;

public class bj_12605_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String[] list = new String[st.countTokens()];
			for(int j=0;j<list.length;++j) list[j] = st.nextToken();
			sb.append("Case").append(" ").append("#").append(i).append(":");
			for(int j=list.length-1; j>=0; --j) sb.append(" ").append(list[j]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
