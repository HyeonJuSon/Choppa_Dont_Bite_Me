package bronze;

import java.io.*;
import java.util.*;

public class bj_11328_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[26];
			String target = st.nextToken();
			String check = st.nextToken();
			boolean isPossible = true;
			for(int j=0;j<target.length();++j) ++arr[target.charAt(j)-97];
			for (int j = 0; j < check.length(); ++j) --arr[check.charAt(j)-97];
			for(int now : arr) {
				if(now!=0) {
					isPossible =false;
					break;
				}
			}
			System.out.println(isPossible ? "Possible" : "Impossible");
		}
	}

}
