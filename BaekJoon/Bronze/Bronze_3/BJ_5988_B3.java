import java.util.*;
public class BJ_5988_B3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0;i<N;++i) {
			String input = sc.next();
			if((input.charAt(input.length()-1)-'0')%2 ==0) System.out.println("even");
			else System.out.println("odd");
		}
	}

}
