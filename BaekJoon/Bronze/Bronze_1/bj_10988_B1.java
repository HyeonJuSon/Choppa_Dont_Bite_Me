package bronze;

import java.io.*;
import java.util.*;

public class bj_10988_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String original = br.readLine();
		String reverse = sb.append(original).reverse().toString();
		System.out.println(original.equals(reverse)?1:0);
	}

}
