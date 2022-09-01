package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1246_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		String input;
		String target = "aeiou";
		while(!(input=br.readLine()).equals("#")) {
			int cnt =0;
			input = input.toLowerCase();
			for(int i=0;i<input.length();++i) {
				if(target.contains(input.charAt(i)+"")) {
					++cnt;
				}
			}
			System.out.println(cnt);
		}
	}

}
