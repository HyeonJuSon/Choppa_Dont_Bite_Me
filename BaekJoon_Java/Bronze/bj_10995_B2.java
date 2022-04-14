package bronze;
import java.util.*;
public class bj_10995_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean isflag = false;
		String on = " *";
		String off = "*";
		for(int i=1;i<=N;++i) {
			isflag = i%2 == 0;
			String answer = "";
			for(int j=1;j<=N;++j) {
				if(!isflag) {
					answer += off;
					isflag = true;
				}else {
					answer += on;
				}
			}
			System.out.println(answer);
		}
	}

}
