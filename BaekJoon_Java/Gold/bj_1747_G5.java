package gold;

import java.io.*;
import java.util.*;

public class bj_1747_G5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int pMax = 4000000;
		boolean[] primes = new boolean[pMax]; // false is prime
		primes[0] = primes[1] = true;
		for (int i = 2; i * i < pMax; ++i) {
			if (!primes[i]) {
				for (int j = i * i; j <pMax; j += i)
					primes[j] = true;
			}
		}

		for (int i = 1; i < pMax; ++i) {
			if (i < N || primes[i])
				continue;
			if (isPalindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	static boolean isPalindrome(int val) {
		String original= Integer.toString(val);
		StringBuilder sb = new StringBuilder(original);
		String reverse = sb.reverse().toString();
		return original.equals(reverse);
	}
}
