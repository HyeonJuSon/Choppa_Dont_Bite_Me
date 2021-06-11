package bronze;

import java.io.*;
import java.util.*;

public class bj_2443_B3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int C = 2*N;
		int start = 0;
		for(int i=1;i<=N;++i) {
			for(int j=0;j<start;++j) System.out.print(" ");
			for(int star=0;star<C-(2*i-1);++star)System.out.print("*");
			System.out.println();
			start++;
		}
	}

}
