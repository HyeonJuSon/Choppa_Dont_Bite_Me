package bronze;
import java.util.*;
public class BJ_10156_B4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sum = M-K*N;
		System.out.println(sum < 0 ? Math.abs(sum) : 0);
	}

}
