package bronze;

import java.io.*;
import java.util.*;

public class bj_2566_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x=0,y=0,max = Integer.MIN_VALUE;
		for (int i = 1; i <= 9; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=9;++j) {
				int val = Integer.parseInt(st.nextToken());
				if(max < val) {
					x=i;
					y=j;
					max=val;
				}
			}
		}
		System.out.println(max);
		System.out.println(x+" "+y);
	}

}
