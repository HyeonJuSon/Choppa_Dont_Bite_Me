package bronze;

import java.util.Scanner;

public class bj_5598_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String target =sc.next();
		String answer = "";
		for(int i=0;i<target.length();++i) {
			char tmp = target.charAt(i);
			if(tmp <='C') {
				answer+=(char)(tmp+23);
			}else
				answer+=(char)(target.charAt(i)-3);
		}
		System.out.println(answer);
	}

}
