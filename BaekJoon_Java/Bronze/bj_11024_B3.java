package bronze;

import java.util.Scanner;

public class bj_11024_B3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t=0;t<T;++t) {
			int sum = 0;
			String[] now = sc.nextLine().split(" ");
			for(int i=0;i<now.length;++i) sum += Integer.parseInt(now[i]);
			System.out.println(sum);
		}
		sc.close();
	}

}
