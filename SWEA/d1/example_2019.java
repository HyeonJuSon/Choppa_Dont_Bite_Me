package com.practice.algo.d1;
import java.util.Scanner;
public class example_2019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Loop = sc.nextInt();
		sc.close();
		
		int output=1;
		System.out.print(output+" ");
		for(int i=1;i<=Loop;i++)
		{
			output*=2;
			System.out.print(output+" ");
		}
		
	}

}
