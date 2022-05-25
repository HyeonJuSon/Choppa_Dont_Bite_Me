package bronze;

import java.io.*;
import java.util.*;

public class BJ_2596_B2 {

	static HashMap<String, String> hm = new HashMap<String, String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		hm.put("000000", "A");
		hm.put("001111", "B");
		hm.put("010011", "C");
		hm.put("011100", "D");
		hm.put("100110", "E");
		hm.put("101001", "F");
		hm.put("110101", "G");
		hm.put("111010", "H");
		int idx = 0;
		String answer = "";
		for (int i = 1; i <= N; ++i) {
			String now = input.substring(idx, idx + 6);
			if (hm.containsKey(now)) {
				answer += hm.get(now);
			} else {
				String tmp = isFind(now);
				if (tmp.equals("")) {
					System.out.println(i);
					System.exit(0);
				}else {
					answer += hm.get(tmp);
				}
			}
			idx +=6;
		}
		System.out.println(answer);
	}

	static String isFind(String now) {
		String answer = "";
		for (String key : hm.keySet()) {
			int cnt = 0;
			for (int i = 0; i < key.length(); ++i) {
				if (now.charAt(i) != key.charAt(i))
					++cnt;
			}
			if (cnt == 1)
				answer = key;
		}
		return answer;
	}

}
