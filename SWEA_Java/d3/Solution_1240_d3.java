import java.io.*;
import java.util.*;

public class Solution_1240_d3 {

	static String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String target = "";
			for (int i = 0; i < N; ++i) {
				String input = br.readLine();
				if(!target.isEmpty()) continue;
				for (int j = M - 1; j >= 0; --j) {
					if (input.charAt(j) == '1') {
						target = input.substring(j - 55, j + 1);
						break;
					}
				}
			}
			System.out.println("#" + t + " " + getAnswer(target));
		}
	}

	static int getAnswer(String target) {
		int[] tmp = getDigit(target);
		int answer = 0, odd = 0, even = 0;
		for (int i = 0; i < tmp.length; ++i) {
			answer += tmp[i];
			if ((i+1) % 2 == 0)
				even += tmp[i];
			else
				odd += tmp[i];
		}
		odd *= 3;
		return (odd + even) % 10 == 0 ? answer : 0;

	}

	static int[] getDigit(String target) {
		int[] digit = new int[8];
		int idx = 0;
		for (int i = 0; i < target.length(); i += 7) {
			String now = target.substring(i, i + 7);
			for (int j = 0; j < 10; ++j) {
				if (code[j].equals(now)) {
					digit[idx++] = j;
					break;
				}
			}
		}
		return digit;
	}

}
