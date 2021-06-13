package bronze;

import java.io.*;

public class bj_1193_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int line = 0;
		int cnt = 0;
		while (cnt < N) {
			line++;
			cnt = line * (line + 1) / 2;
		}
		if (line % 2 != 0) {
			int top = 1 + (cnt - N);
			int bottom = line - (cnt - N);
			System.out.println(top + "/" + bottom);
		} else {
			int top = line - (cnt - N);
			int bottom = 1 + (cnt - N);
			System.out.println(top + "/" + bottom);
		} // end

	}

}
