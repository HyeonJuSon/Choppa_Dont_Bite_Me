package bronze;

import java.io.*;
import java.math.BigInteger;

public class bj_5893_B4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		BigInteger big = new BigInteger(input,2);
		big = big.multiply(new BigInteger("17"));
		System.out.println(big.toString(2));
	}

}
