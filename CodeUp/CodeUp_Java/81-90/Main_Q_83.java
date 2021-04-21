package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_83 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;++i) System.out.print(i%3==0||i%6==0 || i%9 ==0 ? "X " : i+" ");
	}
}
