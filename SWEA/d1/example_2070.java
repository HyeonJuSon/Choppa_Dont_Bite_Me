package com.practice.algo.d1;

import java.util.Scanner;

public class example_2070 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a;
		int b;
		
		for(int i=0;i<T;i++)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			System.out.print("#"+(i+1)+" ");
			if(a>b) System.out.println(">");
			else if(a==b) System.out.println("=");
			else System.out.println("<");
		}
		sc.close();
		
	}

}
