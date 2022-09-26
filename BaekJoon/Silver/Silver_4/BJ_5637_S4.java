import java.util.*;

public class BJ_5637_S4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		String answer = "";
		while (sc.hasNext()) {
			String input = sc.next();
			if (input.equals("E-N-D"))
				break;
			input = input.trim();
			int cnt = 0;
			String tmp = "";
			boolean isCheck = false;
			for (int i = 0; i < input.length(); ++i) {
				char now = input.charAt(i);
				isCheck = false;
				if (('a' <= now && now <= 'z') || ('A' <= now && now <= 'Z') || now == '-') {
					++cnt;
					tmp += now;
				} else {
					if (max < cnt) {
						max = cnt;
						answer = tmp;
						tmp = "";
						cnt = 0;
					}
					isCheck = true;
				}
			}
			if (!isCheck && max < cnt) {
				max = cnt;
				answer = tmp.toLowerCase();
			}
		}
		System.out.println(answer);
	}

}
