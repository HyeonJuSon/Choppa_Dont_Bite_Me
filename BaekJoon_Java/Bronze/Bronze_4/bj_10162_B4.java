package bronze;

import java.util.Scanner;

public class bj_10162_B4 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A=0;
		int B=0;
		int C=0;
		
		while(T>=10) {
			if(T>=300) {
				T-=300;
				A++;
			}
			if(T>=60) {
				T-=60;
				B++;
			}
			if(T>=10) {
				T-=10;
				C++;
			}
		}
		
		System.out.println(T==0? A+" "+B+" "+C : -1);
		
	}

	
}
