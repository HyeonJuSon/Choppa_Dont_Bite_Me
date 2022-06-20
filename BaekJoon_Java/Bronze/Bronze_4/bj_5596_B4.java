package bronze;

import java.util.Scanner;

public class bj_5596_B4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minguk = 0, manse = 0;
		for(int i=0;i<4;++i) minguk+= sc.nextInt();
		for(int i=0;i<4;++i) manse+= sc.nextInt();
		System.out.println(minguk < manse ? manse : minguk);
	}

}
