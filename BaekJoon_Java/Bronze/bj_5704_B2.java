package bronze;

import java.io.*;

public class bj_5704_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int[] arr ;
		while(!(input=br.readLine()).equals("*")) {
			arr = new int[26];
			for(int i=0;i<input.length();++i) {
				if(input.charAt(i)!=' ')
					++arr[input.charAt(i)-97];
			}
			int cnt =0 ;
			for(int i=0;i<26;++i) if(arr[i]==0)++cnt;
			System.out.println(cnt ==0 ? "Y":"N");
		}
	}

}
