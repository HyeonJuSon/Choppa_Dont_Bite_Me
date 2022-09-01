package bronze;
import java.io.*;
public class bj_7600_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		String input = "";
		while(true) {
			int[] arr = new int[26];
			input = br.readLine().toLowerCase();
			if(input.equals("#")) break;
			for(int i=0;i<input.length();++i) {
				char now = input.charAt(i);
				if('a'<=now&&now<='z') {
					++arr[input.charAt(i)-97];
				}
			}
			int answer =0;
			for(int i=0;i<26;++i) {
				if(arr[i]!=0) ++answer;
			}
			System.out.println(answer);
		}
	}

}
