package bronze;
import java.io.*;
import java.util.*;
public class bj_2386_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while(true) {
			input= br.readLine();
			String alpha = input.substring(0,1);
			if(alpha.equals("#")) break;
			input = input.substring(1).toLowerCase();
			int cnt = 0;
			for(int i=0;i<input.length();++i) {
				if(alpha.equals(input.charAt(i)+"")) ++cnt;
			}
			System.out.println(alpha+" "+cnt);
		}
	}

}
