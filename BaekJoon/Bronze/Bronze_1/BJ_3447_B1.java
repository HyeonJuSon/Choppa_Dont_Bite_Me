import java.util.*;
public class BJ_3447_B1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()) {
			String input = sc.nextLine();
			while(input.contains("BUG")) input = input.replaceAll("BUG", "");
			sb.append(input).append('\n');
		}
		System.out.println(sb.toString());
	}

}
