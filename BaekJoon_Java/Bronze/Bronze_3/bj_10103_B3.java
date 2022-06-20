package bronze;

import java.io.*;
import java.util.*;

public class bj_10103_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int changScore = 100;
		int sangScore = 100;
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int chang = Integer.parseInt(st.nextToken());
			int sang = Integer.parseInt(st.nextToken());
			if(chang>sang) sangScore -= chang;
			else if(chang < sang) changScore -= sang;
		}
		System.out.println(changScore);
		System.out.println(sangScore);
	}

}
