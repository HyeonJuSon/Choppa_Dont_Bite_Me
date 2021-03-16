package bj.bronze;

import java.io.*;
import java.util.*;

public class bj_1712_B4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		if (C<=B) {
			System.out.println(-1);
		} else {
			System.out.println(A/(C-B)+1);
		}
		sc.close();
	}

}
