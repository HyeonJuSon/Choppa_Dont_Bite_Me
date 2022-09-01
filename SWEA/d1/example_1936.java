package com.practice.algo.d1;
import java.util.Scanner;
public class example_1936 {

	public static void main(String[] args) {
		//가위1바위2보3
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
	
		sc.close();
		String output = (a+1)%3 > (b+1)%3 ? "A":"B";
		System.out.println(output);
	}

}
