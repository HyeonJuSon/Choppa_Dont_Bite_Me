package bronze;
import java.io.*;
public class bj_10173_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while(!(input=br.readLine()).equals("EOI")) {
			String tmp = input.toLowerCase();
			System.out.println(tmp.contains("nemo") ? "Found":"Missing");
		}
	}

}
