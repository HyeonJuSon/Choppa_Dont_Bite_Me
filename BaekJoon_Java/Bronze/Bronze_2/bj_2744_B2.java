package bronze;

import java.util.Scanner;

public class bj_2744_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String answer ="";
		for(int i=0;i<str.length();++i) {
			char now = str.charAt(i);
			if('a'<=now && now<='z') {
				answer += (char)(now-32);
			}else {
				answer +=(char)(now+32);
			}
		}
		System.out.println(answer);
	}

}
