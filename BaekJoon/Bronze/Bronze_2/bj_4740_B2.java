package bronze;
import java.io.*;
public class bj_4740_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		while(true) {
			input = br.readLine();
			if(input.equals("***")) break;
			StringBuilder sb = new StringBuilder();
			sb.append(input);
			System.out.println(sb.reverse().toString());
		}
	}

}
