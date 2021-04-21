package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_92 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		for(int i=1; ; ++i) {
			if(i%a==0 && i%b==0 && i%c ==0) {
				System.out.println(i);
				break;
			}
		}
	}
	
}
