package bronze;
import java.io.*;

public class bj_5524_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			String input = br.readLine();
			System.out.println(input.toLowerCase());
		}
	}

}
