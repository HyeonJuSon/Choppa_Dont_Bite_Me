package bronze;

import java.io.*;
import java.util.*;

public class BJ_2774_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			HashSet<Character> hs = new HashSet<>();
			String now = br.readLine();
			for (int j = 0; j < now.length(); ++j) {
				char ch = now.charAt(j);
				hs.add(ch);
			}
			System.out.println(hs.size());
		}
	}

}
