package bronze;

import java.util.Scanner;

public class bj_2495_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;++i) {
			String now = sc.nextLine();
			char before = now.charAt(0);
			int cnt = 1;
			int Max = -1;
			for(int j=1;j<now.length();++j) {
				if(before==now.charAt(j)) {
					++cnt;
					Max = Math.max(Max, cnt);
				}else {
					before = now.charAt(j);
					Max = Math.max(Max, cnt);
					cnt = 1;
				}
			}
			System.out.println(Max);
		}
	}

}
