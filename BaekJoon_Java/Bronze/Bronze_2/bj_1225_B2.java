package bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class bj_1225_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String front = st.nextToken();
		String back = st.nextToken();
		int sumF=0,sumB=0;
		for(int i=0;i<front.length();++i) sumF += front.charAt(i)-'0';
		for(int i=0;i<back.length();++i) sumB += back.charAt(i)-'0';
		BigInteger big = BigInteger.valueOf(sumF);
		System.out.println(big.multiply(BigInteger.valueOf(sumB)));
	}

}
