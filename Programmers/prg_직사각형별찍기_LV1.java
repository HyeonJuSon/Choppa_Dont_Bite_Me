package Programmers;

import java.io.*;
import java.util.*;

public class prg_직사각형별찍기_LV1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
