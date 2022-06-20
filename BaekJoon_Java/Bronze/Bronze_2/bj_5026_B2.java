package bronze;

import java.io.*;

public class bj_5026_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i) {
			String input = br.readLine();
			if(input.equals("P=NP")) {
				System.out.println("skipped");
				continue;
			}
			String[] arr = input.split("\\+");
			System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
		}
	}
	
}
