package bj;

import java.util.*;

public class bj_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while(N>=0) {
			if(N%5==0) {
				cnt+=N/5;
				N %= 5;
				break;
			}else {
				N -= 3;
				cnt++;
			}		
		}
		if (N == 0) System.out.println(cnt);
		else System.out.println("-1");
		sc.close();
	}
}
