package bronze;

import java.io.*;
import java.util.*;

public class bj_1371_B2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		int max = 0;
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			for (int i = 0; i < str.length(); i++) {
				char now = str.charAt(i);
				if ('a'<= now && now <= 'z') {
					++arr[ now - 'a'];
					max = Math.max(max, arr[now-'a']);
				}
			}
		}

		for (int i = 0; i < 26; i++) {
			if (max == arr[i]) System.out.println((char) (i + 'a'));
			
		}
	}

}
