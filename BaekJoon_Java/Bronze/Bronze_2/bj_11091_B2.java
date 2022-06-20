package bronze;

import java.io.*;

public class bj_11091_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;++i) {
			int[] alpha = new int[26];
			String input = br.readLine();
			input = input.toLowerCase();
			int cnt = 0;
			for(int j=0;j<input.length();++j) {
				char now = input.charAt(j);
				if('a'<=now&&now<='z'&&alpha[now-97]==0) {
					++alpha[now-97];
					++cnt;
				}
			}
			if(cnt==26) {
				System.out.println("pangram");
			}else {
				System.out.print("missing ");
				String output = "";
				for(int o=0;o<26;++o) {
					if(alpha[o]==0) output+= (char)(o+97);
				}
				System.out.println(output);
			}
		}
	}

}
