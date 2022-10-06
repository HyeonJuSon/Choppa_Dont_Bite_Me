import java.util.*;
public class BJ_23080_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		char[] input = sc.next().toCharArray();
		String answer ="";
		for(int i=0;i<input.length;i+=K) {
			answer += input[i];
		}
		System.out.println(answer);
	}

}
