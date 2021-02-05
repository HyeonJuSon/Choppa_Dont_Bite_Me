package com.practice.algo.d1;
import java.util.Scanner;

public class example_2047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		char tmp ;
		String output="";
		for(int i=0;i<str.length();i++)
		{
			tmp = str.charAt(i);
			// 대문자인 경우에는 
			// 65<= tmp && tmp <= 90으로함
			if(97<= tmp && tmp <= 127) // 소문자라면
				output += str.valueOf(tmp).toUpperCase();
			else
				output += tmp;
		}
		
		System.out.println(output);
	}

}
