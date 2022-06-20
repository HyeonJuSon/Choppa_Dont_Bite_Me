package bronze;
import java.io.*;

public class BJ_23037_B5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int answer = 0;
		for(int i=0;i<input.length();++i) {
			int val = input.charAt(i)-'0';
			answer += (int) Math.pow(val, 5);
		}
		System.out.println(answer);
	}

}
