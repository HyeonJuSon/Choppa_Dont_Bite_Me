import java.util.*;

public class BJ_1672_B2 {

	static char getCode(char a, char b) {
		int idx = (a == 'A' ? 0 : a == 'G' ? 1 : a == 'C' ? 2 : 3);
		int idx2 = (b == 'A' ? 0 : b == 'G' ? 1 : b == 'C' ? 2 : 3);
		return code[idx][idx2];
	}

	static char[][] code = { { 'A', 'C', 'A', 'G' }, { 'C', 'G', 'T', 'A' }, { 'A', 'T', 'C', 'G' },
			{ 'G', 'A', 'G', 'T' } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] target = sc.next().toCharArray();
		for (int i = target.length - 2; i >= 0; --i) {
			target[i] = getCode(target[i], target[i + 1]);
		}
		System.out.println(target[0]);
	}

}
