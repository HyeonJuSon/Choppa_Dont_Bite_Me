package com.practice.algo.d1;

import java.util.Scanner;

public class example_2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float avg;
		int sum=0;
		int tc = sc.nextInt();
		int tmp;
		for(int i=0;i<tc;i++)
		{
			for(int j=0;j<10;j++)
			{
				tmp = sc.nextInt();
				sum += tmp;
			}
			avg = sum / 10.0f;
			System.out.println("#"+(i+1)+" "+Math.round(avg));
			avg = 0.0f;
			sum = 0;
		}
		sc.close();
	}

}
