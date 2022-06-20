package bronze;
import java.io.*;
public class bj_21964_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		System.out.println(str.substring(N-5,N));
	}

}
