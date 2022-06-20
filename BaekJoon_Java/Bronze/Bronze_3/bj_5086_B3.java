package bronze;

import java.io.*;
import java.util.*;

public class bj_5086_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b;
		String[] answer = { "factor", "multiple", "neither" };

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(a==0&&b==0) break;
			System.out.println(a%b==0?answer[1]:(b%a==0?answer[0]:answer[2]));
			
		}
	}

}
