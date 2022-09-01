package bronze;

import java.util.Scanner;

public class bj_10102_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		String input = sc.next();
		int[] cnt = new int[2];//0-A, 1-B
		for(int i=0;i<T;++i) {
			char now = input.charAt(i);
			if(now=='A') ++cnt[0];
			else ++cnt[1];
		}
		System.out.println(cnt[0] > cnt[1] ? "A":(cnt[0] < cnt[1] ? "B":"Tie"));
	}

}
