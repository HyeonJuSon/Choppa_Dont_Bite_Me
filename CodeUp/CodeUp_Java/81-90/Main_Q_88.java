package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_88 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N;++i) {
			if(i%3!=0) System.out.print(i+" ");
		}
	}
	
}