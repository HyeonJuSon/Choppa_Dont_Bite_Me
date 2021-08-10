package bronze;

import java.io.*;
import java.util.*;

public class bj_11365_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		StringBuilder sb = new StringBuilder();
		while (!(input = br.readLine()).equals("END")) {
			for (int i = input.length() - 1; i >= 0; --i) {
				sb.append(input.charAt(i));
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
