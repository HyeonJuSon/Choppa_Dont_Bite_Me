package bronze;

import java.util.Scanner;

public class bj_10987_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		String target = "aeiou";
		int count = 0;
		for(int i=0; i<str.length();++i) {
			if(target.contains(str.charAt(i)+"")) ++count;
		}
		System.out.println(count);
	}

}
