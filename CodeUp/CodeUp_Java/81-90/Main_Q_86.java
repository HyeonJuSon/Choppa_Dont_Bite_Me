package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_86 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.printf("%.2f MB",((w*h*b)/8.0)/Math.pow(2, 20));
	}
	
}