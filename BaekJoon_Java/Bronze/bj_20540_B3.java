package bronze;
import java.util.*;
public class bj_20540_B3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String mbti = sc.next();
		String rev = "";
		rev += mbti.charAt(0) == 'E' ? "I":"E";
		rev += mbti.charAt(1) == 'S' ? "N":"S";
		rev += mbti.charAt(2) == 'T' ? "F":"T";
		rev += mbti.charAt(3) == 'J' ? "P":"J";
		System.out.println(rev);
	}
		

}
