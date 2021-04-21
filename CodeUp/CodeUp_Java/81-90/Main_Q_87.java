package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_87 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum =0;
		for(int i=1;;++i) {
			sum += i;
			if(sum >= N) break;
		}
		System.out.println(sum);
	}
	
}