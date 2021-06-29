package bronze;

import java.util.Scanner;

public class bj_2490_B3 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		for(int i=1;i<=12;++i) {
			cnt = sc.nextInt() ==0 ? cnt+1 : cnt;
			if(i%4 ==0) {
				System.out.println(cnt == 1 ? "A":(cnt == 2 ? "B" : (cnt == 3 ? "C" :(cnt == 4 ? "D" : "E"))));
				cnt =0 ;
			}
		}
		sc.close();
	}

}
