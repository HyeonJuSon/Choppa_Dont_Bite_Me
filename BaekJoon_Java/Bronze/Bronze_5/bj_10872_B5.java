package bj;
import java.util.Scanner;
public class bj_10872 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(Factorial(N));
	}
	
	static int Factorial(int n) {
		if(n<=1) return 1;
		return n * Factorial(n-1);
	}
}
