package bronze;

import java.io.*;

public class bj_13235_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int mid = input.length() / 2;
		boolean isPossible = true;
		int s = mid - 1, e = input.length() % 2 == 0 ? mid : mid + 1;
		while(s>=0) {
			if(input.charAt(s)!=input.charAt(e)) isPossible =false;
			if(!isPossible) break;
			--s;
			++e;
		}
		System.out.println(isPossible ? "true":"false");
	}

}
