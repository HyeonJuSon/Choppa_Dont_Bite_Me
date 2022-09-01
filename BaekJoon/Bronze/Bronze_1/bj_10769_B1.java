package bronze;

import java.io.*;

public class bj_10769_B1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();
		String H = ":-)";
		String S = ":-(";
		int happy = 0, sad = 0;
		for (int i = 0; i < val.length() - 2; ++i) {
			String now = val.substring(i, i + 3);
			if (now.equals(H))
				happy++;
			else if (now.equals(S))
				sad++;
		}
		System.out.println(happy == 0 && sad == 0 ?"none": (happy == sad ? "unsure" : (happy > sad ? "happy" : "sad")));
	}

}
