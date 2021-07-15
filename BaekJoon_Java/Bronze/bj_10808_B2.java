package bronze;

import java.util.*;

public class bj_10808_B2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] arr = new int[26];
		for(int i=0;i<s.length();++i) {
			arr[s.charAt(i)-'0'-49]++;
		}
		for(int i=0;i<26;++i) {
			System.out.print(arr[i]+" ");
		}
	}
}
