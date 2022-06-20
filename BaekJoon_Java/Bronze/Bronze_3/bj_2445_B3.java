package bronze;

import java.io.*;
import java.util.*;

public class bj_2445_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int C = 2*X;
		int star = 1;
		for(int i=1;i<=X;++i) {
			for(int j=0;j<star;++j) System.out.print("*");
			for(int e=0;e<C-(2*i);++e)System.out.print(" ");
			for(int j=0;j<star;++j) System.out.print("*");
			System.out.println();
			star++;
		}
		star = X-1;
		for(int i=X-1;i>0;--i) {
			for(int j=0;j<star;++j) System.out.print("*");
			for(int e=0;e<C-(2*i);++e)System.out.print(" ");
			for(int j=0;j<star;++j) System.out.print("*");
			System.out.println();
			--star;
		}
	}

}
