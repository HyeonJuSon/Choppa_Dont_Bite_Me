package com.practice.algo.d1;
import java.util.Scanner;
public class example_2043 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int p = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		sc.close();
		
		System.out.println(p-k+1);
	}

}
