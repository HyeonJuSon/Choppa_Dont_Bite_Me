package com.practice.algo.d1;
import java.util.Scanner;
public class example_1933 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i=1;i<=N;i++)
		{
			if(N%i == 0)
				System.out.print(i+" ");
		}
	}		

}
