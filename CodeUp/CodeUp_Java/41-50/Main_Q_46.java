package CodeUp41to50;

import java.util.*;
import java.io.*;

public class Main_Q_46 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long sum = a+b+c;
		double d = 3.0;
		System.out.println(sum);
		System.out.printf("%.1f",sum/d);
	}

}
