package bronze;

import java.io.*;
import java.util.*;

public class bj_2455_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int now = 0;
		int answer = 0;
		for (int i = 0; i < 4; ++i) {
			StringTokenizer st  = new StringTokenizer(br.readLine()," ");
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			now += in - out;
			answer = Math.max(answer, now);
		}
		System.out.println(answer);
	}

}
