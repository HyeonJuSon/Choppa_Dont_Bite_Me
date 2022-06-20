package bronze;

import java.io.*;
import java.math.BigInteger;

public class bj_2935_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger a = new BigInteger(br.readLine());
		String order = br.readLine();
		BigInteger b = new BigInteger(br.readLine());
		System.out.println(order.equals("*")?a.multiply(b):a.add(b));
	}

}
