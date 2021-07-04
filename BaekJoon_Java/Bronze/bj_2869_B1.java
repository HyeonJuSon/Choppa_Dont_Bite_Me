package bronze;

import java.io.*;
import java.util.*;

public class bj_2869_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int day = (V-B) / (A-B);
		if((V-B) % (A-B) != 0) ++day;
		System.out.println(day);
	}

}
