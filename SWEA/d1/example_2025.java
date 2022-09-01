package com.practice.algo.d1;
import java.util.Scanner;
public class example_2025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val = sc.nextInt();
		sc.close();
		int sum = 0;
		
		for(int i=1;i<=val;i++)
		{
			sum+=i;
		}
		
		System.out.println(sum);
	}

}
