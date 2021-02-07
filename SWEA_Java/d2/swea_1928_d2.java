package com.algo.d2;

import java.io.*;
import java.util.Base64;

public class swea_1928_d2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			String encoded = br.readLine();
			String decoded = new String(Base64.getDecoder().decode(encoded));
			System.out.println("#" + tc + " " + decoded);
		}
	}

}
