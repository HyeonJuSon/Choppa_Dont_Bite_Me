	package bronze;
	
	import java.io.*;
	import java.util.*;
	
	public class bj_2442_B3 {
	
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int X = Integer.parseInt(br.readLine());
			int blank = X-1;
			for(int i=1;i<=X;++i) {
				for(int b=0;b<blank;++b) System.out.print(" ");
				for(int s=0;s<i*2-1;++s) System.out.print("*");
				System.out.println();
				--blank;
			}
		}
	
	}
