package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_85 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long h = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		System.out.printf("%.1f MB",((h*b*c*s) / 8.0)/Math.pow(2, 20));
	}
	
}