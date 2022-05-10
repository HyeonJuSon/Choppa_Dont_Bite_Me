package bronze;

import java.io.*;
import java.util.*;

public class bj_2525_B4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int extra = Integer.parseInt(br.readLine());
		m+=extra;
		if(m+extra>=60) {
			int cnt = m/60;
			m %= 60;
			h+=cnt;
			if(h>=24) h-=24;
		}
		System.out.println(h+" "+m);
	}

}
