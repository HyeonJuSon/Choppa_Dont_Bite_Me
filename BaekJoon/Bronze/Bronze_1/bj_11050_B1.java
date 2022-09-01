package bronze;
import java.io.*;
import java.util.Scanner;
public class bj_11050_B1 {

	static int n, k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		System.out.println(combination(n,k));
	}
	
	static long combination(int n, int k) {
		if(n==k || k==0) return 1;
		return combination(n-1,k-1) + combination(n-1,k);
	}
	
}
