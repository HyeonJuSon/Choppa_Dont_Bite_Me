package bronze;

import java.io.*;
import java.util.*;

public class bj_1159_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[26];
		for(int i=0;i<N;++i) {
			char now =br.readLine().charAt(0);
			arr[now-97]++;
		}
		String answer ="";
		for(int i=0;i<26;++i) {
			if(arr[i]>=5)
				answer+=((char)(i+97));
		}
		System.out.println(answer.length()==0?"PREDAJA":answer);
	}

}
