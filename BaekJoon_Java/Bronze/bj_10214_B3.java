package bronze;

import java.io.*;
import java.util.*;

public class bj_10214_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			int y = 0, x = 0;
			for (int j = 0; j < 9; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				y+=Integer.parseInt(st.nextToken());
				x += Integer.parseInt(st.nextToken());
			}
			System.out.println(y>x?"Yonsei":(y<x?"Korea":"Draw"));
		}

	}

}
