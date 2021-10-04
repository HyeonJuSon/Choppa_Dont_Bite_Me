package bronze;

import java.util.*;
import java.io.*;

public class bj_16205_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int type = Integer.parseInt(st.nextToken());
		String word = st.nextToken();
		String[] output = new String[3];
		Arrays.fill(output, "");
		output[type - 1] = word;
		switch (type) {
		case 1: // 카멜
			// to snake
			for (int i = 0; i < word.length(); ++i) {
				char now = word.charAt(i);
				if (65 <= now && now <= 90) output[1] += "_" + (now + "").toLowerCase();
				else output[1] += now;
			}
			// to pascal
			output[2] = output[0].substring(0, 1).toUpperCase() + output[0].substring(1);
			break;
		case 2:
			// to camel
			for (int i = 0; i < word.length(); ++i) {
				char now = word.charAt(i);
				if (now == '_') output[0] += (word.charAt(++i) + "").toUpperCase();
				else output[0] += now;
			}
			// to pascal
			output[2] = output[0].substring(0, 1).toUpperCase() + output[0].substring(1);
			break;
		case 3:
			// to camel
			output[0] = output[2].substring(0, 1).toLowerCase() + output[2].substring(1);
			// to snake
			output[1] += (word.charAt(0)+"").toLowerCase();
			for(int i=1;i<word.length();++i) {
				char now = word.charAt(i);
				if (65 <= now && now <= 90) output[1]+= "_"+(now+"").toLowerCase();
				else output[1]+=now;
			}
			break;
		}
		for(int i=0;i<3;++i)
			System.out.println(output[i]);
	}

}
