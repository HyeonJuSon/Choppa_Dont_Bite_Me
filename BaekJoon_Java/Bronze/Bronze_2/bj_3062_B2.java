package bronze;

import java.util.*;
import java.io.*;

public class bj_3062_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; ++t) {
			String val = br.readLine();
			StringBuilder sb = new StringBuilder();
			String reverse = sb.append(val).reverse().toString();
			String sum = "";
			int N = val.length();
			if (N == 1) sum = val;
			else sum = Integer.toString(Integer.parseInt(val)+Integer.parseInt(reverse));
			sb = new StringBuilder();
			reverse = sb.append(sum).reverse().toString();
			boolean isSame = true;
			for(int i=0;i<N;++i) {
				if(sum.charAt(i) != reverse.charAt(i)) {
					isSame =false;
					break;
				}
			}
			System.out.println(isSame ? "YES":"NO");
		}
	}

}
