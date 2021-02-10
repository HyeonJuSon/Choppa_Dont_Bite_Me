package bj;
import java.util.*;
public class bj_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[42];
		int cnt =0;
		for(int i=0;i<10;++i) {
			int val = sc.nextInt();
			int tmp = val %42;
			if(num[tmp]==0) {
				cnt++;
				num[tmp]++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
