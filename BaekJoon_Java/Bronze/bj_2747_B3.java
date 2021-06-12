package bronze;
import java.io.*;
public class bj_2747_B3 {
	
	static int f[] = new int[46];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		f[0]=0;
		f[1]=1;
		System.out.println(fibo(N));
	}

	static int fibo(int n) {
		if(n==0) return f[0];
		else if(n==1) return f[1];
		else if(f[n]!=0) return f[n];
		return f[n]=fibo(n-1)+fibo(n-2);
	}
}
