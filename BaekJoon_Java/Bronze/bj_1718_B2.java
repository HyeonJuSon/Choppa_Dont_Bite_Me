package bronze;

import java.util.Scanner;

public class bj_1718_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String base = sc.nextLine();
		String code = sc.nextLine();
		String answer = "";
		int cIdx = 0;
		for (int i = 0; i < base.length(); ++i) {
			int c = ctoi(code.charAt(cIdx));
			char now = base.charAt(i);
			if (now == ' ')
				answer += now;
			else {
				for (int j = 0; j < c; ++j) {
					now -= 1;
					if (ctoi(now) < ctoi('a'))
						now = 'z';
				}
				answer += now;
			}
			cIdx = cIdx == code.length() - 1 ? 0 : cIdx + 1;
		}
		System.out.println(answer);
		sc.close();
	}

	public static int ctoi(char c) {
		return c - 96;
	}

	public static char itoc(int i) {
		return (char) (i + 96);
	}

}
