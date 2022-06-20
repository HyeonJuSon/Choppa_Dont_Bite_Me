package bronze;

import java.io.*;

public class bj_1373_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String binary = br.readLine();
		binary = binary.length() % 3 == 1 ? "00" + binary : (binary.length() % 3 == 2 ? "0" + binary : binary);
		for (int i = 0; i < binary.length(); i += 3) {
			int decimal = ((binary.charAt(i) - '0') * 4 + (binary.charAt(i + 1) - '0') * 2
					+ (binary.charAt(i + 2) - '0'));
			sb.append(decimal);
		}
		System.out.println(sb.toString());
	}

}
