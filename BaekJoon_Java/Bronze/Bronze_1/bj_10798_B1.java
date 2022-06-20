package bronze;
import java.io.*;
public class bj_10798_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = new String[5];
		int max = 0;
		for(int i=0;i<5;++i) {
			input[i]=br.readLine();
			max = Math.max(max, input[i].length());
		}
		String answer ="";
		for(int j=0;j<max;++j) {
			for(int i=0;i<5;++i) {
				if(input[i].length()-1<j) continue;
				if(input[i].charAt(j)==' ') continue;
				answer += input[i].charAt(j);
			}
		}
		System.out.println(answer);
	}

}
