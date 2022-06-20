package bronze;

import java.util.Scanner;

public class bj_10886_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int cnt1 =0 , cnt2=0;
		for(int i=0;i<T;++i) {
			if(sc.nextInt()==1) {
				++cnt1;
			}else ++cnt2;
		}
		System.out.println(cnt1>cnt2 ?"Junhee is cute!":"Junhee is not cute!");
	}

}
