package com.practice.algo.d1;
import java.util.Scanner;

public class example_2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int val = 0;
		for(int tc= 1; tc <= T; tc++)
		{
            int sum = 0 ;
			for(int i=0; i<10; i++)
            {
                val = sc.nextInt();
                if(val % 2!=0)
					sum+=val;
            }
            System.out.println("#"+tc+" "+sum);
		}
		sc.close();
	}

}
