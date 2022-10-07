import java.util.Scanner;

public class BJ_24883_B4 {

	static boolean isN(String now) {
		return now.equals("N") || now.equals("n");
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String now = sc.next();
		System.out.println(isN(now) ? "Naver D2" : "Naver Whale");
	}

}
