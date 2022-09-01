package bronze;

import java.io.*;
import java.util.*;

public class bj_2444_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int front = X-1;
		// 상판
		for(int i=1;i<=X;++i) {
			for(int f=0;f<front;++f) System.out.print(" ");
			for(int r=0;r<i*2-1;++r) System.out.print("*");
			System.out.println();
			--front;
		}
		front = 1;
		// 하판
		for(int i=X-1;i>0;--i) {
			for(int f=0;f<front;++f) System.out.print(" ");
			for(int r=0;r<i*2-1;++r) System.out.print("*");
			System.out.println();
			++front;
		}
	}

}
