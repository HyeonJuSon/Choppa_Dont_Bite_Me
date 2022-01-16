package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_23303_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();
		System.out.println(val.contains("D2") || val.contains("d2") ? "D2":"unrated");
	}

}
