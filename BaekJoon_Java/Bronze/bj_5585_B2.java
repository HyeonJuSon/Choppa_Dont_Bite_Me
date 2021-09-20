package bronze;

import java.util.Scanner;

public class bj_5585_B2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val = 1000-sc.nextInt();
		int cnt = 0;
		int[] coin_types = {500,100,50,10,5,1};
		for(int coin : coin_types) {
			cnt += val/coin;
			val %= coin;
			
		}
		System.out.println(cnt);
	}
}
