package bronze;

import java.io.*;
import java.util.*;

public class bj_1357_B1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = Rev(sc.nextInt());
		int y = Rev(sc.nextInt());
		System.out.println(Rev(x + y));
	}

	private static int Rev(int N) {
		String str = "";
		while (N > 0) {
			str += N % 10;
			N /= 10;
		}
		return Integer.parseInt(str);
	}

}
